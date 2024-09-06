package com.galagandevelopment.HGSite.services;

import com.galagandevelopment.HGSite.models.Product;
import com.galagandevelopment.HGSite.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
