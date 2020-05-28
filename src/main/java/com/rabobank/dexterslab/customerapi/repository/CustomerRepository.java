package com.rabobank.dexterslab.customerapi.repository;

import com.rabobank.dexterslab.customerapi.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long> {

}
