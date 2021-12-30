package ma.emsi.Operationservice.web;

import ma.emsi.Operationservice.entities.Operation;
import ma.emsi.Operationservice.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class OperationController {

    @Autowired
    OperationRepository operationRepository;



    @GetMapping(path = "/operations/{id}")
    public Operation getOperation(@PathVariable(name = "id") Long code){

        return operationRepository.findById(code).get();
    }





}
