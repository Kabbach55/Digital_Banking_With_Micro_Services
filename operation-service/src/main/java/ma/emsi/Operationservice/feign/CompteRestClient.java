package ma.emsi.Operationservice.feign;


import ma.emsi.Operationservice.model.Compte;
import ma.emsi.Operationservice.model.CompteCourant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="account-service")
public interface CompteRestClient {


    @GetMapping(path = "/comptes/{id}")
    Compte getCompte(@PathVariable(name = "id") Long code);

    @PostMapping (path="/comptes")
    Compte save(@RequestBody Compte compte);

    @GetMapping(path = "/comptesCC/{id}")
    public CompteCourant getCompteCC(@PathVariable(name = "id") Long code);

    @PutMapping(path="/comptesCC/{code}")
    public CompteCourant upadte(@PathVariable Long code, @RequestBody CompteCourant compte);

    @PutMapping(path="/comptes/{code}")
    public Compte upadte(@PathVariable Long code, @RequestBody Compte compte);




}
