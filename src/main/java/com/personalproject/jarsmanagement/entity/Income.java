package com.personalproject.jarsmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amount;
    @CreationTimestamp
    private LocalDate receivedTime;
    @OneToOne
    @JoinColumn(name = "income_source_id")
    private IncomeSource incomeSource;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}