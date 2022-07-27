package com.aizoon.rendicontazione.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "RE_Requests")
public class Operator {
    @Id
    @Column(name = "operatore_id", nullable = false)
    private Long operatorId;

    @Column(name = "username", nullable = false)
    private String username;

    @OneToMany(mappedBy="operator")
    private List<Request> request;
}
