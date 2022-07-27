package com.aizoon.rendicontazione.model.dto.request;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.AnnouncementApplication;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnnouncementApplicationRequest extends AbstractDTO<AnnouncementApplicationRequest, AnnouncementApplication> {

    @NotNull(message = "Approvation status is required")
    private boolean approvationStatus;

    private Double approvedMoneyAmount;

}
