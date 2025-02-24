package fr.remi.jegard.demojpa.bo;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE_OPERATION")
    private LocalDate dateOperation;

    @Column(name = "MONTANT")
    private Double montant;

    @Column(name = "MOTIF")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "COMPTE_ID")
    private Compte compte;

    public Operation() {}

    public Operation(LocalDate dateOperation, Double montant, String motif, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDate dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                '}';
    }
}