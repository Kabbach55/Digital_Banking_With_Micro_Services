package ma.emsi.Customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

//@Entity
@Data
//@DiscriminatorValue("CC")

public class CompteCourant /*extends Compte*/ {
    private double decouvert;


   // public CompteCourant(Long codeCompte, Date dateCreation, double solde,double decouvert,Long clientID) {
    //    super(codeCompte,solde,dateCreation,clientID);
      //  this.decouvert = decouvert;
   // }

    public CompteCourant() {
        super();
    }
}
