package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.service.MoneyJarService;
import lombok.RequiredArgsConstructor;
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

class MoneyJarServiceImplTest {
    @Autowired
    MoneyJarService moneyJarService;

    @Test
    void createJars() {
    }

    @Test
    void increaseBalance() {
    }

    @Test
    void decreaseBalance() {
    }

    @Test
    void getBalance() {
        assertTrue(moneyJarService.getBalance(1,1)==350);
    }

    @Test
    void findByAccountIAndJarType() {
    }
}