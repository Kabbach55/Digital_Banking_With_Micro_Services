package ma.emsi.Operationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.emsi.Operationservice.model.Compte;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPT",discriminatorType=DiscriminatorType.STRING,length=1 )
public class Operation   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroOperation;
    private Date dateOperation;
    private double montate;
    private Long compteID;
    @Transient
    private Compte compte;



}
