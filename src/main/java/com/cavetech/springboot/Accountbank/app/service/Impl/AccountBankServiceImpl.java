package com.cavetech.springboot.Accountbank.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cavetech.springboot.Accountbank.app.domain.AccountBank;
import com.cavetech.springboot.Accountbank.app.domain.Client;
import com.cavetech.springboot.Accountbank.app.domain.ProductBank;
import com.cavetech.springboot.Accountbank.app.repository.AccountBankRepository;
import com.cavetech.springboot.Accountbank.app.service.AccountBankService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AccountBankServiceImpl implements AccountBankService{
	
	@Autowired
	AccountBankRepository accbankrep ;
	
	//registro de cuentas bancarias 
	@Override
	public Mono<AccountBank> save(AccountBank accountBank) {
					return WebClient.builder().baseUrl("http://localhost:8083/client/").build().get()
				.uri(accountBank.getClient().getId()).retrieve().bodyToMono(Client.class).log()
				.flatMap(cl -> {
					accountBank.setClient(cl);
					return WebClient.builder().baseUrl("http://localhost:8081/productbank/").build().get()
							.uri(accountBank.getProduct().getId()).retrieve()
							.bodyToMono(ProductBank.class).log();
				})
				
				
				.flatMap(acc -> { 
					accountBank.setProduct(acc);
					System.out.println(accountBank);
					return accbankrep.save(accountBank);
				});
	}

	
	
	
	
	@Override
	public Flux<AccountBank> findAll() {
		return this.accbankrep.findAll();
	}

	@Override
	public Mono<AccountBank> findById(String id) {
		return this.accbankrep.findById(id);
	}

	@Override
	public Mono<Void> deletexId(String id) {
		return this.accbankrep.deleteById(id);
	}

	@Override
	public Mono<Void> delete(AccountBank accountBank) {
		return this.accbankrep.delete(accountBank);
	}

	/*@Override
	public Flux<AccountBank> findxClient(String idClient) {
		return WebClient.builder().baseUrl("http://localhost:8099/micro-clientes/clientes/").build().get()
				.uri(idClient).retrieve().bodyToMono(Client.class).log().flatMapMany(cli -> {
					return accbankrep.findxClient(cli);
				}); 
		return null;
	}*/

}
