package com.rabobank.dexterslab.customerapi.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ErrorDTO implements Serializable {

    private int code;
    private String message;

}
