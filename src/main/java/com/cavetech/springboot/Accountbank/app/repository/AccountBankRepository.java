package com.cavetech.springboot.Accountbank.app.repository;
			
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cavetech.springboot.Accountbank.app.domain.AccountBank;
import com.cavetech.springboot.Accountbank.app.domain.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountBankRepository extends ReactiveMongoRepository<AccountBank, String>{
	//public  Flux<AccountBank> findxClient(Client Client);
	
	@Query("{'client.id' : ?0 , 'client.type.valtip' : ?1 , 'product.codigo' : ?2}")	
	public Flux<AccountBank> findQuery(String idCliente, Integer codigoTipoCliente, Integer idTipoProducto);


	public Flux<AccountBank> findByClient( Client client);	
	
	
	public Mono<AccountBank> findByNumcount( String numcount);
	
	
} 
