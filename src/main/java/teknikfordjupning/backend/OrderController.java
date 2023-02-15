package teknikfordjupning.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teknikfordjupning.backend.exceptions.ItemNotFoundException;
import teknikfordjupning.backend.model.Item;
import teknikfordjupning.backend.model.Order;
import teknikfordjupning.backend.service.ItemService;
import teknikfordjupning.backend.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    private ItemService itemService;

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {


        return orderService.saveOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> findOrderById(@PathVariable Integer id) {
        return orderService.findOrderById(id);
    }


}