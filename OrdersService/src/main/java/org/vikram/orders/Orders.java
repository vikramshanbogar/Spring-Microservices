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
    @ElementCollection(fetch = FetchType.EAGER)
    List<Integer> productsId;
    Integer customerId;


    public Orders(List<Integer> productsId, Integer customerId) {
        this.productsId = productsId;
        this.customerId = customerId;
    }



}
