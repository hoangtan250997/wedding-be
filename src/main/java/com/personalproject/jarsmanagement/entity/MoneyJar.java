package com.personalproject.jarsmanagement.entity;

import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Convert(converter = JarTypeAttributeConverter.class)
    private JarType jarType;

    private Double balance;

    private double percentage;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
}
