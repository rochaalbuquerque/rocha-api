package com.br.rocha.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseSQLScriptDTO implements Serializable {

	private String name;
	private String descrition;
	private String sqlQuery;
	private static final long serialVersionUID = 1L;

}
