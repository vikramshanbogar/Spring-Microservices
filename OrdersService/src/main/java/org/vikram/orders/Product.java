package org.vikram.orders;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product {


    int id;
    String name;
    String description;
    int price;
    int inventory;

}
