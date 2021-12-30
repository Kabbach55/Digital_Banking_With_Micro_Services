package ma.emsi.Operationservice.model;


import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Data
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
    private double decouvert;


}
