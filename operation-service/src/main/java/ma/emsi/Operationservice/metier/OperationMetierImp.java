package ma.emsi.Operationservice.metier;

import ma.emsi.Operationservice.entities.Operation;
import ma.emsi.Operationservice.entities.Virement;
import ma.emsi.Operationservice.feign.CompteRestClient;
import ma.emsi.Operationservice.model.Compte;
import ma.emsi.Operationservice.model.CompteCourant;
import ma.emsi.Operationservice.repositories.OperationRepository;
import ma.emsi.Operationservice.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class OperationMetierImp implements IOperationMetier{
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    CompteRestClient compteRestClient;
    @Autowired
    VirementRepository virementRepository;






    @Override
    public Compte consulterCompte(Long codeCpte) {
       Compte cp = compteRestClient.getCompte(codeCpte);
        if(cp == null) throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public void verser(Long codeCpte, double montant) {
        Compte cp = compteRestClient.getCompte(codeCpte);

        if(compteRestClient.getCompteCC(codeCpte) != null) {
            CompteCourant courant = compteRestClient.getCompteCC(codeCpte);
            courant.setSolde(courant.getSolde() + montant);
            compteRestClient.upadte(codeCpte,courant);
            System.out.println("walooo");
        }else System.out.println("walo");






    }

    @Override
    public void retirer(Long codeCpte, double montant) {
        Compte cp = consulterCompte(codeCpte);
        double facilitesCaisse = 0;
        if(cp instanceof CompteCourant)
            facilitesCaisse = ((CompteCourant) cp).getDecouvert();
        if(cp.getSolde() + facilitesCaisse < montant)
            throw new RuntimeException("Solde insuffisant");
       // Retrait r = new Retrait(new Date(), montant,codeCpte);
      //  operationRepository.save(r);
        cp.setSolde(cp.getSolde() - montant);
        compteRestClient.save(cp);

    }

    @Override
    public void virement(Long codeCpte1, Long codeCpte2, double montant) {
        if(codeCpte1.equals(codeCpte2)){
            throw new RuntimeException("Impossibile de faire un virement sur le même compte");
        }
        Compte c1 = consulterCompte(codeCpte1);
        Compte c2 = consulterCompte(codeCpte2);
        c1.setSolde(c1.getSolde()-montant);

        c2.setSolde(c2.getSolde()+montant);
        compteRestClient.upadte(codeCpte1,c1);
        compteRestClient.upadte(codeCpte2,c2);
        virementRepository.save(new Virement(null,new Date(),montant,codeCpte1,c1,codeCpte2,c2));


    }

    @Override
    public Page<Operation> listOperation(Long codeCpte, int page, int size) {
            return null;
        //return operationRepository.listOperation(codeCpte, new PageRequest(page, size));
    }
}
