package org.MikeOfficiaI.service;

import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.exception.ContractNotFoundException;
import org.MikeOfficiaI.exception.CustomerNotFoundException;
import org.MikeOfficiaI.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer get(long id) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new CustomerNotFoundException("Could not find customer with ID " + id);
    }
}
