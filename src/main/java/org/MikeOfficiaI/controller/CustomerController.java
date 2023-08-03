package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.exception.ContractNotFoundException;
import org.MikeOfficiaI.exception.CustomerNotFoundException;
import org.MikeOfficiaI.exception.VehicleNotFoundException;
import org.MikeOfficiaI.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/add")
    public String getCustomer(Model model) {
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers", customerList);
        return "newCustomer";
    }

    @PostMapping("/customer/save")
    public String postCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "The customer has been created successfully.");
        return "redirect:/contracts";
    }

    @RequestMapping("/customer/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Customer customer = customerService.get(id);
            model.addAttribute("customer", customer);
            return "updateCustomer";
        } catch (CustomerNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "The contract has been saved successfully.");
            return "redirect:/contracts";
        }
    }
}
