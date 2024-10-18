package com.br.rocha.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseProductDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String price;

}
