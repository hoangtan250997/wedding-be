package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.service.IncomeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class IncomeServiceImplTest {

    @Autowired
    IncomeService incomeService;

    @Test
    void findByIncomeSourceIdAndUserId() {

        assertTrue(incomeService.findByIncomeSourceIdAndUserId(1, 2).size() == 5);

    }
}