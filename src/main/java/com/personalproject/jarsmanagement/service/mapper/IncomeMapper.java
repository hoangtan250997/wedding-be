package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeMapper {
    IncomeMapper INSTANCE = Mappers.getMapper(IncomeMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "incomeSourceId", source = "incomeSource.id")
    IncomeDTO mapToDto(Income income);

    List<IncomeDTO> mapToDtos(List<Income> incomes);

}
