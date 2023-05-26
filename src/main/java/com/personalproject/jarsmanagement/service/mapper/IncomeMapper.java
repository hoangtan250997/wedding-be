package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
@Mapping(target = "incomeSourceId",source = "incomeSource.id")
    IncomeDTO mapToDto(Income income);

    List<IncomeDTO> mapToDtos(List<Income> incomes);

}
