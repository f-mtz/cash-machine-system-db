package com.fmtz.bank.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fmtz.bank.entities.Cliente;
import com.fmtz.bank.entities.Conta;
import com.fmtz.bank.repositories.ClienteRepository;
import com.fmtz.bank.repositories.ContaRepository;


	@Configuration
	@Profile("test")
	public class TestConfigBank2 implements CommandLineRunner {

		@Autowired
		private ContaRepository contaRepository;

		@Autowired
		private ClienteRepository clientRepository;

		@Override
		public void run(String... args) throws Exception {

			Cliente cli1 = new Cliente(null, "Jake", "jake@gmail.com");
			Cliente cli2 = new Cliente(null, "Jason", "jason@gmail.com");
			Cliente cli3 = new Cliente(null, "Bruce", "bruce@gmail.com");

			clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3));

			Conta c1 = new Conta(null, 1234, /**cli1,*/ 1000.0, 200.0);
			Conta c2 = new Conta(null, 2345,  /**cli2,*/ 500.0, 200.0);
			Conta c3 = new Conta(null, 3456,  /**cli3,*/ 100.0, 200.0);
			
			
			c1.getDeposito(500.0);
			c2.getSaque(10.0);
			c3.getTransferir(c1, 500.0);

			contaRepository.saveAll(Arrays.asList(c1, c2, c3));
		}

	}

