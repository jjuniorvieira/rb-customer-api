package com.rabobank.dexterslab.customerapi.service;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;
import com.rabobank.dexterslab.customerapi.model.Customer;


public interface CustomerService {

    Iterable<CustomerDTO> findAll();

    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO findById(Integer id);

    CustomerDTO update(CustomerDTO dto, Integer id);

}
