package be.intecbrussel;

import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import be.intecbrussel.service.CountryService;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CountryService countryService = new CountryService();

        President president1 = new President("Ram Chandra Poudel", 79);
        President president2 = new President("Alexander De Croo", 48);
        President president3 = new President("Emmanuel Macron", 46);

        Country country1 = countryService.addCountry("Nepal", 30550000, president1);
        Country country2 = countryService.addCountry("Belgium", 11690000, president2);
        Country country3 = countryService.addCountry("France", 67970000, president3);


        Optional<Country> foundCountry = countryService.getCountry("Nepal");
        foundCountry.ifPresent(country -> System.out.println("Country found: " + country));


        List<Country> countryList = countryService.getAllCountries();
        System.out.println("All countries");
        countryList.forEach(System.out::println);

        // Updating a country
        country2.setPopulation(2000000000);
        countryService.updateCountry(country2);
        System.out.println("Updated country: " + country2);

        // Deleting a country
        countryService.deleteCountry(country3);
        System.out.println("The deleted country is:" + country3);
    }
}
