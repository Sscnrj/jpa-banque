package fr.remi.jegard.demojpa.bo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "BANQUE")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM")
    private String nom;

    @OneToMany(mappedBy = "banque", fetch = FetchType.LAZY)
    private List<Client> clients;

    @OneToMany(mappedBy = "banque", fetch = FetchType.LAZY)
    private List<Compte> comptes;

    public Banque() {}

    public Banque(String nom) {
        this.nom = nom;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}