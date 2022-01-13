package ma.emsi.Operationservice.metier;

import ma.emsi.Operationservice.entities.Operation;
import ma.emsi.Operationservice.model.Compte;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface IOperationMetier {
    public Compte consulterCompte(Long codeCpte);
    public void verser(Long codeCpte, double montant);
    public void retirer(Long codeCpte, double montant);
    public void virement(Long codeCpte1, Long codeCpte2, double montant);
    public Page<Operation> listOperation(Long codeCpte, int page, int size);
}
