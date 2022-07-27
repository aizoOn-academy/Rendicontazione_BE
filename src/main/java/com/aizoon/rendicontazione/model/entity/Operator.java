package com.aizoon.rendicontazione.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "RE_Operators")
public class Operator {
    @Id
    @Column(name = "operator_id", nullable = false)
    private Long operatorId;

    @Column(name = "username", nullable = false)
    private String username;
}
