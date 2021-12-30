package ma.emsi.Customerservice.web;

import ma.emsi.Customerservice.entities.Compte;
import ma.emsi.Customerservice.entities.CompteCourant;
import ma.emsi.Customerservice.entities.CompteEpargne;
import ma.emsi.Customerservice.repositories.CompteCCRepository;
import ma.emsi.Customerservice.repositories.CompteCERepository;
import ma.emsi.Customerservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class CompteController {
    @Autowired
    CompteRepository compteRepository;
    /*
    @Autowired
    CompteCCRepository compteCCRepository;
    @Autowired
    CompteCERepository compteCERepository;*/


    @GetMapping(path = "/comptes/{id}")
    public Compte getCompte(@PathVariable(name = "id") Long code){

        return compteRepository.findById(code).get();
    }
/*
    @GetMapping(path = "/comptesCC/{id}")
    public Compte getCompteCC(@PathVariable(name = "id") Long code){
        return compteCCRepository.findById(code).get();
    }

    @PostMapping(path="/comptesCC")
    public Compte save(@RequestBody CompteCourant compte){
        return  compteCCRepository.save(compte);
    }

    @PostMapping(path="/comptesCE")
    public Compte save(@RequestBody CompteEpargne compte){
        return  compteCERepository.save(compte);
    }



*/
    @PutMapping(path="/comptes/{code}")
    public Compte upadte(@PathVariable Long code, @RequestBody Compte compte){
        compte.setCode(code);
        return  compteRepository.save(compte);
    }
    /*

    @PutMapping(path="/comptesCE/{code}")
    public Compte upadte(@PathVariable Long code, @RequestBody CompteEpargne compte){
        compte.setCode(code);
        return  compteCERepository.save(compte);
    }
*/
}

