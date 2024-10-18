package com.br.rocha.services;

import java.util.List;

import com.br.rocha.dto.NewProductDTO;
import com.br.rocha.dto.ResponseProductDTO;

public interface ProductService {

	List<ResponseProductDTO> getAllProducts();

	ResponseProductDTO getProductById(String id);

	ResponseProductDTO saveProduct(NewProductDTO product);

	void deleteProduct(String id);

	ResponseProductDTO updateProduct(NewProductDTO objDTO, String id) throws Exception;

}
