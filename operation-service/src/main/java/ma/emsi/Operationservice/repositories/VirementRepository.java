package ma.emsi.Operationservice.repositories;


import ma.emsi.Operationservice.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementRepository extends JpaRepository<Virement,Long> {
}
