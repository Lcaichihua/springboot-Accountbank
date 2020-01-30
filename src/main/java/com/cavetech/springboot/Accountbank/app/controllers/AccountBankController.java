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
	
	@PostMapping
	public Mono<AccountBank> saveAccountBank(@RequestBody @Valid AccountBank accountBank) {
		return AccountBankServ.save(accountBank);
	}
	
	@GetMapping("/{idproduct}")
	public Mono<AccountBank> findbyId(@PathVariable String idproduct) {
		return AccountBankServ.findById(idproduct);
	}
	
	@GetMapping("/list")
	public Flux<AccountBank> ListCountBank() {
		return AccountBankServ.findAll();
	}
	
	
	
	
}
