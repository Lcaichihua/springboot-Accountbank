package com.cavetech.springboot.Accountbank.app.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	

	private String action;
	
	@NotEmpty
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date DateIns;
	
	@NotNull
	private double amount;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountOrig() {
		return accountOrig;
	}

	public void setAccountOrig(String accountOrig) {
		this.accountOrig = accountOrig;
	}

	public String getAccountDest() {
		return accountDest;
	}

	public void setAccountDest(String accountDest) {
		this.accountDest = accountDest;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getDateIns() {
		return DateIns;
	}

	public void setDateIns(Date dateIns) {
		DateIns = dateIns;
	}

	public Transactions(
			@NotEmpty(message = "El numero de cuenta origen no puede ser nulo o estar en blanco") String accountOrig,
			@NotEmpty(message = "El numero de cuenta Destino no puede ser nulo o estar en blanco") String accountDest,
			String action, @NotEmpty Date dateIns, @NotNull double amount) {
		super();
		this.accountOrig = accountOrig;
		this.accountDest = accountDest;
		this.action = action;
		DateIns = dateIns;
		this.amount = amount;
	}
	
	
	
	
}
