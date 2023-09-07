package com.br.rocha.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class NewSQLScriptDTO implements Serializable {

	private String name;
	private String descrition;
	private String sqlQuery;
	private List<String> sqlConditions = new ArrayList<>(); 
	private static final long serialVersionUID = 1L;

}
