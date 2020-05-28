package com.rabobank.dexterslab.customerapi.controller;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping
    public ResponseEntity getAllCustomer() {
        return ResponseEntity.status(HttpStatus.OK).body("getAllCustomer");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(new CustomerDTO());
    }

    @PostMapping
    public ResponseEntity saveCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) throws URISyntaxException {

//        @TODO fix it
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        return ResponseEntity.created(new URI("User is valid")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody @Valid CustomerDTO customerDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(new CustomerDTO());
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateCustomerAddress(@RequestBody @Valid CustomerDTO customerDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
