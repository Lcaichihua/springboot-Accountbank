package com.cavetech.springboot.Accountbank.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cavetech.springboot.Accountbank.app.domain.ActionAccount;
import com.cavetech.springboot.Accountbank.app.domain.Transactions;
import com.cavetech.springboot.Accountbank.app.dto.OperationDto;

import reactor.core.publisher.Mono;

public interface TransactionRepository   extends ReactiveMongoRepository<Transactions, String>{
	

}
