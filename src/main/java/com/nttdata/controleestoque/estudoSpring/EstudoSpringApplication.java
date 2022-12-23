package com.nttdata.controleestoque.estudoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.swing.*;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EstudoSpringApplication {

	private boolean SQLIntegrityConstraintViolationException;
	private  String verificaCpf;

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringApplication.class, args);

	}



}
