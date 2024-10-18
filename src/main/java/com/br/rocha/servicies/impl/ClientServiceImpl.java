package com.br.rocha.servicies.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

	@Override
	public List<ResponseClientDTO> findAllClient() throws Exception {
		return repository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	@Cacheable(value = "clienteId", key = "#id")
	public ResponseClientDTO findClientId(Integer id) throws Exception {
		return convertEntityToDTO(repository.findById(id).orElse(null));
	}

	@CacheEvict(value = "clienteId", allEntries = true)
	public ResponseClientDTO createNewClient(NewClientDTO newclient) {
		return convertEntityToDTO(repository.save(modelMapper.map(newclient, Client.class)));
	}

	@CacheEvict(value = "clienteId", allEntries = true)
	public ResponseClientDTO updateClient(NewClientDTO objDTO, Integer id) throws Exception {

		Client existingClient = repository.findById(id).orElseThrow(() -> new Exception("Client not found"));

		Client updatedClient = convertDTOToEntity(objDTO);
		updatedClient.setId(existingClient.getId());
		return convertEntityToDTO(repository.save(updatedClient));
	}

	@CacheEvict(value = "clienteId", allEntries = true)
	public void deleteClient(Integer id) {
		repository.deleteById(id);

	}

	// METODOS/FUNÇÕES
	private ResponseClientDTO convertEntityToDTO(Client obj) {
		return modelMapper.map(obj, new TypeToken<ResponseClientDTO>() {
		}.getType());
	}

	private Client convertDTOToEntity(NewClientDTO objDTO) {
		return modelMapper.map(objDTO, Client.class);
	}

}
