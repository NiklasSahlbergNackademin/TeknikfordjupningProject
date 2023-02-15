package teknikfordjupning.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {



    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "_user_id")
    @JsonBackReference
    private User user;





  /*  @ManyToMany
    @OrderColumn(name = "item_index")
    @JoinTable(
            name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )

   */

    @ManyToMany()
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();
 //   private List<Item> items = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private Double totalAmount;

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }



    public Order(Date orderDate, List<Item> items, User user) {
        this.orderDate = orderDate;
        this.items = items;
        this.user = user;
    }


}