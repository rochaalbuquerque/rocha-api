package com.br.rocha.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SQLScripts implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String descrition;
	private String sqlQuery;
	private List<String> sqlConditions = new ArrayList<>(); 
	private LocalDateTime dtCreation; 
	private LocalDateTime dtUpdate; 
	private static final long serialVersionUID = 1L;

}
