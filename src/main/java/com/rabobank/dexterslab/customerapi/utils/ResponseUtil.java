package com.rabobank.dexterslab.customerapi.utils;

import com.rabobank.dexterslab.customerapi.dto.ErrorDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ResponseUtil {

    public static final String PERSISTENCE_FAILED = "Persistence failed";

    public static ErrorDTO setErrorMessage(BindingResult bindingResult) {


        List<FieldError> errors = bindingResult.getFieldErrors();
        List<String> message = new ArrayList<>();

        for (FieldError e : errors) {
            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
        }

        return ErrorDTO.builder()
                .code(400)
                .message(PERSISTENCE_FAILED)
                .message(message.toString())
                .action("Please check the(se) field(s)").build();

    }
}
