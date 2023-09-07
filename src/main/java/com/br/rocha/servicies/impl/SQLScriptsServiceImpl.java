package com.br.rocha.servicies.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.rocha.dto.NewSQLScriptDTO;
import com.br.rocha.dto.ResponseSQLScriptDTO;
import com.br.rocha.entities.SQLScripts;
import com.br.rocha.repositories.SQLScriptsRepository;
import com.br.rocha.services.SQLScriptsService;

import jakarta.validation.Valid;

@Service
public class SQLScriptsServiceImpl implements SQLScriptsService {

	@Autowired
	private SQLScriptsRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SQLScripts validationAndInsert(@Valid NewSQLScriptDTO newQueryDto) throws Exception {

		SQLScripts newQuery = modelMapper.map(newQueryDto, SQLScripts.class);
		SQLScripts obj = findByName(newQueryDto.getName());

		if (obj == null) {
			newQuery.setId(null);
			newQuery.setDtCreation(currenteDateTime());
			return repository.save(newQuery);

		} else {
			throw new Exception("Nome já cadastrado");
		}

	}

	@Override
	public List<ResponseSQLScriptDTO> findAll() {

		List<SQLScripts> listSQLScript = concatenatedSqlQueryAndSqlConditions();
		return convetListOfEntityToDTO(listSQLScript);
	}

	public SQLScripts update(@Valid SQLScripts updatedObject) {
		SQLScripts obj = repository.getReferenceById(updatedObject.getId());
		updatedQuery(updatedObject, obj);
		return repository.save(updatedObject);
	}

	// GLOBAL
	public SQLScripts findByName(String name) throws Exception {
		return repository.findScriptByName(name);

	}

	private LocalDateTime currenteDateTime() {
		return LocalDateTime.now();
	}

	private List<SQLScripts> concatenatedSqlQueryAndSqlConditions() {
		List<SQLScripts> listSQLScript = repository.findAll();
		List<SQLScripts> listSQLScriptConcatenated = new ArrayList<>();

		for (SQLScripts sqlConcatenated : listSQLScript) {

			sqlConcatenated.setSqlQuery(sqlConcatenated.getSqlQuery()
					+ sqlConcatenated.getSqlConditions().toString().replaceAll("\\[", " ").replaceAll("\\]", " "));
			listSQLScriptConcatenated.add(sqlConcatenated);
		}
		return listSQLScript;
	}

	private List<ResponseSQLScriptDTO> convetListOfEntityToDTO(List<SQLScripts> listSQLScript) {

		return modelMapper.map(listSQLScript, new TypeToken<List<ResponseSQLScriptDTO>>() {
		}.getType());

	}

	private void updatedQuery(@Valid SQLScripts updatedObject, SQLScripts obj) {

		updatedObject.setId(obj.getId());
		updatedObject.setDtCreation(currenteDateTime());

	}

}
