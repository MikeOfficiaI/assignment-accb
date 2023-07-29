package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Customer;
import org.MikeOfficiaI.model.Vehicle;
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

    @GetMapping("/index")
    public String index(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/addCustomer")
    public String postCustomer(Model model) {
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("contracts", customerList);
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
