package ma.emsi.Customerservice.model;

import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
public class Client {
    private Long code;
    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;

}