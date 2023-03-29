package br.edu.infnet.appmecanica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppmecanicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppmecanicaApplication.class, args);
	}

}
