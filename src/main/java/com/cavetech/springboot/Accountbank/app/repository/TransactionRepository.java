package com.cavetech.springboot.Accountbank.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cavetech.springboot.Accountbank.app.domain.AccountBank;
import com.cavetech.springboot.Accountbank.app.domain.Transactions;

import reactor.core.publisher.Mono;

public interface TransactionRepository   extends ReactiveMongoRepository<Transactions, String>{

	//alta definir el query
	public Mono<Transactions> findByNumcount( String numcount);
	
}
