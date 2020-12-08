package com.atom.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atom.crud.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
