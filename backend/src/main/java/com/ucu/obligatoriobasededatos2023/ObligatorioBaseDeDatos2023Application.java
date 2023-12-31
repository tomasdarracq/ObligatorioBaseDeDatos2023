package com.ucu.obligatoriobasededatos2023;

import com.ucu.obligatoriobasededatos2023.login.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
public class ObligatorioBaseDeDatos2023Application {

	public static void main(String[] args) {
		SpringApplication.run(ObligatorioBaseDeDatos2023Application.class, args);
	}


}
