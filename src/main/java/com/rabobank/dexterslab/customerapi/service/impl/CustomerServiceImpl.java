package com.rabobank.dexterslab.customerapi.service.impl;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;
import com.rabobank.dexterslab.customerapi.model.Customer;
import com.rabobank.dexterslab.customerapi.repository.CustomerRepository;
import com.rabobank.dexterslab.customerapi.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Iterable<CustomerDTO> findAll() {
        return convertToDTO(repository.findAll());
    }

    @Override
    public CustomerDTO findById(Integer id) {
        return convertToDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No customer found for id: " + id)));
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return convertToDTO(repository.save(convertToEntity(customerDTO)));
    }

    @Override
    public CustomerDTO update(CustomerDTO dto, Integer id) {
        CustomerDTO existentCustomer = findById(id);
        return convertToDTO(repository.save(convertToEntity(buildUpdateCustomer(dto, existentCustomer))));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No customer found for id: " + id)));
    }

    private Customer convertToEntity(CustomerDTO person) {
        return mapper.map(person, Customer.class);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        return mapper.map(customer, CustomerDTO.class);
    }

    private Iterable<CustomerDTO> convertToDTO(Iterable<Customer> customers) {
        return Arrays.asList(mapper.map(customers, CustomerDTO[].class));
    }

    private CustomerDTO buildUpdateCustomer(CustomerDTO dto, CustomerDTO existentCustomer) {
        return CustomerDTO.builder()
                .id(existentCustomer.getId())
                .firstName(StringUtils.isEmpty(dto.getFirstName()) ? existentCustomer.getFirstName() : dto.getFirstName())
                .lastName(StringUtils.isEmpty(dto.getLastName()) ? existentCustomer.getLastName() : dto.getLastName())
                .age(dto.getAge() == null ? existentCustomer.getAge() : dto.getAge())
                .dateOfBirth(StringUtils.isEmpty(dto.getDateOfBirth()) ? existentCustomer.getDateOfBirth() : dto.getDateOfBirth())
                .currentAddress(StringUtils.isEmpty(dto.getCurrentAddress()) ? existentCustomer.getCurrentAddress() : dto.getCurrentAddress())
                .build();
    }

}
