package be.intecbrussel.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Getter;

@Getter

public class EntityManagerProvider {
    EntityManagerFactory emf;

    EntityManager entityManager;

    EntityTransaction entityTransaction;

    public EntityManagerProvider() {
        this.emf = Persistence.createEntityManagerFactory("country_pu");
        this.entityManager = emf.createEntityManager();
        this.entityTransaction = getEntityTransaction();
    }

}
