package org.MikeOfficiaI.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.exception.ContractNotFoundException;
import org.MikeOfficiaI.exception.CustomerNotFoundException;
import org.MikeOfficiaI.exception.VehicleNotFoundException;
import org.MikeOfficiaI.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Api(description = "Controller for the customer entity")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/add")
    @ApiOperation("Get list of all customers and viewing the creating new customer page")
    public String getCustomer(Model model) {
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers", customerList);
        return "newCustomer";
    }

    @PostMapping("/customer/save")
    @ApiOperation("Saving new customer")
    public String postCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "The customer has been created successfully.");
        return "redirect:/contracts";
    }

    @GetMapping("/customer/get/{id}")
    @ApiOperation("Getting specific customer")
    public Customer getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

    @RequestMapping("/customer/update/{id}")
    @ApiOperation("Update specific customer")
    public String showUpdateForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Customer customer = customerService.getCustomerById(id);
            model.addAttribute("customer", customer);
            List<Contract> contractList = customer.getContractList();
            model.addAttribute("contract", contractList);
            return "updateCustomer";
        } catch (CustomerNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "The contract has been saved successfully.");
            return "redirect:/contracts";
        }
    }
}
