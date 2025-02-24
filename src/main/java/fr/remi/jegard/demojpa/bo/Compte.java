package fr.remi.jegard.demojpa.bo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "SOLDE")
    private Double solde;

    @ManyToOne
    @JoinColumn(name = "BANQUE_ID")
    private Banque banque;

    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients;

    @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
    private List<Operation> operations;

    public Compte() {}

    public Compte(String numero, Double solde, Banque banque) {
        this.numero = numero;
        this.solde = solde;
        this.banque = banque;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                '}';
    }
}
