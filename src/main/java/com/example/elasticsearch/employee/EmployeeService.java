package com.example.elasticsearch.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.module.InvalidModuleDescriptorException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;



    public Page<Product> getByName(String nameToFind)
    {
        Page<Product> productByName = this.productRepository.findByName(nameToFind, PageRequest.of(0,10));
    }


    public Product insertProduct(Product product)
    {
        return this.productRepository.save(product);
    }



}
