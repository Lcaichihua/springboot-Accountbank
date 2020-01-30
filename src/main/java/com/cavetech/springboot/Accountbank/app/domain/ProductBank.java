package com.cavetech.springboot.Accountbank.app.domain;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public  @Data  class ProductBank {
	
	private String id;
	private String description;
	private TypeProductBank typeProductBank;
	private Integer codigo;
	public ProductBank(String description, TypeProductBank typeProductBank, Integer codigo) {
		super();
		this.description = description;
		this.typeProductBank = typeProductBank;
		this.codigo = codigo;
	}
	
	
	
	
}
