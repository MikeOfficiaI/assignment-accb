package org.MikeOfficiaI.dto;

import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.entity.Vehicle;

public class ContractDto {

    private Long id;
    private Long contractNumber;
    private Integer monthlyRate;
    private Vehicle vehicle;
    private Customer customer;

    public ContractDto() {

    }

    public ContractDto(Long contractNumber, Integer monthlyRate, Vehicle vehicle) {
        this.contractNumber = contractNumber;
        this.monthlyRate = monthlyRate;
        this.vehicle = vehicle;
    }

    public ContractDto(Long contractNumber, Integer monthlyRate, Customer customer) {
        this.contractNumber = contractNumber;
        this.monthlyRate = monthlyRate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(int monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
