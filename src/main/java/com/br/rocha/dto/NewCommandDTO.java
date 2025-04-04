package com.br.rocha.dto;

import java.io.Serializable;

import com.br.rocha.enu.SystemType;

import lombok.Data;

@Data
public class NewCommandDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String command;
    private String description;
    private SystemType system;
    private Long toolId;

}
