package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.service.ContractService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/contract/save", method = RequestMethod.POST)
    public String saveContract(@ModelAttribute("contracts") ContractDto contractDto) {
        Contract contract = new Contract();
        contract.setContractNumber(contractDto.getContractNumber());
        contract.setMonthlyRate(contractDto.getMonthlyRate());
        contract.setVehicle(contractDto.getVehicle());
        contract.setCustomer(contractDto.getCustomer());
        contractService.saveContract(contract);
        return "newContract";
    }

    @RequestMapping("/delete/{id}")
    public String deleteContract(@PathVariable(name = "id") int id) {
        contractService.deleteContract(id);
        return "redirect:/contracts";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateContract(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView("newContract");
        Contract contract = contractService.get(id);
        List<ContractDto> contractVehicle = contractService.getContractVehicleJoin();
        mav.addObject("vehcontracts", contractVehicle);
        List<ContractDto> contractCustomer = contractService.getContractCustomerJoin();
        mav.addObject("cuscontracts", contractCustomer);
        mav.addObject("contracts", contract);
        return mav;
    }
}
