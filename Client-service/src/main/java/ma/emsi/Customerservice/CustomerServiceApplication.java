package ma.emsi.Customerservice;

import ma.emsi.Customerservice.entities.Client;
import ma.emsi.Customerservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository){

		return args -> {
			clientRepository.save(new Client(null,"zakaria","cd , casablanca","0659661575"));
			clientRepository.save(new Client(null,"kabbach","anfa , casablanca","0659661575"));
			clientRepository.findAll().forEach(System.out::println);
		};
	}
}
