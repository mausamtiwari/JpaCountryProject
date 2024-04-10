package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import be.intecbrussel.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

public class CountryService {
    private CountryRepository countryRepository;
    EntityManagerProvider entityManagerProvider;

    public CountryService() {
        this.entityManagerProvider = new EntityManagerProvider();
        this.countryRepository = new CountryRepository();
    }

    public Optional<Country> getCountry(String name) {
        return Optional.ofNullable(countryRepository.find(name));
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAllCountries();
    }

    public Country addCountry(String name, int population, President president) {
        Country country = new Country(name, population, president);
        return countryRepository.add(country);
    }

    public void updateCountry(Country country) {
        countryRepository.update(country);
    }

    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }
}
