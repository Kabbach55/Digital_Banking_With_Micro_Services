package ma.emsi.Operationservice.model;

import lombok.Data;

import javax.persistence.DiscriminatorValue;

@Data
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
    private double taux;

}
