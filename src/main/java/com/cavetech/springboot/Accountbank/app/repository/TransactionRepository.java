package com.cavetech.springboot.Accountbank.app.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cavetech.springboot.Accountbank.app.domain.Transactions;

import reactor.core.publisher.Flux;


public interface TransactionRepository   extends ReactiveMongoRepository<Transactions, String>{

	@Query("{'account.client.id' : ?0 }")	
	public Flux<Transactions> ListtransactionforClient( String idClient);
	
}
