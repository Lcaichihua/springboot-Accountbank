package com.cavetech.springboot.Accountbank.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "actionAccount")
public class ActionAccount {
	
	@Id
	private String id ;
	private Integer codigo;
	private String  description  ;
	public ActionAccount(Integer codigo, String description) {
		super();
		this.codigo = codigo;
		this.description = description;
	}
	
	
}
