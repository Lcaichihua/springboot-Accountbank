package com.cavetech.springboot.Accountbank.app.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.cavetech.springboot.Accountbank.app.domain.ActionAccount;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {
	
	
	@NotEmpty(message = "El numero de cuenta origen no puede ser nulo o estar en blanco")
	private String accountOrig;
	
	private String accountDest;

	private String cci;

	private ActionAccount action;
	
	@NotNull
	private double amount;
	
	
}
