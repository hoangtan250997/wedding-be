package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeDetailsMapper {
    IncomeDetailsMapper INSTANCE = Mappers.getMapper(IncomeDetailsMapper.class);

//    @Mapping(target = "id", source = "id")
    @Mapping(target = "accountId", source = "incomeSource.account.id")
    @Mapping(target = "incomeSourceName", source = "incomeSource.name")
//    @Mapping(target = "receivedTime", source = "receivedTime")
    IncomeDetailsDTO mapToDto(Income income);
    List<IncomeDetailsDTO> mapToDtos(List<Income> incomes);

}
