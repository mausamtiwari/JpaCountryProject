package be.intecbrussel;

import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import be.intecbrussel.service.CountryService;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        CountryService countryService = new CountryService();
        Country country1 = countryService.addCountry("Nepal", 30550000, new President("Ram Chandra Poudel", 79));
        Country country2 = countryService.addCountry("Belgium", 11690000, new President("Alexander De Croo", 48));
        Country country3 = countryService.addCountry("Frankrijk", 67970000, new President("Emmanuel Macron", 46));

        countryService.getCountry(country1);
        System.out.println("Country found: " + country1);

       /* List<Country> countryList = countryService.getAllCountries();
        System.out.println("All countries");
        for (Country country : countryList) {
            System.out.println(country);
        }*/

       /* country2.setName("Belgie");
        countryService.updateCountry(country2);
        System.out.println("Updated country: " + country2);*/

        countryService.deleteCountry(country3);


    }
}