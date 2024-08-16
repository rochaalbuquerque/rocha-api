package com.br.rocha.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.rocha.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
