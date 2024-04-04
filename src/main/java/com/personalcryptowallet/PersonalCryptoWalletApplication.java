package com.personalcryptowallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PersonalCryptoWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalCryptoWalletApplication.class, args);
	}

}
