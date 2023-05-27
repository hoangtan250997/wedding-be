package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MoneyJarMapper {
@Mapping(target = "accountId",source = "account.id")
MoneyJarDTO mapToDto(MoneyJar moneyJar);

    List<MoneyJarDTO> mapToDtos(List<MoneyJar> moneyJarList);

}
