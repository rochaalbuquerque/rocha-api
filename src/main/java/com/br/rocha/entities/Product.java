package com.br.rocha.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "products")
@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	private double price;
}
