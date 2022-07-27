package com.aizoon.rendicontazione.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "RE_AnnouncementApplications")
public class AnnouncementApplication {
    @Id
    @Column(name = "announcement_application_id", nullable = false)
    private Long announcementApplicationId;

    @ManyToOne @JoinColumn(name = "operator_id")
    private Operator operator;

    @ManyToOne @JoinColumn(name = "announcement_id")
    private Announcement announcement;

    @Column(name = "applicant_fiscal_code", nullable = false)
    private String applicantFiscalCode;

    @Column(name = "applicant_name", nullable = false)
    private String applicantName;

    @Column(name = "applicant_surname", nullable = false)
    private String applicantSurname;

    @Column(name = "applicant_address", nullable = false)
    private String applicantAddress;

    @Column(name = "applicant_city_cap", nullable = false)
    private String applicantCityCap;

    @Column(name = "applicant_city", nullable = false)
    private String applicantCity;

    @Column(name = "applicant_nation", nullable = false)
    private String applicantNation;

    @Column(name = "applicant_phone", nullable = false)
    private String applicantPhone;

    @Column(name = "applicant_iban", nullable = false)
    private String applicantIban;

    @Column(name = "money_amount", nullable = false)
    private Double moneyAmount;

    @Column(name = "approved_money_amount", nullable = true)
    private Double approvedMoneyAmount;

    @Column(name = "note", nullable = false)
    private String note;

    @Column(name = "approvation_status", nullable = false)
    private Boolean approvationStatus;
}
