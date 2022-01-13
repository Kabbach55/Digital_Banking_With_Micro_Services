package ma.emsi.Operationservice;


import ma.emsi.Operationservice.entities.Operation;
import ma.emsi.Operationservice.feign.CompteRestClient;
import ma.emsi.Operationservice.metier.IOperationMetier;
import ma.emsi.Operationservice.model.Compte;
import ma.emsi.Operationservice.repositories.OperationRepository;
import ma.emsi.Operationservice.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class OperationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			OperationRepository operationRepository,
			VirementRepository virementRepository,
			IOperationMetier iOperationMetier,
			CompteRestClient compteRestClient


	){
		return args -> {
			Compte cp1 =compteRestClient.getCompte(1L);
			Compte cp2 =compteRestClient.getCompte(2L);
			//operationRepository.save(new Operation(null,new Date(),500,1L));

			System.out.println(cp1);
			System.out.println(cp2);
			iOperationMetier.virement(1L,2L,1);





			System.out.println("#################################");
			System.out.println(cp1);
			System.out.println(cp2);

			operationRepository.findAll().forEach(op->{

				System.out.println(op.getMontate());
				;
			});


			System.out.println();
		};
	}
}

