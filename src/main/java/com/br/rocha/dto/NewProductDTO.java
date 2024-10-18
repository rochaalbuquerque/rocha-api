package com.br.rocha.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class NewProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private String name;
	private String price;	
}
