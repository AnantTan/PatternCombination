package client;

import java.util.ArrayList;

import valueObject.Country;

public class VisualUserInteraction {

	public static void showAllCountries(ArrayList<Country> countries)
	{
		for (Country country : countries) {
			System.out.println("\nCountry: " +country.getCountryName());
			System.out.println("Continent: "+country.getContinent()+"\n");
		}
	}
	
	public static void resultOfFindingCountryByCode(Country country)
	{
		System.out.println("\nCountry: " + country.getCountryName());
		System.out.println("Continent: "+country.getContinent());
		System.out.println("Head Of State: "+country.getHeadOfState());
	}	
}
