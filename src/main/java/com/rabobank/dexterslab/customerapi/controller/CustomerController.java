package com.rabobank.dexterslab.customerapi.controller;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

import static com.rabobank.dexterslab.customerapi.utils.ResponseUtil.setErrorMessage;

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
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(setErrorMessage(bindingResult));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@RequestBody @Valid CustomerDTO customerDTO,
                                         BindingResult bindingResult, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(setErrorMessage(bindingResult));

        return ResponseEntity.status(HttpStatus.OK).body(new CustomerDTO());
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateCustomerAddress(@RequestBody @Valid CustomerDTO customerDTO,
                                                BindingResult bindingResult, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(setErrorMessage(bindingResult));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
