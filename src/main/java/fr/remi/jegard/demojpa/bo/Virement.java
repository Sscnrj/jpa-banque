package fr.remi.jegard.demojpa.bo;
import jakarta.persistence.*;

@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation {

    @Column(name = "BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {}

    public Virement(java.time.LocalDate dateOperation, Double montant, String motif, Compte compte, String beneficiaire) {
        super(dateOperation, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    // Getter & Setter
    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return "Virement{" +
                "id=" + getId() +
                ", dateOperation=" + getDateOperation() +
                ", montant=" + getMontant() +
                ", motif='" + getMotif() + '\'' +
                ", beneficiaire='" + beneficiaire + '\'' +
                '}';
    }
}