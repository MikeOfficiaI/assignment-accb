package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/addCustomer")
    public String postCustomer(Model model) {
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers", customerList);
        return "newCustomer";
    }

    @PostMapping("/saveCustomer")
    public String postVehicle(@ModelAttribute Customer customer) {
        System.out.println(customer.toString());
        customerService.saveCustomer(customer);
        return "newCustomer";
    }

    @GetMapping("/getCustomer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
