package ma.emsi.Clientservice.web;

import ma.emsi.Clientservice.entities.Client;
import ma.emsi.Clientservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @PostMapping(path="/saveComptes")
    public Client save(@RequestBody Client client){
        return  clientRepository.save(client);
    }


}
