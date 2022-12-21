package teknikfordjupning.backend.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Entity
public class Item implements Serializable {
     public Item() {}


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Item(Long id, String name, String category, double price, String itemCode, String description, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.itemCode = itemCode;
        this.description = description;
        this.image = image;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable =false)
    private Long id;

    private String name;



    private String category;

    private double price;


    private String itemCode;


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    private String description;
    private String image;


    public String getItemCode() {
         return itemCode;
     }

     public void setItemCode(String itemCode) {
         this.itemCode = itemCode;
     }

    public Long getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String type) {
        this.category = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}
}
