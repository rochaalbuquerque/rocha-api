package com.br.rocha.servicies.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.rocha.dto.NewCommandCategoriesDTO;
import com.br.rocha.dto.NewCommandDTO;
import com.br.rocha.dto.NewCommandToolsDTO;
import com.br.rocha.dto.ResponseCommandCategoriesDTO;
import com.br.rocha.dto.ResponseCommandDTO;
import com.br.rocha.dto.ResponseCommandToolsDTO;
import com.br.rocha.entities.Command;
import com.br.rocha.entities.CommandCategories;
import com.br.rocha.entities.CommandTools;
import com.br.rocha.repositories.CommandCategoryRepository;
import com.br.rocha.repositories.CommandRepository;
import com.br.rocha.repositories.CommandToolsRepository;
import com.br.rocha.services.CommandService;

@Service
public class CommandServiceImpl implements CommandService {

	@Autowired
	private CommandCategoryRepository commandCategoriesRepository;

	@Autowired
	private CommandToolsRepository commandToolsRepository;

	@Autowired
	private CommandRepository commandRepository;

	@Autowired
	private ModelMapper modelMapper;

	// CATEGORY
	@Override
	public List<ResponseCommandCategoriesDTO> findAllCategory() {
		return commandCategoriesRepository.findAll().stream().map(this::converommandCategoriestEntityToDTO)
				.collect(Collectors.toList());
	}

	public ResponseCommandCategoriesDTO saveCategory(NewCommandCategoriesDTO categoryDTO) {
		return converommandCategoriestEntityToDTO(
				commandCategoriesRepository.save(convertCategoriesDTOToEntity(categoryDTO)));
	}

	// TOOLS
	@Override
	public List<ResponseCommandToolsDTO> findAllTools() {
		return commandToolsRepository.findAll().stream().map(this::converommandToolstEntityToDTO)
				.collect(Collectors.toList());
	}

	public ResponseCommandToolsDTO saveTools(NewCommandToolsDTO tooDTO) {

		CommandTools tools = convertToolsDTOToEntity(tooDTO);
		if (tooDTO.getCategory() != null) {
			CommandCategories category = new CommandCategories();
			category.setId(tooDTO.getCategory());
			tools.setCategory(category);
		}

		return converommandToolstEntityToDTO(commandToolsRepository.save(tools));
	}

	// COMMAND
	@Override
	public List<ResponseCommandDTO> findAllCommand() {
		return commandRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public ResponseCommandDTO saveCommand(NewCommandDTO commandDTO) {

		Command command = convertDTOToEntity(commandDTO);
		if (commandDTO.getToolId() != null) {
			CommandTools tools = new CommandTools();
			tools.setId(commandDTO.getToolId());
			command.setTools(tools);
		}

		return convertEntityToDTO(commandRepository.save(command));
	}

	// METODOS/FUNÇÕES
	private ResponseCommandDTO convertEntityToDTO(Command obj) {
		return modelMapper.map(obj, new TypeToken<ResponseCommandDTO>() {
		}.getType());
	}

	private Command convertDTOToEntity(NewCommandDTO objDTO) {
		return modelMapper.map(objDTO, Command.class);
	}

	// Categories
	private ResponseCommandCategoriesDTO converommandCategoriestEntityToDTO(CommandCategories obj) {
		return modelMapper.map(obj, new TypeToken<ResponseCommandCategoriesDTO>() {
		}.getType());
	}

	private CommandCategories convertCategoriesDTOToEntity(NewCommandCategoriesDTO objDTO) {
		return modelMapper.map(objDTO, CommandCategories.class);
	}

	// Tools
	private ResponseCommandToolsDTO converommandToolstEntityToDTO(CommandTools obj) {
		return modelMapper.map(obj, new TypeToken<ResponseCommandToolsDTO>() {
		}.getType());
	}

	private CommandTools convertToolsDTOToEntity(NewCommandToolsDTO objDTO) {
		return modelMapper.map(objDTO, CommandTools.class);
	}

}
