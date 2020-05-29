package com.rabobank.dexterslab.customerapi.controller;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;
import com.rabobank.dexterslab.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

import static com.rabobank.dexterslab.customerapi.utils.ResponseUtil.setErrorMessage;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<Iterable<CustomerDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) throws URISyntaxException {
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(setErrorMessage(bindingResult));

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(customerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult , @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(setErrorMessage(bindingResult));

        return ResponseEntity.status(HttpStatus.OK).body(service.update(customerDTO,id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity partialUpdate(@RequestBody CustomerDTO customerDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.update(customerDTO,id));
    }

}
