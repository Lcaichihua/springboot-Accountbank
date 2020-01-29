package com.cavetech.springboot.Accountbank.app.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "accountbank")
public  @Data class AccountBank {
	
@Id
private String id;
private String numcount = "458123"+String.valueOf(Math.floor(Math.random()*99999999+1));
//private String numcount = "123456789";
private Client client;
private ProductBank product ;
private double balance;
private boolean state;

public AccountBank(Client client, ProductBank product, double balance, boolean state) {
	super();
	this.client = client;
	this.product = product;
	this.balance = balance;
	this.state = state;
}



}
