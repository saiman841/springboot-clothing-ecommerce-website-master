package com.myproject.apparelshop.repository_dao;

import com.myproject.apparelshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
