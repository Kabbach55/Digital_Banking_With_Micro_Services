package ma.emsi.Operationservice.entities;

import lombok.Data;
import ma.emsi.Operationservice.model.Compte;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
@DiscriminatorValue("V")
public class Virement extends Operation{
    private Long compteID2;
    @Transient
    private Compte compte2;

    public Virement(Long numeroOperation, Date dateOperation, double montate, Long compteID, Compte compte, Long compteID2, Compte compte2) {
        super(numeroOperation, dateOperation, montate, compteID, compte);
        this.compteID2 = compteID2;
        this.compte2 = compte2;
    }

    public Virement() {
        super();
    }
}
