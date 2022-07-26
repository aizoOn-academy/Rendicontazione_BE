package com.aizoon.rendicontazione.model.dto.response;

import java.time.LocalDate;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.Announcement;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnnouncementResponse extends AbstractDTO<AnnouncementResponse, Announcement> {

    private Long announcementID;

    private String code;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

}
