package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Customer;
import org.MikeOfficiaI.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/getVehicle")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
