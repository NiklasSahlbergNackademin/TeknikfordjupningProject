package teknikfordjupning.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teknikfordjupning.backend.model.Customer;
import teknikfordjupning.backend.model.Item;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    void deleteCustomerById(Long id);

    Optional<Item> findItemById(Long id);
}
