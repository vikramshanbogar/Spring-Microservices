package org.vikram.orders;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToMany(fetch=FetchType.EAGER,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    List<Product> products;
    Integer customerId;


    public Orders(List<Product> products, Integer customerId) {
        this.products = products;
        this.customerId = customerId;
    }



}
