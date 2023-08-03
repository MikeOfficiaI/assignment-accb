package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.exception.ContractNotFoundException;
import org.MikeOfficiaI.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    public String index(Model model) {
        List<Contract> contractList = contractService.listAll();
        model.addAttribute("contracts", contractList);
        return "contracts";
    }

    @GetMapping("/contract/add")
    public String postContract(Model model) {
        List<Contract> contractList = contractService.listAll();
        model.addAttribute("contracts", contractList);
        List<ContractDto> contractVehicle = contractService.getContractVehicleJoin();
        model.addAttribute("vehcontracts", contractVehicle);
        List<ContractDto> contractCustomer = contractService.getContractCustomerJoin();
        model.addAttribute("cuscontracts", contractCustomer);
        return "newContract";
    }

    @PostMapping("/contract/save")
    public String saveContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        contractService.saveContract(contract);
        redirectAttributes.addFlashAttribute("message", "The contract has been created successfully.");
        return "redirect:/contracts";
    }

    @RequestMapping("/delete/{id}")
    public String deleteContract(@PathVariable(name = "id") int id) {
        contractService.deleteContract(id);
        return "redirect:/contracts";
    }

    @RequestMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Contract contract = contractService.get(id);
            model.addAttribute("contract", contract);
            List<ContractDto> contractVehicle = contractService.getContractVehicleJoin();
            model.addAttribute("vehcontracts", contractVehicle);
            List<ContractDto> contractCustomer = contractService.getContractCustomerJoin();
            model.addAttribute("cuscontracts", contractCustomer);
            return "updateContract";
        } catch (ContractNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "The contract has been saved successfully.");
            return "redirect:/contracts";
        }
    }
}
