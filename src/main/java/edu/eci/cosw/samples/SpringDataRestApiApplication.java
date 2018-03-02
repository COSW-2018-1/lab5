package edu.eci.cosw.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import edu.eci.cosw.jpa.sample.model.PatientsRepository;
import edu.eci.cosw.jpa.sample.model.*;

@SpringBootApplication
@EnableJpaRepositories("edu.eci.cosw.jpa.sample.model")
@EntityScan("edu.eci.cosw.jpa.sample.model")
public class SpringDataRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApiApplication.class, args);
	}
}
