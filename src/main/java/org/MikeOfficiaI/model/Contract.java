package org.MikeOfficiaI.model;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "contract_number", nullable = false)
    private Long contractNumber;

    @Column(name = "monthly_rate", nullable = false)
    private int monthlyRate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_info", nullable = false)
    private Customer customerFullName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_info", nullable = false)
    private Vehicle carInfo;

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

    public Customer getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(Customer customerFullName) {
        this.customerFullName = customerFullName;
    }

    public Vehicle getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(Vehicle carInfo) {
        this.carInfo = carInfo;
    }
}
