package com.br.rocha.services;

import java.util.List;

import com.br.rocha.dto.NewCommandCategoriesDTO;
import com.br.rocha.dto.NewCommandDTO;
import com.br.rocha.dto.NewCommandToolsDTO;
import com.br.rocha.dto.ResponseCommandCategoriesDTO;
import com.br.rocha.dto.ResponseCommandDTO;
import com.br.rocha.dto.ResponseCommandToolsDTO;

public interface CommandService {

	// CATEGORY
	List<ResponseCommandCategoriesDTO> findAllCategory();

	ResponseCommandCategoriesDTO saveCategory(NewCommandCategoriesDTO categoryDTO);

	// TOOLS
	List<ResponseCommandToolsDTO> findAllTools();

	ResponseCommandToolsDTO saveTools(NewCommandToolsDTO tooDTO);

	// COMMAND
	List<ResponseCommandDTO> findAllCommand();

	ResponseCommandDTO saveCommand(NewCommandDTO commandDTO);

}
