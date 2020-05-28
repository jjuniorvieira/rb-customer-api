package com.rabobank.dexterslab.customerapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"firstName", "lastName"}))
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String currentAddress;

}
