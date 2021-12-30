package ma.emsi.Customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.Customerservice.enums.StatusCompte;
import ma.emsi.Customerservice.enums.TypeCompte;
import ma.emsi.Customerservice.model.Client;


import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2 )
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long code;
    private String number;
    private double solde;
    private Date dateCreation;
    private Long ClientID;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    @Enumerated(EnumType.STRING)
    private StatusCompte status;

    @Transient
    private Client client;





}