package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.CustomerDto;
import pl.home.organizer.application.entity.CustomerEntity;
import pl.home.organizer.application.repository.CustomerRepository;
import pl.home.organizer.application.service.CustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customer) {

        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);

        customerEntity.setUserId("123");
        customerEntity.setEncryptedPassword("test");

        CustomerEntity storedUserDetails = customerRepository.save(customerEntity);

        CustomerDto returnValue = new CustomerDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}