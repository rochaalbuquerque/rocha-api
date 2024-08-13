package com.br.rocha.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class NewClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private String firstName;
	private String lastName;
	private String email;
	private String cpfOuCnpj;
	
}
