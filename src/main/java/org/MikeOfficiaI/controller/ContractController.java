package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.service.ContractService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContractController {

    private ContractService contractService;

    @Autowired
    private ModelMapper modelMapper;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Contract> contractList = contractService.listAll();
        model.addAttribute("contracts", contractList);
        return "index";
    }

    @GetMapping("/addContract")
    public String postContract(Model model) {
        List<Contract> contractList = contractService.listAll();
        model.addAttribute("contracts", contractList);
        List<ContractDto> contractVehicle = contractService.getContractVehicleJoin();
        model.addAttribute("vehcontracts", contractVehicle);
        List<ContractDto> contractCustomer = contractService.getContractCustomerJoin();
        model.addAttribute("cuscontracts", contractCustomer);
        return "newContract";
    }

    @RequestMapping(value = "/saveContract", method = RequestMethod.POST)
    public String saveContract(@ModelAttribute("vehcontracts") ContractDto contractDto) {
        Contract contract = modelMapper.map(contractDto, Contract.class);
        contractService.saveContract(contract);
        return "newContract";
    }
}
