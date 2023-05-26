package com.personalproject.jarsmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;
    @CreationTimestamp
    private LocalTime assignedTime;

    @ManyToOne
    @JoinColumn(name="jar_id")
    private Jars jars;

    @ManyToOne
    @JoinColumn(name = "income_id")
    private Income income;

}
