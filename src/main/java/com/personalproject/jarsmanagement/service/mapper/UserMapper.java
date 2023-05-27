package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Role;
import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.entity.UserRoleAssignment;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import jdk.jfr.Name;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Mapper
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Named("convert")
    public static List<Role> convert(List<UserRoleAssignment> roleAssignmentList) {
        return roleAssignmentList.stream()
                .map(UserRoleAssignment::getRole)
                .collect(Collectors.toList());
     }
    @Mapping(target = "roles", source = "user.roles", qualifiedByName = "convert")
    UserDTO mapToDto(User user);

    List<UserDTO> mapToDtos(List<User> users);


}
