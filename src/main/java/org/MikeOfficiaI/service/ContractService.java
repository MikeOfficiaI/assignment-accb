package org.MikeOfficiaI.service;

import org.MikeOfficiaI.model.Contract;
import org.MikeOfficiaI.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getContracts() {
        return contractRepository.findAll();
    }
}
