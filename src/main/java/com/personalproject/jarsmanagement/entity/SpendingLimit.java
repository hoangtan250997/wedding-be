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
public class SpendingLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;
    @CreationTimestamp
    private LocalDate createdDate;
    private LocalDate expirationDate;
    @ManyToOne
    @JoinColumn(name="moneyJar_id")
    private MoneyJar moneyJar;


}
