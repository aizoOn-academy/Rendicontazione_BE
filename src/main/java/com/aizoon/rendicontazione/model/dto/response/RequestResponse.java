package com.aizoon.rendicontazione.model.dto.response;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.Request;
import com.aizoon.rendicontazione.model.entity.Operator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestResponse extends AbstractDTO<RequestResponse, Request> {
    private Long id;
    private Operator operator;
    private Long announcementID;
    private String applicantFiscalCode;
    private String applicantName;
    private String applicantSurname;
    private String applicantAddress;
    private String applicantCityCap;
    private String applicantCity;
    private String applicantNation;
    private String applicantPhone;
    private String applicantIban;
    private String moneyAmount;
    private String note;
}
