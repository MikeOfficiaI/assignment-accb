package org.MikeOfficiaI.repository;

import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("SELECT new org.MikeOfficiaI.dto.ContractDto(c.contractNumber, c.monthlyRate, v)"
            + "FROM Contract c RIGHT JOIN c.vehicle v")
    List<ContractDto> getContractVehicleJoin();

    @Query("SELECT new org.MikeOfficiaI.dto.ContractDto(c.contractNumber, c.monthlyRate, e)"
            + "FROM Contract c RIGHT JOIN c.customer e")
    List<ContractDto> getContractCustomerJoin();

}
