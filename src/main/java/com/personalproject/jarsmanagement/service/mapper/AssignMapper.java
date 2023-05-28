package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Assign;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignMapper {
    AssignMapper INSTANCE = Mappers.getMapper(AssignMapper.class);


//    @Mapping(target = "accountId", source = "account.id")
    AssignDTO mapToDto(Assign assign);

    List<AssignDTO> mapToDtos(List<Assign> assignList);


}