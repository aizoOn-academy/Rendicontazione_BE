package com.aizoon.rendicontazione.model.dto.response;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse extends AbstractDTO<UserResponse, User> {
    private Long id;
    private String name;
    private String surname;
    private String email;

    @JsonIgnore
    private String password;
}
