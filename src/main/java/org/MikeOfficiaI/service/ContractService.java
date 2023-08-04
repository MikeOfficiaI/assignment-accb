package org.MikeOfficiaI.service;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.exception.ContractNotFoundException;
import org.MikeOfficiaI.repository.ContractRepository;
import org.MikeOfficiaI.repository.CustomerRepository;
import org.MikeOfficiaI.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

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
        return list;
    }

    public List<ContractDto> getContractCustomerJoin() {
        List<ContractDto> list = contractRepository.getContractCustomerJoin();
        return list;
    }

    public void deleteContract(long id) {
        contractRepository.deleteById(id);
    }

    public Contract get(long id) throws ContractNotFoundException{
        Optional<Contract> contract = contractRepository.findById(id);
        if (contract.isPresent()) {
            return contract.get();
        }
        throw new ContractNotFoundException("Could not find contracts with ID " + id);
    }
}
