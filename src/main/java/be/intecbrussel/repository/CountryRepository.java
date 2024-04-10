package be.intecbrussel.repository;

import be.intecbrussel.model.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("country_pu");
    EntityManager em = emf.createEntityManager();
    EntityTransaction entityTransaction;

    public CountryRepository() {
        this.entityTransaction = em.getTransaction();
    }

    public Country find(String name) {
        return em.find(Country.class, name);
    }

    public List<Country> findAllCountries() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        List<Country> resultList = query.getResultList();
        return new ArrayList<>(resultList);
    }

    public Country add(Country country) {
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        return country;
    }


    public Country update(Country country) {
        Country countryToUpdate = find(country.getName());
        if (countryToUpdate != null) {
            em.getTransaction().begin();
            countryToUpdate.setName(country.getName());
            countryToUpdate.setPopulation(country.getPopulation());
            countryToUpdate.setPresident(country.getPresident());
            em.getTransaction().commit();
            return countryToUpdate;
        } else {
            return null;
        }
    }

    public Optional<Country> delete(Country country) {
        String name = country.getName();
        Optional<Country> country1 = Optional.ofNullable(find(name));
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
        return country1;
    }
}
