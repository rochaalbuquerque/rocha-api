package com.br.rocha.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseCommandCategoriesDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;

}
