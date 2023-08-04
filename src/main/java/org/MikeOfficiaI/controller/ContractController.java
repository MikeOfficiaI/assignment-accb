package org.MikeOfficiaI.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.exception.ContractNotFoundException;
import org.MikeOfficiaI.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@Api(description = "Controller for the contract entity")
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    @ApiOperation("Get list of all contracts and viewing the main page")
    public String index(Model model) {
        List<Contract> contractList = contractService.listAll();
        model.addAttribute("contracts", contractList);
        return "contracts";
    }

    @GetMapping("/contract/add")
    @ApiOperation("Get models of all available cars, all customers on the creating contract page")
    public String postContract(Model model) {
        List<Contract> contractList = contractService.listAll();
        model.addAttribute("contracts", contractList);
        List<ContractDto> contractVehicle = contractService.getContractVehicleJoin();
        List<ContractDto> freeVehicle = new ArrayList<>();
        for (ContractDto pos : contractVehicle) {
            if (pos.getVehicle().getContract() == null) {
                freeVehicle.add(pos);
            }
        }
        model.addAttribute("vehcontracts", freeVehicle);
        List<ContractDto> contractCustomer = contractService.getContractCustomerJoin();
        model.addAttribute("cuscontracts", contractCustomer);
        return "newContract";
    }

    @PostMapping("/contract/save")
    @ApiOperation("Saving new contract")
    public String saveContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        contractService.saveContract(contract);
        redirectAttributes.addFlashAttribute("message", "The contract has been created successfully.");
        return "redirect:/contracts";
    }

    @RequestMapping("/delete/{id}")
    @ApiOperation("Delete a specific contract")
    public String deleteContract(@PathVariable(name = "id") int id) {
        contractService.deleteContract(id);
        return "redirect:/contracts";
    }

    @RequestMapping("/update/{id}")
    @ApiOperation("Update specific contract")
    public String showUpdateForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Contract contract = contractService.get(id);
            System.out.println("VEHICLE: " + contract.getVehicle().getBrand());
            model.addAttribute("contract", contract);
            List<ContractDto> contractVehicle = contractService.getContractVehicleJoin();
            List<ContractDto> freeVehicle = new ArrayList<>();
            ContractDto carInUsingContract = new ContractDto();
            carInUsingContract.setVehicle(contract.getVehicle());
            freeVehicle.add(carInUsingContract);
            for (ContractDto pos : contractVehicle) {
                if (pos.getVehicle().getContract() == null) {
                    freeVehicle.add(pos);
                }
            }
            model.addAttribute("vehcontracts", freeVehicle);
            List<ContractDto> contractCustomer = contractService.getContractCustomerJoin();
            model.addAttribute("cuscontracts", contractCustomer);
            return "updateContract";
        } catch (ContractNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "The contract has been saved successfully.");
            return "redirect:/contracts";
        }
    }
}
