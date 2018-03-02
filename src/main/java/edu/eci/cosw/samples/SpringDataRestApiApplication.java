package edu.eci.cosw.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("edu.eci.cosw.paquete1.paquete2.paquete3")
@EntityScan("edu.eci.cosw.jpa.paquete1.paquete2.paquete3")
@SpringBootApplication
public class SpringDataRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApiApplication.class, args);
	}
}
