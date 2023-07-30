package org.MikeOfficiaI.service;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
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

    public List<ContractDto> getContractVehicleJoin() {
        List<ContractDto> list = contractRepository.getContractVehicleJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<ContractDto> getContractCustomerJoin() {
        List<ContractDto> list = contractRepository.getContractCustomerJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }
}
