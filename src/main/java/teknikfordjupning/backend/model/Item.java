package teknikfordjupning.backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Item implements Serializable {
     public Item() {}


    public Item(Long id, String brand, String type, String name, String itemCode) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.name = name;
        this.itemCode = itemCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable =false)
    private Long id;
    private String brand;
    private String type;
    private String name;
    private String itemCode;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", itemCode='" + itemCode + '\'' +
                '}';
    }

    public String getItemCode() {             
         return itemCode;
     }

     public void setItemCode(String itemCode) {
         this.itemCode = itemCode;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
