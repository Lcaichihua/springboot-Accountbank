package com.cavetech.springboot.Account.app;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringbootAccountApplicationTests {

	/* 
	 * 	
	@Autowired
	private WebTestClient client;
	
	@Autowired
	private ProductBankService bankService;
	
	
	@Test
	void FindAllProductBankTest() {
		client.get()
		.uri("/productbank/list")
		.exchange()
		.expectStatus().isOk()
		.expectBodyList(ProductBank.class)
		.consumeWith(response -> {
			List<ProductBank> productBank = response.getResponseBody();
			productBank.forEach(b ->{
				System.out.println(b.getDescription());
			});
			
			Assertions.assertThat(productBank.size()>0).isTrue();
		});
	}
	
	@Test
	void saveProductBank() {
		ProductBank prod = new ProductBank("cuenta prueba2", new TypeProductBank("5e334b9f0cdb675a8671ad15","Cuenta Bancaria"),5);
		client.post()
		.uri("/productbank")
		.body(Mono.just(prod), ProductBank.class)
		.exchange()
		.expectStatus().isOk()
		.expectBody(ProductBank.class)
		.consumeWith(response -> {
			ProductBank b = response.getResponseBody();
			System.out.println("[PRODUCTO BANCARIO REGISTRADO] " + prod);
			Assertions.assertThat(b.getCodigo()).isNotNull().isEqualTo(5);
			Assertions.assertThat(b.getDescription()).isNotEmpty().isEqualTo("cuenta prueba2");
			
		});
	}
	
	 * 
	 * */

}
