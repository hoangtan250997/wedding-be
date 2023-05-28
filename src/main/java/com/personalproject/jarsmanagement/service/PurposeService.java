package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Purpose;

import java.util.List;

public interface PurposeService {
    Purpose findPurposeById(int id);

    List<Purpose> findAllPurpose();

    Purpose createPurpose(String name, int accountId);
}
