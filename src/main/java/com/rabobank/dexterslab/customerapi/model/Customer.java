package com.rabobank.dexterslab.customerapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastName"}))
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String firstName;
    private String lastName;
    private Integer age;
    private Date dateOfBirth;
    private String currentAddress;

}
