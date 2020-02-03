package com.cavetech.springboot.Accountbank.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cavetech.springboot.Accountbank.app.domain.Transactions;
import com.cavetech.springboot.Accountbank.app.dto.OperationDto;
import com.cavetech.springboot.Accountbank.app.service.OperationService;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	OperationService operation ;
	
	@PostMapping(value = "/deposite")
	public Mono<Transactions> deposite(@RequestBody @Valid OperationDto dto){
		
		return operation.deposit(dto);
	}
	
	@PostMapping(value = "/retirement")
	public Mono<Transactions> retirement(@RequestBody @Valid OperationDto dto){
		
		return operation.retirement(dto);
	}

}
