package com.br.rocha.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.rocha.dto.NewCommandCategoriesDTO;
import com.br.rocha.dto.NewCommandDTO;
import com.br.rocha.dto.NewCommandToolsDTO;
import com.br.rocha.dto.ResponseCommandCategoriesDTO;
import com.br.rocha.dto.ResponseCommandDTO;
import com.br.rocha.dto.ResponseCommandToolsDTO;
import com.br.rocha.services.CommandService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("v1/api/Commands")
@Tag(name = "Command", description = "Resource of Command in MYSQL")
public class CommandResource {

	@Autowired
	private CommandService commandService;

	// CATEGORY
	@GetMapping("/category")
	public List<ResponseCommandCategoriesDTO> getAllCategories() {
		return commandService.findAllCategory();
	}

	@PostMapping("/category")
	public ResponseEntity<ResponseCommandCategoriesDTO> createCategory(@RequestBody NewCommandCategoriesDTO categoryDTO) {
		ResponseCommandCategoriesDTO savedCategory = commandService.saveCategory(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
	}

	// TOOLS
	@GetMapping("/tools")
	public List<ResponseCommandToolsDTO> getAllTools() {
		return commandService.findAllTools();
	}

	@PostMapping("/tools")
	public ResponseEntity<ResponseCommandToolsDTO> createTool(@RequestBody NewCommandToolsDTO tooDTO) {
		ResponseCommandToolsDTO savedTool = commandService.saveTools(tooDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTool);
	}

	// COMMAND
	@GetMapping("/command")
	public List<ResponseCommandDTO> getAllCommands() {
		return commandService.findAllCommand();
	}

	@PostMapping("/command")
	public ResponseEntity<ResponseCommandDTO> createCommand(@RequestBody NewCommandDTO commandDTO) {
		ResponseCommandDTO savedCommand = commandService.saveCommand(commandDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCommand);
	}

}
