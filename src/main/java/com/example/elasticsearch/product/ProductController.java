package com.example.elasticsearch.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products")
    public Iterable<Product> getALl()
    {
        return this.productService.getAll();
    }

    @PostMapping("/product")
    public Product insertProduct(@RequestBody Product product)
    {
        return this.productService.insertProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product)
    {
        return this.productService.updateProduct(id, product);
    }
}
