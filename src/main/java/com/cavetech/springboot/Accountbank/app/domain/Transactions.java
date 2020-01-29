package com.cavetech.springboot.Accountbank.app.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Transactions")
public class Transactions {
	@Id
	private String id;

	@NotEmpty(message = "El numero de cuenta origen no puede ser nulo o estar en blanco")
	private String accountOrig;
	@NotEmpty(message = "El numero de cuenta Destino no puede ser nulo o estar en blanco")
	private String accountDest;

	private String cci;

	private ActionAccount action;
	
	@NotEmpty
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaMovimiento;
	
	@NotNull
	private double amount;
	
	
	
}
