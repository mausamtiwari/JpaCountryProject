package be.intecbrussel.service;

import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import be.intecbrussel.repository.CountryRepository;

import java.util.List;

public class CountryService {
    CountryRepository countryRepository = new CountryRepository();

    public Country getCountry(Country country) {
        countryRepository.find(country.getName());
        return country;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAllCountries();
    }

    public Country addCountry(String name, int population, President president) {
        Country country = new Country(name, population, president);
        countryRepository.add(country);
        return country;
    }



    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

    public Country updateCountry(Country country) {
        countryRepository.update(country);
        return country;
    }

}
