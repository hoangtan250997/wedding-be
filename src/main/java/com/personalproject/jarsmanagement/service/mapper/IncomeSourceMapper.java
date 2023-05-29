package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Assign;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeSourceMapper {
    IncomeSourceMapper INSTANCE = Mappers.getMapper(IncomeSourceMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "accountId", source = "account.id")
    IncomeSourceDTO mapToDto(IncomeSource incomeSource);

    List<IncomeSourceDTO> mapToDtos(List<IncomeSource> incomeSourceList);


}