package ma.emsi.Customerservice.repositories;

import ma.emsi.Customerservice.entities.Compte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {

}
