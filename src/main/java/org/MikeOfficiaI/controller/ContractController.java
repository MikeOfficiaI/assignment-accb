package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Contract;
import org.MikeOfficiaI.model.Customer;
import org.MikeOfficiaI.service.ContractService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Contract> liststudent = contractService.listAll();
        model.addAttribute("listscontract", liststudent);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("student", new Contract());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("contract") Contract contract) {
        contractService.saveContract(contract);
        return "redirect:/";
    }
}
