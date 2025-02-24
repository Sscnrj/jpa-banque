package fr.remi.jegard.demojpa.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "ADRESSE")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "RUE")
    private String rue;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "CODE_POSTAL")
    private Integer codePostal;

    @OneToOne(mappedBy = "adresse")
    private Client client;

    public Adresse() {}


    public Adresse(Integer numero, String rue, String ville, Integer codePostal) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numero=" + numero +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal=" + codePostal +
                '}';
    }
}
