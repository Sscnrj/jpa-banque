package fr.remi.jegard.demojpa.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "OPERATION_SIMPLE")
public class OperationSimple extends Operation {
    public OperationSimple() {}
    public OperationSimple(LocalDate dateOperation, Double montant, String motif, Compte compte) {
        super(dateOperation, montant, motif, compte);
    }
}
