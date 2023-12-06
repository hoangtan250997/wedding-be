package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.GuestEntity;
import com.personalproject.jarsmanagement.service.DTO.GuestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GuestMapper {
    GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    GuestDTO mapToDto(GuestEntity incomeSource);

    List<GuestDTO> mapToDtos(List<GuestEntity> incomeSourceList);


}