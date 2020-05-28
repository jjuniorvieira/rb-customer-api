package com.rabobank.dexterslab.customerapi.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class ErrorDTO {

    private int code;
    private String message;
    private String cause;

}
