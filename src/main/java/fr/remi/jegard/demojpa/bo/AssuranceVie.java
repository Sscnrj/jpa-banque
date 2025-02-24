package fr.remi.jegard.demojpa.bo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte {

    @Column(name = "TAUX")
    private Double taux;

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    public AssuranceVie() {}

    public AssuranceVie(String numero, Double solde, Banque banque, Double taux, LocalDate dateFin) {
        super(numero, solde, banque);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    // Getters & Setters
    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                ", taux=" + taux +
                ", dateFin=" + dateFin +
                '}';
    }
}

