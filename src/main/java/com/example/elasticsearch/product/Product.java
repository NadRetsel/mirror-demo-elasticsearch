package com.example.elasticsearch.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;
    private String name;
    private String desription;
    private int quantity;
    private double price;


    public void update(Product product)
    {
        this.name = product.getName();
        this.desription = product.getDesription();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
    }

}
