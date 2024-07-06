package org.vikram.orders;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Product {
    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Id
    int id;
    String name;
    String description;
    int price;

}
