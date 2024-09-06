package com.galagandevelopment.HGSite.repositories;

import com.galagandevelopment.HGSite.models.Product;
import com.galagandevelopment.HGSite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName(String title);
    List<Product> findAllByPriceBetween(int min, int max);
}
