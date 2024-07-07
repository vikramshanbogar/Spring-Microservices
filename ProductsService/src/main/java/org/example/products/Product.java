package org.example.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Accessors(chain = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product {

    @Id
    int id;
    String name;
    String description;
    int price;

}
