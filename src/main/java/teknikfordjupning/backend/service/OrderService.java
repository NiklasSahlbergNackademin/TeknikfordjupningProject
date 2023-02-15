package teknikfordjupning.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teknikfordjupning.backend.model.Item;
import teknikfordjupning.backend.model.Order;
import teknikfordjupning.backend.repositories.ItemRepository;
import teknikfordjupning.backend.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }


    public Optional<Order> findOrderById(Integer id) {
        return orderRepository.findById(id);
    }
}