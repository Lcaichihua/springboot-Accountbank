package com.cavetech.springboot.Accountbank.app.service;

import com.cavetech.springboot.Accountbank.app.domain.Transactions;
import com.cavetech.springboot.Accountbank.app.dto.OperationDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OperationService {

	public Mono<Transactions> retirement (OperationDto dto);
	public Mono<Transactions> deposit (OperationDto dto);
	
}
