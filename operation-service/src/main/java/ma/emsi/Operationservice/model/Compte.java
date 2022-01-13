package ma.emsi.Operationservice.model;

import lombok.Data;
import ma.emsi.Operationservice.entities.Operation;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2 )
public class Compte {
    private  Long code;
    private double solde;
    private Date dateCreation;
    private Long ClientID;
}
