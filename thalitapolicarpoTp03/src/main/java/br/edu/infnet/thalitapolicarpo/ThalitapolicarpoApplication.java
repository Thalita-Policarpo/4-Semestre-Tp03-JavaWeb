package br.edu.infnet.thalitapolicarpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"br.edu.infnet.thalitapolicarpo.model.service", "other.packages.to.scan"})
public class ThalitapolicarpoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThalitapolicarpoApplication.class, args);
	}

}
