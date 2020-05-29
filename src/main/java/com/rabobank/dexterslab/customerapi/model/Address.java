package com.rabobank.dexterslab.customerapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String street;
    private String postCode;
    private String city;
    private String country;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
