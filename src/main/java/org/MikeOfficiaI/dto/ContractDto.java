package org.MikeOfficiaI.dto;

public class ContractDto {

    private Long id;
    private Long contractNumber;
    private Integer monthlyRate;
    private String brand;
    private String model;
    private String vin;
    private Integer year;
    private Integer price;
    private String firstName;
    private String lastName;

    public ContractDto() {

    }

    public ContractDto(Long contractNumber, Integer monthlyRate, String brand, String model, String vin, Integer year, Integer price) {
        this.contractNumber = contractNumber;
        this.monthlyRate = monthlyRate;
        this.brand = brand;
        this.model = model;
        this.vin = vin;
        this.year = year;
        this.price = price;
    }

    public ContractDto(Long contractNumber, Integer monthlyRate, String firstName, String lastName) {
        this.contractNumber = contractNumber;
        this.monthlyRate = monthlyRate;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
