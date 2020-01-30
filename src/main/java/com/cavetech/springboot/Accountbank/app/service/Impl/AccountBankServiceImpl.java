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
					return WebClient.builder().baseUrl("http://localhost:8009/client/client/").build().get()
				.uri(accountBank.getClient().getId()).retrieve().bodyToMono(Client.class).log()
				.flatMap(cl -> {
					accountBank.setClient(cl);
					return WebClient.builder().baseUrl("http://localhost:8009/productbank/productbank/").build().get()
							.uri(accountBank.getProduct().getId()).retrieve()
							.bodyToMono(ProductBank.class).log();
				})
				.flatMap(sa -> {
					accountBank.setProduct(sa);
				return	ValidCant(accountBank).count();
					
				})
				
				.flatMap(count -> { 
					//valida tipo Cliente uno
					if(accountBank.getClient().getType().getValtip()==1) { 
						System.out.println("el codigo es ");
						System.out.println(count);
					if( accountBank.getProduct().getCodigo()==1 || 
							accountBank.getProduct().getCodigo()==2 ||
							accountBank.getProduct().getCodigo()==3) {
						if(count > 0) {
							
							String error = "el cliente ya cuenta con una cuenta tipo "+
							accountBank.getProduct().getDescription() ;
							return Mono.error(new InterruptedException(error));
		
						}
						return accbankrep.save(accountBank);
						
					}
					String error = "el cliente debe no puede tener asignado este producto "+
							accountBank.getProduct().getDescription() ;
							return Mono.error(new InterruptedException(error));
						
							// valida tipo Cliente uno
					} else if (accountBank.getClient().getType().getValtip()==2) {
						if(accountBank.getProduct().getCodigo()==1 || 
								accountBank.getProduct().getCodigo()==3  ) {
							String error = "el cliente no puede acceder a estos productos "+
									accountBank.getProduct().getDescription() ;
									return Mono.error(new InterruptedException(error));
							
						}else if(accountBank.getProduct().getCodigo()==2 ) {
							return accbankrep.save(accountBank);
						}
						
					}
					return accbankrep.save(accountBank);
				
				});
	}

	
	public Flux<AccountBank> ValidCant(AccountBank acc) {
return accbankrep.findQuery(acc.getClient().getId(),
acc.getClient().getType().getValtip(), acc.getProduct().getCodigo());
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
