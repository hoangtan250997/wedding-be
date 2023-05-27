package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.Role;
import com.personalproject.jarsmanagement.entity.UserRoleAssignment;
import com.personalproject.jarsmanagement.service.DTO.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Named("convert")
    public static List<Role> convert(List<UserRoleAssignment> roleAssignmentList) {
        return roleAssignmentList.stream()
                .map(UserRoleAssignment::getRole)
                .collect(Collectors.toList());
    }
    @Mapping(target = "username",source = "user.username")
    @Mapping(target = "password",source = "user.password")
    @Mapping(target = "active",source = "user.active")
    @Mapping(target = "roles", source = "user.roles", qualifiedByName = "convert")
    AccountDTO mapToDto(Account account);

    List<AccountDTO> mapToDtos(List<Account> accounts);
}
