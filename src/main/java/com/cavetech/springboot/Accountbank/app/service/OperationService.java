package com.cavetech.springboot.Accountbank.app.service;

import com.cavetech.springboot.Accountbank.app.domain.Transactions;
import com.cavetech.springboot.Accountbank.app.dto.OperationDto;

import reactor.core.publisher.Mono;

public interface OperationService {

	public Mono<Transactions> ActionAccountBank (OperationDto dto);
}
