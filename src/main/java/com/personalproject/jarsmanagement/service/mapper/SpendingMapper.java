package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpendingMapper {
    SpendingMapper INSTANCE = Mappers.getMapper(SpendingMapper.class);

    @Mapping(target = "accountId", source = "account.id")
    @Mapping(target = "moneyJarId", source = "moneyJar.id")
    SpendingDTO mapToDto(Spending spending);

    List<SpendingDTO> mapToDtos(List<Spending> spendings);

}
