package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.*;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {JarTypeAttributeConverter.class})
public interface MoneyJarMapper {
    MoneyJarMapper INSTANCE = Mappers.getMapper(MoneyJarMapper.class);


    @Mapping(target = "jarType", source = "moneyJar.jarType")
    @Mapping(target = "accountId", source = "account.id")
    MoneyJarDTO mapToDto(MoneyJar moneyJar);

    List<MoneyJarDTO> mapToDtos(List<MoneyJar> moneyJarList);


}