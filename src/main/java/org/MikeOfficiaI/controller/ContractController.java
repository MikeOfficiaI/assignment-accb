package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Contract;
import org.MikeOfficiaI.model.Customer;
import org.MikeOfficiaI.model.Vehicle;
import org.MikeOfficiaI.service.ContractService;
import org.MikeOfficiaI.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/addContract")
    public String postContract(Model model) {
        List<Contract> customerList = contractService.listAll();
        model.addAttribute("contracts", customerList);
        Contract contract = new Contract();
        return "newContract";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("contract") Contract contract) {
        contractService.saveContract(contract);
        return "redirect:/";
    }
}
