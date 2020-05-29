package com.rabobank.dexterslab.customerapi.service;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;


public interface CustomerService {

    Iterable<CustomerDTO> findAll();

    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO findById(Integer id);

    CustomerDTO update(CustomerDTO dto, Integer id);

    void delete(Integer id);
}
