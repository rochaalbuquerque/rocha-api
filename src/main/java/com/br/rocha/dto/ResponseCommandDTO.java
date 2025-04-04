package com.br.rocha.dto;

import java.io.Serializable;

import com.br.rocha.enu.SystemType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseCommandDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String command;
	private String description;
	private SystemType system;
	private ResponseCommandToolsDTO tools;

}
