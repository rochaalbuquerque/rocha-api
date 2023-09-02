package com.br.rocha.services;

import java.util.List;

import com.br.rocha.entities.SQLScripts;

import jakarta.validation.Valid;

public interface SQLScriptsService {

	SQLScripts validationAndInsert(@Valid SQLScripts newQuery);

	List<SQLScripts> findAll();

	SQLScripts updateAndExecult(@Valid SQLScripts obj);

}
