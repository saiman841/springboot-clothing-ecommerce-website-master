package com.myproject.apparelshop.service;

import com.myproject.apparelshop.model.Product;
import com.myproject.apparelshop.repository_dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
