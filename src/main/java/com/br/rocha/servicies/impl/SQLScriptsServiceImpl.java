package com.br.rocha.servicies.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.rocha.entities.SQLScripts;
import com.br.rocha.repositories.SQLScriptsRepository;
import com.br.rocha.services.SQLScriptsService;

import jakarta.validation.Valid;

@Service
public class SQLScriptsServiceImpl implements SQLScriptsService {

	@Autowired
	private SQLScriptsRepository repository;

	@Override
	public SQLScripts validationAndInsert(@Valid SQLScripts newQuery) {

		LocalDateTime dateCreation = LocalDateTime.now();

		newQuery.setId(null);
		newQuery.setDtCreation(dateCreation);
		findByName(newQuery.getName());

		return repository.save(newQuery);
	}

	public SQLScripts findByName(String name) {
		return repository.findByName(name);

	}

	@Override
	public List<SQLScripts> findAll() {
		return repository.findAll();
	}

	public SQLScripts updateAndExecult(@Valid SQLScripts updatedObject) {
		SQLScripts obj = repository.getReferenceById(updatedObject.getId());
		updatedQuery(updatedObject, obj);

		String queryExecut = queryGenerate(updatedObject);
		System.out.println("Sql: " + queryExecut);

		return repository.save(updatedObject);
	}

	private String queryGenerate(@Valid SQLScripts updatedObject) {

		return (updatedObject.getSqlQuery()) + (updatedObject.getSqlConditions().toString().replace("[", " ").replace("]"," "));
	}

	private void updatedQuery(@Valid SQLScripts updatedObject, SQLScripts obj) {

		updatedObject.setId(obj.getId());
		updatedObject.setDtCreation(currenteDateTime());

	}

	private LocalDateTime currenteDateTime() {
		return LocalDateTime.now();
	}

}
