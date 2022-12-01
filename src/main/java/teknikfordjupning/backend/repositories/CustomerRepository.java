package teknikfordjupning.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teknikfordjupning.backend.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    void deleteCustomerById(Long id);

   Optional <Customer> findCustomerById(Long id);
}
