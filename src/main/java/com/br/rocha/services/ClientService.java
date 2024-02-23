package com.br.rocha.services;

import com.br.rocha.dto.NewClientDTO;
import com.br.rocha.dto.ResponseClientDTO;

public interface ClientService {

	ResponseClientDTO findClientId(Integer id) throws Exception;

	ResponseClientDTO createNewClient(NewClientDTO client);

	void deleteClient(Integer id);

	ResponseClientDTO updateClient(NewClientDTO objDTO, Integer id) throws Exception;

}
