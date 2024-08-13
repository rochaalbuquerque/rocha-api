package com.br.rocha.servicies.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.br.rocha.services.exceptions.ObjectNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ResponseClientDTO> findAllClient() throws Exception {

		List<Client> listClient = findAll();
		List<ResponseClientDTO> listClintConverted = new ArrayList<>();

		for (Client client : listClient)
			listClintConverted.add(convertEntityToDTO(client));

		return listClintConverted;
	}

	@Cacheable(value = "clienteId", key = "#id")
	public ResponseClientDTO findClientId(Integer id) throws Exception {
		Client obj = findById(id);
		return convertEntityToDTO(obj);
	}

	@CacheEvict(value = "clienteId", allEntries = true)
	public ResponseClientDTO createNewClient(NewClientDTO client) {

		Client obj = modelMapper.map(client, Client.class);
		return convertEntityToDTO(repository.save(obj));
	}

	@CacheEvict(value = "clienteId", allEntries = true)
	public ResponseClientDTO updateClient(NewClientDTO objDTO, Integer id) throws Exception {

		Client objUpdated = convertDTOToEntity(objDTO);
		objUpdated.setId(id);
		repository.save(objUpdated);
		return convertEntityToDTO(objUpdated);
	}

	@CacheEvict(value = "clienteId", allEntries = true)
	public void deleteClient(Integer id) {
		repository.deleteById(id);

	}

	// METODOS/FUNÇÕES
	private List<Client> findAll() {
		return repository.findAll();
	}

	private Client findById(Integer id) throws Exception {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(" Client of ID " + id + " Not Found "));
	}

	private ResponseClientDTO convertEntityToDTO(Client obj) {
		return modelMapper.map(obj, new TypeToken<ResponseClientDTO>() {
		}.getType());
	}

	private Client convertDTOToEntity(NewClientDTO objDTO) {
		return modelMapper.map(objDTO, Client.class);
	}

}
