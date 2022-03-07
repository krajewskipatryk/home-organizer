package pl.home.organizer.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pl.home.organizer.application.dto.CustomerDto;
import pl.home.organizer.application.model.request.CustomerRequestDataModel;
import pl.home.organizer.application.model.response.CustomerRest;
import pl.home.organizer.application.service.CustomerService;

@RequiredArgsConstructor
@RestController
@RequestMapping("dupa")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public String getCustomer() {
        return "My name is ... CZIKI CZIKI SLIM SHADY!";
    }

    @PostMapping
    public CustomerRest createCustomer(@RequestBody CustomerRequestDataModel userDetails)
    {
        CustomerRest returnValue = new CustomerRest();

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(userDetails, customerDto);

        CustomerDto createdUser = customerService.createCustomer(customerDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }
}
