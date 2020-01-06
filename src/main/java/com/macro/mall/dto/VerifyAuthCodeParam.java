package com.macro.mall.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class VerifyAuthCodeParam {
    private String telephone;
    @JsonProperty("auth_code")
    private String authCode;
}
