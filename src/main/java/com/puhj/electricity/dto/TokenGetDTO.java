package com.puhj.electricity.dto;

import com.puhj.electricity.core.enumeration.LoginType;
import com.puhj.electricity.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenGetDTO {
    @NotBlank(message = "account不允许为空")
    private String account;
    @TokenPassword(max=30, message = "{token.password}")
    private String password;
    private LoginType type;
}
