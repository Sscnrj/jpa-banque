package fr.remi.jegard.demojpa.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {

    @Column(name = "TAUX")
    private Double taux;

    public LivretA() {}

    public LivretA(String numero, Double solde, Banque banque, Double taux) {
        super(numero, solde, banque);
        this.taux = taux;
    }

    // Getter & Setter
    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                ", taux=" + taux +
                '}';
    }
}
