package com.rabobank.dexterslab.customerapi.repository;

import com.rabobank.dexterslab.customerapi.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
