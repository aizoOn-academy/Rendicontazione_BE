package com.aizoon.rendicontazione.model.dto.response;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.Announcement;
import com.aizoon.rendicontazione.model.entity.AnnouncementApplication;
import com.aizoon.rendicontazione.model.entity.Operator;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnnouncementApplicationResponse extends AbstractDTO<AnnouncementApplicationResponse, AnnouncementApplication> {
    
    private Long announcementApplicationId;
    private OperatorResponse operator;
    private AnnouncementResponse announcement;
    private String applicantFiscalCode;
    private String applicantName;
    private String applicantSurname;
    private String applicantAddress;
    private String applicantCityCap;
    private String applicantCity;
    private String applicantNation;
    private String applicantPhone;
    private String applicantIban;
    private Double moneyAmount;
    private Double approvedMoneyAmount;
    private Boolean approvationStatus;
    private String note;

    public void setOperator(Operator operator) {
        this.operator = new OperatorResponse().from(operator);
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = new AnnouncementResponse().from(announcement);
    }

}
