package teknikfordjupning.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teknikfordjupning.backend.exceptions.CustomerNotFoundException;
import teknikfordjupning.backend.model.Customer;
import teknikfordjupning.backend.repositories.CustomerRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        customer.setCustomerCode(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(Long id){
       return customerRepository.findCustomerById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + "doesn't exist"));
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteCustomerById(id);
    }
}
