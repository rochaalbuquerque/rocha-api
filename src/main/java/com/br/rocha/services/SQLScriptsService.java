package com.br.rocha.services;

import java.util.List;

import com.br.rocha.dto.NewSQLScriptDTO;
import com.br.rocha.dto.ResponseSQLScriptDTO;
import com.br.rocha.entities.SQLScripts;

import jakarta.validation.Valid;

public interface SQLScriptsService {

	SQLScripts validationAndInsert(@Valid NewSQLScriptDTO newQuery) throws Exception;

	List<ResponseSQLScriptDTO> findAll();

	SQLScripts update(@Valid SQLScripts obj);

}
