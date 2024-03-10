package com.personalcryptowallet;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class PersonalCryptoWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalCryptoWalletApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner demo(TesteRepository repository) {
		return (args) -> {
			repository.save(Teste.builder().nome("Testando " + UUID.randomUUID()).build());
		};
	}

}
