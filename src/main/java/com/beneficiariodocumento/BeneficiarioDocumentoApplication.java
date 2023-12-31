package com.beneficiariodocumento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beneficiariodocumento.services.DBService;

@SpringBootApplication
public class BeneficiarioDocumentoApplication implements CommandLineRunner {
	
	@Autowired
	private DBService dbService;
	
	public static void main(String[] args) {
		SpringApplication.run(BeneficiarioDocumentoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		dbService.instanciarDataBase();
	}

}
