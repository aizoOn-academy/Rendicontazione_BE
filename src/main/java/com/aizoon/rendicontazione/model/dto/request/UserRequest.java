package com.aizoon.rendicontazione.model.dto.request;

import com.aizoon.rendicontazione.model.dto.AbstractDTO;
import com.aizoon.rendicontazione.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter @Setter
public class UserRequest extends AbstractDTO<UserRequest, User> {
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull @Size(max = 30)
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull @Size(max = 30)
    private String surname;

    @NotBlank @Email @Size(max = 100)
    private String email;

    @NotBlank @Size(min = 8, max = 100)
    private String password;
}
