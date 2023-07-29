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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "fk_customer_id")
    private Customer customer;

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

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", contractNumber=" + contractNumber +
                ", monthlyRate=" + monthlyRate +
                ", vehicle=" + vehicle +
                ", customer=" + customer +
                '}';
    }
}
