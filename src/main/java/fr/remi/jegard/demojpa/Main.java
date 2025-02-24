package fr.remi.jegard.demojpa;

import fr.remi.jegard.demojpa.bo.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        // Création Banque
        Banque banque = new Banque("Banque Populaire");
        em.persist(banque);

        // Adresse commune (facultatif)
        Adresse adresse = new Adresse(10, "Rue de Paris", "Paris", 75000);
        em.persist(adresse);

        Adresse adresse1 = new Adresse(20, "Rue de Lyon", "Lyon", 69000);
        em.persist(adresse1);

        Adresse adresse2 = new Adresse(30, "Rue de Marseille", "Marseille", 13000);
        em.persist(adresse2);

        // ===== Insérer un compte associé à 2 clients =====

        Client client1 = new Client("Dupont", "Jean", banque, adresse);
        Client client2 = new Client("Durand", "Marie", banque, adresse1);
        em.persist(client1);
        em.persist(client2);

        LivretA livretCommun = new LivretA("FR123456", 10000.0, banque, 1.25);
        livretCommun.setClients(List.of(client1, client2));
        em.persist(livretCommun);

        client1.setComptes(List.of(livretCommun));
        client2.setComptes(List.of(livretCommun));

        // ===== Insérer un client avec plusieurs comptes =====

        Client client3 = new Client("Martin", "Paul", banque, adresse2);
        em.persist(client3);

        AssuranceVie assuranceVie = new AssuranceVie("FR654321", 20000.0, banque, 2.0, LocalDate.of(2030, 12, 31));
        LivretA livretA = new LivretA("FR789456", 15000.0, banque, 1.5);

        assuranceVie.setClients(List.of(client3));
        livretA.setClients(List.of(client3));

        em.persist(assuranceVie);
        em.persist(livretA);

        client3.setComptes(List.of(assuranceVie, livretA));

        // ===== Insérer des opérations de type virement =====

        Virement virement1 = new Virement(LocalDate.now(), 500.0, "Salaire Mars", assuranceVie, "Employeur SARL");
        em.persist(virement1);
        assuranceVie.setOperations(List.of(virement1));

        // ===== Insérer des opérations simples =====

        OperationSimple depot = new OperationSimple(LocalDate.now(), 250.0, "Dépôt espèces", livretA);
        em.persist(depot);
        livretA.setOperations(List.of(depot));

        // Validation finale
        transaction.commit();

        em.close();
        emf.close();

        System.out.println("Fin du tp4");
    }
}
