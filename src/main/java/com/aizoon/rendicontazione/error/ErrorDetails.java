package com.aizoon.rendicontazione.error;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = new Date();
    }

}
