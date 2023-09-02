package com.br.rocha.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.rocha.entities.SQLScripts;
import com.br.rocha.services.SQLScriptsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/SQLScripts")
@Tag(name = "Scripts Resource", description = "Recurso de scripts SQL")
public class SQLScriptsResource {

	@Autowired
	private SQLScriptsService service;

	@PostMapping
	@Operation(summary = "cadastrar script")
	public ResponseEntity<Void> newQuery(@Valid @RequestBody SQLScripts newQuery) {

		SQLScripts obj = service.validationAndInsert(newQuery);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	@Operation(summary = "Listar todos os scripts")
	public ResponseEntity<List<SQLScripts>> allQueryies() {
		List<SQLScripts> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Editar script por id")
	public ResponseEntity<?> updateAndUpdate(@Valid @RequestBody SQLScripts obj, @PathVariable  Long id) {

		obj.setId(id);
		@SuppressWarnings("unused")
		SQLScripts queryResponse = service.updateAndExecult(obj);
		return ResponseEntity.noContent().build();
	}
}
