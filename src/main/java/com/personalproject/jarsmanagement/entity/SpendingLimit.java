package com.personalproject.jarsmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private LocalTime existingTime;
    @ManyToOne
    @JoinColumn(name="jar_id")
    private Jars jar;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
