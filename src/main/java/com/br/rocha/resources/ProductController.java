package com.br.rocha.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.rocha.dto.NewProductDTO;
import com.br.rocha.dto.ResponseProductDTO;
import com.br.rocha.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Resource of Products in MongoDB")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	@Operation(summary = "Get all product")
	public ResponseEntity<List<ResponseProductDTO>> getAllProducts() {
		return ResponseEntity.ok().body(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get product of id")
	public ResponseEntity<ResponseProductDTO> getProductById(@PathVariable String id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@PostMapping
	@Operation(summary = "Post new product")
	public ResponseEntity<Void> createProduct(@Valid @RequestBody NewProductDTO product) {
		ResponseProductDTO dto = productService.saveProduct(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	@Operation(summary = "Uptdate product")
	public ResponseEntity<Void> updateProduct(@Valid @RequestBody NewProductDTO objDTO, @PathVariable String id)
			throws Exception {
		productService.updateProduct(objDTO, id);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete product")
	public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
