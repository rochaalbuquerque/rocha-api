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

import com.br.rocha.dto.NewClientDTO;
import com.br.rocha.dto.ResponseClientDTO;
import com.br.rocha.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/clients")
@Tag(name = "Clients", description = "Resource of Clients in MYSQL")
public class ClientResource {

	@Autowired
	private ClientService service;

	@GetMapping()
	@Operation(summary = "Get all client")
	public ResponseEntity<List<ResponseClientDTO>> getAllClient() throws Exception {
		List<ResponseClientDTO> listAllclientDTO = service.findAllClient();
		return ResponseEntity.ok().body(listAllclientDTO);

	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Get client of id")
	public ResponseEntity<ResponseClientDTO> getClientId(@PathVariable Integer id) throws Exception {
		ResponseClientDTO clientDTO = service.findClientId(id);
		return ResponseEntity.ok().body(clientDTO);
	}

	@PostMapping
	@Operation(summary = "Post new client")
	public ResponseEntity<Void> newClient(@Valid @RequestBody NewClientDTO client) {
		ResponseClientDTO dto = service.createNewClient(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Uptdate client")
	public ResponseEntity<Void> updateClient(@Valid @RequestBody NewClientDTO objDTO, @PathVariable Integer id)
			throws Exception {
		service.updateClient(objDTO, id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete client")
	public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
		service.deleteClient(id);
		return ResponseEntity.noContent().build();

	}

}
