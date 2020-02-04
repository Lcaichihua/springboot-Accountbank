package com.cavetech.springboot.Accountbank.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cavetech.springboot.Accountbank.app.domain.AccountBank;
import com.cavetech.springboot.Accountbank.app.service.AccountBankService;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/accountbank")
public class AccountBankController {

	
	@Autowired
	private AccountBankService AccountBankServ;
	
	/*@GetMapping("/{idCliente}")
	public Flux<AccountBank> FindProducxClient(@PathVariable String idClient) {
		return AccountBankServ.findxClient(idClient);	
	}*/
	
	@ApiOperation(value = "save a accountbank", notes="save object account")
	@PostMapping
	public Mono<AccountBank> saveAccountBank(@RequestBody @Valid AccountBank accountBank) {
		return AccountBankServ.save(accountBank);
	}
	
	
	@ApiOperation(value = "Find a Accountbank", notes="Find a bank by id account")
	@GetMapping("/{idproduct}")
	public Mono<AccountBank> findbyId(@PathVariable String idproduct) {
		return AccountBankServ.findById(idproduct);
	}
	
	
	@ApiOperation(value = "return list all", notes="select all Bank")
	@GetMapping("/list")
	public Flux<AccountBank> ListCountBank() {
		return AccountBankServ.findAll();
	}
	
	
	
	
}
