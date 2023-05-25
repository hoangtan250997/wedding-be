package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Assign;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;

public interface AssignService {
    Assign createAssign(AssignDTO assignDTO);
}
