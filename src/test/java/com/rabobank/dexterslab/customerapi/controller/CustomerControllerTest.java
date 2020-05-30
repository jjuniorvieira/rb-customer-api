package com.rabobank.dexterslab.customerapi.controller;

import com.rabobank.dexterslab.customerapi.dto.CustomerDTO;
import com.rabobank.dexterslab.customerapi.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService service;

    @InjectMocks
    private CustomerController controller;

    private List<CustomerDTO> customers;

    @Before
    public void setup() {
        customers = mockCustomerData();
    }

    @Test
    public void shouldReturnAllCustomer() {
        when(service.findAll()).thenReturn(customers);

        ResponseEntity response = controller.findAll();
        List<CustomerDTO> customerDTOS = (List<CustomerDTO>) response.getBody();

        assertEquals(customerDTOS, customers);
        assertEquals(3, customers.size());
    }

    @Test
    public void shouldReturnFirstCustomer() {
        CustomerDTO dtoMock = customers.get(0);
        when(service.findById(anyInt())).thenReturn(dtoMock);

        ResponseEntity response = controller.findById(1);
        CustomerDTO expectedCustomer = (CustomerDTO) response.getBody();

        assertEquals(expectedCustomer.getId(), dtoMock.getId());
        assertEquals(expectedCustomer.getFirstName(), dtoMock.getFirstName());
        assertEquals(expectedCustomer.getLastName(), dtoMock.getLastName());
        assertEquals(expectedCustomer.getAge(), dtoMock.getAge());
        assertEquals(expectedCustomer.getDateOfBirth(), dtoMock.getDateOfBirth());
        assertEquals(expectedCustomer.getCurrentAddress(), dtoMock.getCurrentAddress());

    }

    @Test
    public void shouldSaveSuccessfullyOneCustomer() throws URISyntaxException {
        CustomerDTO dtoMock = mockFirstCustomerData(0);
        when(service.save(anyObject())).thenReturn(dtoMock);

        ResponseEntity response = controller.save(CustomerDTO.builder().build());
        CustomerDTO expectedCustomer = (CustomerDTO) response.getBody();

        assertEquals(expectedCustomer.getId(), dtoMock.getId());
        assertEquals(expectedCustomer.getFirstName(), dtoMock.getFirstName());
        assertEquals(expectedCustomer.getLastName(), dtoMock.getLastName());
        assertEquals(expectedCustomer.getAge(), dtoMock.getAge());
        assertEquals(expectedCustomer.getDateOfBirth(), dtoMock.getDateOfBirth());
        assertEquals(expectedCustomer.getCurrentAddress(), dtoMock.getCurrentAddress());

    }

    @Test
    public void shouldUpdateSuccessfullyOneCustomer() throws URISyntaxException {
        CustomerDTO dtoMock = mockFirstCustomerData(1);
        when(service.update(anyObject(), anyInt())).thenReturn(dtoMock);

        ResponseEntity response = controller.update(CustomerDTO.builder().build(), 1);
        CustomerDTO expectedCustomer = (CustomerDTO) response.getBody();

        assertEquals(expectedCustomer.getId(), dtoMock.getId());
        assertEquals(expectedCustomer.getFirstName(), dtoMock.getFirstName());
        assertEquals(expectedCustomer.getLastName(), dtoMock.getLastName());
        assertEquals(expectedCustomer.getAge(), dtoMock.getAge());
        assertEquals(expectedCustomer.getDateOfBirth(), dtoMock.getDateOfBirth());
        assertEquals(expectedCustomer.getCurrentAddress(), dtoMock.getCurrentAddress());

    }

    @Test
    public void shouldUpdateOneFieldSuccessfullyOneCustomer() throws URISyntaxException {
        CustomerDTO dtoMock = mockFirstCustomerData(1);
        dtoMock.setFirstName("JJ");
        when(service.update(anyObject(), anyInt())).thenReturn(dtoMock);

        ResponseEntity response = controller.partialUpdate("My new address", 1);
        CustomerDTO expectedCustomer = (CustomerDTO) response.getBody();

        assertEquals(expectedCustomer.getId(), dtoMock.getId());
        assertEquals(expectedCustomer.getFirstName(), "JJ");
        assertEquals(expectedCustomer.getLastName(), dtoMock.getLastName());
        assertEquals(expectedCustomer.getAge(), dtoMock.getAge());
        assertEquals(expectedCustomer.getDateOfBirth(), dtoMock.getDateOfBirth());
        assertEquals(expectedCustomer.getCurrentAddress(), dtoMock.getCurrentAddress());

    }

    @Test
    public void shouldDeleteSuccessfullyOneCustomer() throws URISyntaxException {
        doNothing().when(service).delete(anyInt());
        ResponseEntity response = controller.delete(1);
        assertEquals((String) response.getBody(), "Customer deleted successfully");
    }


    private List<CustomerDTO> mockCustomerData() {
        return asList(
                CustomerDTO.builder()
                        .id(1)
                        .firstName("First Name F1")
                        .lastName("Last Name L1")
                        .age(31)
                        .dateOfBirth(java.sql.Date.valueOf(LocalDate.of(1988, Month.SEPTEMBER, 15)))
                        .currentAddress("Geuzenstraat 35II, Amsterdam, NL")
                        .build(),
                CustomerDTO.builder()
                        .id(2)
                        .firstName("First Name F2")
                        .lastName("Last Name L2")
                        .age(30)
                        .dateOfBirth(java.sql.Date.valueOf(LocalDate.of(1989, Month.SEPTEMBER, 15)))
                        .currentAddress("Geuzenstraat 35II, Amsterdam, NL")
                        .build(),
                CustomerDTO.builder()
                        .id(3)
                        .firstName("First Name F3")
                        .lastName("Last Name L3")
                        .age(29)
                        .dateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, Month.SEPTEMBER, 15)))
                        .currentAddress("Geuzenstraat 35II, Amsterdam, NL")
                        .build()
        );
    }

    private CustomerDTO mockFirstCustomerData(Integer index) {
        return customers.get(index);
    }

}
