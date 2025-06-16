package br.com.fiap.FarmaNear_Register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FarmaNearRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaNearRegisterApplication.class, args);
	}

}
