package org.MikeOfficiaI.service;

import org.MikeOfficiaI.model.Contract;
import org.MikeOfficiaI.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> listAll(){
        return contractRepository.findAll();
    }

    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }
}
