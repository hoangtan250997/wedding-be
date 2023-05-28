package com.personalproject.jarsmanagement.entity;

import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyJar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Convert(converter = JarTypeAttributeConverter.class)
    private JarType jarType;

    private Double balance;

    private double percentage;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
}
