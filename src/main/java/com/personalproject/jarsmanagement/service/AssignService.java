package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Assign;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;

import java.util.List;

public interface AssignService {
    List<Assign> createAssign(int incomeId);


}
