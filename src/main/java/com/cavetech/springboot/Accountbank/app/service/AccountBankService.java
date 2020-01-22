package com.cavetech.springboot.Accountbank.app.service;



import com.cavetech.springboot.Accountbank.app.domain.AccountBank;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AccountBankService {

	
	//Flux<AccountBank> findxClient(String idClient);
	Mono<AccountBank> save(AccountBank accountBank);

	Flux<AccountBank> findAll();

	Mono<AccountBank> findById(String id);

	Mono<Void> deletexId(String id);

	Mono<Void> delete(AccountBank accountBank);
}
