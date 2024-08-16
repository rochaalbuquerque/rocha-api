package com.br.rocha.services;

import java.util.List;

import com.br.rocha.entities.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String id);

	Product saveProduct(Product product);

	void deleteProduct(String id);

}
