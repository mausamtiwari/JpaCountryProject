package be.intecbrussel.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private EntityManagerFactory emf;

    public EntityManagerProvider() {
        this.emf = Persistence.createEntityManagerFactory("country_pu");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
