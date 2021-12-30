package ma.emsi.Clientservice;

import ma.emsi.Clientservice.entities.Client;
import ma.emsi.Clientservice.repositories.ClientRepository;
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
	CommandLineRunner start(ClientRepository clientRepository,
							RepositoryRestConfiguration restConfiguration){

		return args -> {
			restConfiguration.exposeIdsFor(Client.class);
			clientRepository.save(new Client(null,"zakaria","kabbach","zakaria@gmail.com","11"));
			clientRepository.save(new Client(null,"zakaria","kabbach","zakaria@gmail.com","11"));
			clientRepository.findAll().forEach(System.out::println);
		};
	}
}
