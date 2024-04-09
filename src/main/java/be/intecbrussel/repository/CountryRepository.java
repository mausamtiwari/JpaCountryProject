package be.intecbrussel.repository;

import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;


public class CountryRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("country_pu");
    EntityManager em = emf.createEntityManager();
    EntityTransaction entityTransaction;

    Country country;


    public CountryRepository() {
        this.entityTransaction = em.getTransaction();
    }


    public Country find(String name) {
        return em.find(Country.class, name);
    }

    public List<Country> findAllCountries() {
        List<Country> countries = new ArrayList<>();
        String name = country.getName();
        int population = country.getPopulation();
        President president = country.getPresident();
        Country country = new Country(name,population,president);

        countries.add(country);
        return countries;
    }


    public Country add(Country country) {
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        return country;
    }

    public Country update(Country country) {
        Country countryToUpdate = find(country.getName());
        em.getTransaction().begin();
        countryToUpdate.setName(country.getName());
        countryToUpdate.setPresident(country.getPresident());
        countryToUpdate.setPopulation(country.getPopulation());
        em.persist(countryToUpdate);
        entityTransaction.commit();
        return countryToUpdate;
    }

    public void delete(Country country) {
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

    }
}
