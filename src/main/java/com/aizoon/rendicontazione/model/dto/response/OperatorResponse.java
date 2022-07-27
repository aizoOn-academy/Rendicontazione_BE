package com.aizoon.rendicontazione.model.dto.response;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.Operator;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OperatorResponse extends AbstractDTO<OperatorResponse, Operator> {
    
    private Long operatorId;
    private String username;

}
