package com.rabobank.dexterslab.customerapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO implements Serializable {

    private Integer id;

    @NotNull(message = "First Name is mandatory")
    private String firstName;

    @NotNull(message = "Last Name is mandatory")
    private String lastName;

    @NotNull(message = "Age is mandatory")
    @Positive(message = "Age is not valid")
    private Integer age;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotNull(message = "Current address is mandatory")
    private String currentAddress;

}
