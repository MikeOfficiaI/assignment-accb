package org.MikeOfficiaI.service;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public void deleteContract(long id) {
        contractRepository.deleteById(id);
    }

    public Contract get(long id) {
        return contractRepository.findById(id).get();
    }

    public Contract updateContract(long id, ContractDto contractDto) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leasing contract not found with id " + id));

        contract.setContractNumber(contractDto.getContractNumber());
        contract.setMonthlyRate(contractDto.getMonthlyRate());
        contract.setCustomer(contractDto.getCustomer());
        contract.setVehicle(contractDto.getVehicle());

        contract = contractRepository.save(contract);
        return contract;
    }
}
