package com.accounts.accounts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
