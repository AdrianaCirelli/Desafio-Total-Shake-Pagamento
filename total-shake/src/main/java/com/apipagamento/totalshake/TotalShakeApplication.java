package com.apipagamento.totalshake;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class TotalShakeApplication {
	public static void main(String[] args) {
		SpringApplication.run(TotalShakeApplication.class, args);
	}
	// @Bean diz pro Spring que é para disponibilizar com o api  - nesse caso para Modelmapper
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
