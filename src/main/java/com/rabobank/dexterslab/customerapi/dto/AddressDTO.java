package com.rabobank.dexterslab.customerapi.dto;

import com.rabobank.dexterslab.customerapi.model.Customer;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO implements Serializable {

    private Integer id;

    @NotNull(message = "Street name is mandatory")
    private String street;

    private String postCode;
    private String city;
    private String country;

}
