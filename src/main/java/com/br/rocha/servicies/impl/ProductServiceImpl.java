package com.br.rocha.servicies.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.rocha.dto.NewProductDTO;
import com.br.rocha.dto.ResponseProductDTO;
import com.br.rocha.entities.Product;
import com.br.rocha.repositories.ProductRepository;
import com.br.rocha.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ResponseProductDTO> getAllProducts() {
		return repository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public ResponseProductDTO getProductById(String id) {
		return convertEntityToDTO(repository.findById(id).orElse(null));
	}

	public ResponseProductDTO saveProduct(NewProductDTO newproduct) {
		return convertEntityToDTO(repository.save(modelMapper.map(newproduct, Product.class)));
	}

	@Override
	public ResponseProductDTO updateProduct(NewProductDTO objDTO, String id) throws Exception {

		Product existingProduct = repository.findById(id).orElseThrow(() -> new Exception("Product not found"));

		Product updatedClient = convertDTOToEntity(objDTO);
		updatedClient.setId(existingProduct.getId());
		return convertEntityToDTO(repository.save(updatedClient));
	}

	public void deleteProduct(String id) {
		repository.deleteById(id);
	}

	// METODOS/FUNÇÕES
	// METODOS/FUNÇÕES

	private ResponseProductDTO convertEntityToDTO(Product obj) {
		return modelMapper.map(obj, new TypeToken<ResponseProductDTO>() {
		}.getType());
	}

	private Product convertDTOToEntity(NewProductDTO objDTO) {
		return modelMapper.map(objDTO, Product.class);
	}

}
