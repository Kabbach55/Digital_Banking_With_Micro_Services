package ma.emsi.Customerservice;

import ma.emsi.Customerservice.entities.Compte;
import ma.emsi.Customerservice.entities.CompteCourant;
import ma.emsi.Customerservice.enums.StatusCompte;
import ma.emsi.Customerservice.enums.TypeCompte;
import ma.emsi.Customerservice.feign.ClientRestClient;
import ma.emsi.Customerservice.model.Client;
import ma.emsi.Customerservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository,
							ClientRestClient clientRestClient,
							RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Compte.class);
			Client client =clientRestClient.findClientById(1L);
			Client client2 =clientRestClient.findClientById(1L);
			compteRepository.save(new Compte(null,"99000",98000,new Date(),client.getCode(), TypeCompte.COURANT, StatusCompte.ACTIF,null));
			compteRepository.save(new Compte(null,"98000",98000,new Date(),client2.getCode(), TypeCompte.COURANT, StatusCompte.ACTIF,null));
			compteRepository.findAll().forEach(cp->{

				System.out.println(cp);
				;
			});
			System.out.println(client.getFirstName());
		};
	}
}
