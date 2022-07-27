package com.aizoon.rendicontazione.model.dto.request;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.Request;
import com.aizoon.rendicontazione.model.entity.Operator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
public class RequestRequest extends AbstractDTO<RequestRequest, Request> {

    @NotNull
    private Long id;

    @NotNull
    private Operator operator;

    @NotNull
    private Long announcementID;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull
    @Size(max = 16)
    private String applicantFiscalCode;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @NotNull
    @Size(max = 30)
    private String applicantName;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @NotNull
    @Size(max = 30)
    private String applicantSurname;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull @Size(max = 50)
    private String applicantAddress;

    @Pattern(regexp = "^[0-9]*$")
    @NotNull @Size(max = 5)
    private String applicantCityCap;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @NotNull @Size(max = 30)
    private String applicantCity;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @NotNull @Size(max = 30)
    private String applicantNation;

    @Pattern(regexp = "^[0-9]*$")
    @NotNull @Size(max = 10)
    private String applicantPhone;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull @Size(max = 27)
    private String applicantIban;

    @NotNull
    private double moneyAmount;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull @Size(max = 516)
    private String note;

    private Double moneyAmountFinale;

    private Boolean approvationStatus;

    @AssertTrue(message = "Importo Finale deve essere minore o uguale all'importo iniziale")
    public boolean isImportoFinaleCorrect(){
        return this.moneyAmountFinale == null || this.moneyAmountFinale<=this.moneyAmount;
    }

    @AssertTrue(message = "Se e stato approvato allora l'importo finale deve essere specificato")
    public boolean ifApprovedThenImportoFinale(){
        return !this.approvationStatus || this.moneyAmountFinale!=null;
    }
}
