package com.br.rocha.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.rocha.entities.Product;
import com.br.rocha.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product productDetails) {
		Product product = productService.getProductById(id);
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		final Product updatedProduct = productService.saveProduct(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable String id) {
		productService.deleteProduct(id);
	}
}
