package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.MoneyJarRepository;
import com.personalproject.jarsmanagement.repository.SpendingRepository;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO;
import com.personalproject.jarsmanagement.service.DTO.Spending.PurposeDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.SpendingService;
import com.personalproject.jarsmanagement.service.mapper.SpendingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpendingServiceImpl implements SpendingService {

    final private SpendingRepository spendingRepository;
    final private MoneyJarRepository moneyJarRepository;
    final private AccountRepository accountRepository;
    final private AccountService accountService;
    final private MoneyJarService moneyJarService;


    @Override
    public SpendingDTO createSpending(SpendingDTO spendingDTO, int accountId) {
        log.info("CREATE SPENDING");


        //Check Jar Balance
        Double jarBalance = moneyJarRepository.findById(spendingDTO.getMoneyJarId()).get().getBalance();
        if (spendingDTO.getAmount() > jarBalance) throw JarsManagementException.OverLimit();

        //Create a spending
        Spending spending = new Spending();
        spending.setAmount(spendingDTO.getAmount());

        //Update date if user don't want to input
        if (spendingDTO.getSpendingTime() == null) {
            spending.setSpendingTime(LocalDate.now());
        } else spending.setSpendingTime(spendingDTO.getSpendingTime());

        spending.setPurpose(spendingDTO.getPurpose());
        spending.setMoneyJar(moneyJarRepository.findById(spendingDTO.getMoneyJarId()).get());
        spending.setAccount(accountRepository.findById(accountId).orElseThrow(JarsManagementException::AccountNotFound));

        //Create AssignDTO for decreaseBalance MoneyJar
        AssignDTO assignDTO = new AssignDTO();
        assignDTO.setAmount(spending.getAmount());
        assignDTO.setAccountId(accountId);
        assignDTO.setMoneyJarId(spending.getMoneyJar().getId());
        assignDTO.setJarType(spending.getMoneyJar().getJarType());

        //decreaseBalance for moneyJar
        moneyJarService.decreaseBalance(assignDTO);

        return SpendingMapper.INSTANCE.mapToDto(spendingRepository.save(spending));
    }

    @Override
    public List<JarDTO> listJarsBetweenTwoDays(LocalDate start, LocalDate end) {
        return spendingRepository.listJarsBetweenTwoDays(start, end);
    }

    @Override
    public List<JarDTO> listJarsByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, String token, int topNumber) {

        int accountId = accountService.getAccountFromToken(token).getId();

        return spendingRepository.listJarsByAccountIdBetweenTwoDays(start, end, accountId).stream()
                .limit(topNumber)
                .collect(Collectors.toList());
    }

    @Override
    public List<PurposeDTO> listPurposeByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, int accountId) {
        return spendingRepository.listPurposeByAccountIdBetweenTwoDays(start, end, accountId);
    }

    @Override
    public List<SpendingDTO> getSpendingListByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, int accountId) {
        return SpendingMapper.INSTANCE.mapToDtos(spendingRepository.getSpendingListByAccountIdBetweenTwoDays(start, end, accountId));
    }

    public void exportExcelFile(LocalDate start, LocalDate end, int accountId) throws IllegalAccessException {

        List<SpendingDTO> spendingList = SpendingMapper.INSTANCE.mapToDtos(spendingRepository.getSpendingListByAccountIdBetweenTwoDays(start, end, accountId));

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("Spending Data");

        Row row = sheet.createRow(0);
        int cellnum = 0;
        String[] titles = {"id", "amount", "spendingTime", "purpose", "jarType"};
        for (String title : titles
        ) {
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(title);
        }

        Map<String, SpendingDTO> data = new TreeMap<String, SpendingDTO>();

        for (int i = 0; i < spendingList.size(); i++) {
            data.put(String.valueOf(i), spendingList.get(i));
        }
        Set<String> keyset = data.keySet();
        int rownum = 1;
        for (String key : keyset) {
            row = sheet.createRow(rownum++);
            SpendingDTO objArr = data.get(key);
            cellnum = 0;
            Class<? extends SpendingDTO> clazz = objArr.getClass();
            for (Field field : clazz.getDeclaredFields()
            ) {
                field.setAccessible(true);
                Object value = field.get(objArr);

                if (!field.getName().equals("accountId") && !field.getName().equals("moneyJarId")) {
                    Cell cell = row.createCell(cellnum++);
                    cell.setCellValue(value.toString());
                }
            }
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String fileName = "spendinglist" + currentTimeMillis + ".xlsx";
            FileOutputStream out = new FileOutputStream(new File(fileName));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<PurposeDTO> listPurposeByAccountIdByMonthNumber(int accountId, int monthNum) {
        return spendingRepository.listPurposeByAccountIdByMonthNumber(accountId, monthNum);
    }


}
