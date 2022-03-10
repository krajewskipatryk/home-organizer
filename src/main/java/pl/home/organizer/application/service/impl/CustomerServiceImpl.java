package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.CustomerDto;
import pl.home.organizer.application.entity.CustomerEntity;
import pl.home.organizer.application.repository.CustomerRepository;
import pl.home.organizer.application.service.CustomerService;
import pl.home.organizer.application.utils.UserIdGenerator;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserIdGenerator userIdGenerator;

    @Override
    public CustomerDto createCustomer(CustomerDto customer) {

        if (customerRepository.findByEmail(customer.getEmail()) != null) throw new RuntimeException("The email address already exists!");

        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);

        customerEntity.setUserId(userIdGenerator.generateUserId(30));
        customerEntity.setEncryptedPassword("test");

        customerRepository.save(customerEntity);

        CustomerDto returnValue = new CustomerDto();
        BeanUtils.copyProperties(customerEntity, returnValue);

        return returnValue;
    }
}