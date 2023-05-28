package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.Cau2;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Cau2Mapper {
    Cau2Mapper INSTANCE = Mappers.getMapper(Cau2Mapper.class);

//    @Mapping(target = "amount", source = "amount")
//    @Mapping(target = "name", source = "income.name")
    Cau2 mapToDto(Income income);

    List<Cau2> mapToDtos(List<Income> income);

}
