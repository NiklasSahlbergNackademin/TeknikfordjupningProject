package teknikfordjupning.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teknikfordjupning.backend.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
