package ma.emsi.Customerservice.feign;

import ma.emsi.Customerservice.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Client-service")
public interface ClientRestClient {
    @GetMapping("/clients/{id}")
    Client findClientById(@PathVariable("id") Long id);



}