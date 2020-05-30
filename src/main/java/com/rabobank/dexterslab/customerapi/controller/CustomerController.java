package com.rabobank.dexterslab.customerapi.controller;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;
import com.rabobank.dexterslab.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("list")
    public ResponseEntity<Iterable<CustomerDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping("create")
    public ResponseEntity save(@Valid @RequestBody CustomerDTO customerDTO) throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(customerDTO));
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(customerDTO, id));
    }

    @PatchMapping("update-address/{id}")
    public ResponseEntity partialUpdate(@RequestBody String address, @PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(CustomerDTO.builder().currentAddress(address).build(), id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully");
    }

}
