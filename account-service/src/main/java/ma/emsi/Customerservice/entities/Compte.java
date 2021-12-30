package ma.emsi.Customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.Customerservice.enums.TypeCompte;


import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long code;
    private double solde;
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}