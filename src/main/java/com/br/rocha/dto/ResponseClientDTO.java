package com.br.rocha.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseClientDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String fistName;
	private String lastName;

}
