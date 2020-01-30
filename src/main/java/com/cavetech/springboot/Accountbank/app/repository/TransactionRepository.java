package com.cavetech.springboot.Accountbank.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import com.cavetech.springboot.Accountbank.app.domain.Transactions;

public interface TransactionRepository   extends ReactiveMongoRepository<Transactions, String>{
	

	
}
