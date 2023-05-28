package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Assign;
import com.personalproject.jarsmanagement.entity.SpendingLimit;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingLimitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpendingLimitMapper {
    SpendingLimitMapper INSTANCE = Mappers.getMapper(SpendingLimitMapper.class);

    @Mapping(target = "moneyJarId", source = "moneyJar.id")
    SpendingLimitDTO mapToDto(SpendingLimit spendingLimit);

    List<SpendingLimitDTO> mapToDtos(List<SpendingLimit> spendingLimits);


}