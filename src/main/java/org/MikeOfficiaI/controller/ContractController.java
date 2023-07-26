package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Contract;
import org.MikeOfficiaI.model.Customer;
import org.MikeOfficiaI.service.ContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    public List<Contract> getContracts() {
        return contractService.getContracts();
    }
}
