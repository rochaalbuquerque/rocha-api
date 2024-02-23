package com.br.rocha.servicies.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.rocha.dto.NewClientDTO;
import com.br.rocha.dto.ResponseClientDTO;
import com.br.rocha.entities.Client;
import com.br.rocha.repositories.ClientRepository;
import com.br.rocha.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ResponseClientDTO findClientId(Integer id) throws Exception {
		Client obj = findById(id);
		return convertEntityToDTO(obj);
	}

	public ResponseClientDTO createNewClient(NewClientDTO client) {

		Client obj = modelMapper.map(client, Client.class);
		return convertEntityToDTO(repository.save(obj));
	}

	public ResponseClientDTO updateClient(NewClientDTO objDTO, Integer id) throws Exception {

		Client obj = findById(id);
		
		Client objUpdated = convertDTOToEntity(objDTO);		
		objUpdated.setId(id);
		repository.save(objUpdated);
		return convertEntityToDTO(objUpdated);		 
	}

	public void deleteClient(Integer id) {
		repository.deleteById(id);

	}

	// METODOS/FUNÇÕES
	private Client findById(Integer id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception(" Client of ID " + id + " Not Found "));
	}

	private ResponseClientDTO convertEntityToDTO(Client obj) {
		return modelMapper.map(obj, new TypeToken<ResponseClientDTO>() {
		}.getType());
	}

	private Client convertDTOToEntity(NewClientDTO objDTO) {
		return modelMapper.map(objDTO, Client.class);
	}
}
