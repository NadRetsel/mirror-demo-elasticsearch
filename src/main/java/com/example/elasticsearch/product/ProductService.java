package com.example.elasticsearch.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.InvalidModuleDescriptorException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Iterable<Product> getAll()
    {
        return this.productRepository.findAll();
    }

    public Product getById(int id)
    {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("None found with ID"));
    }


    public Product insertProduct(Product product)
    {
        return this.productRepository.save(product);
    }

    
    public Product updateProduct(int id, Product newProduct)
    {
        Product oldProduct = getById(id);
        oldProduct.update(newProduct);
        return oldProduct;
    }


}
