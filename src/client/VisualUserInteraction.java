package client;

import java.util.ArrayList;

import enumerators.Continents;
import valueObject.CountryBuilderClass;
/*
 * this class is responsible for the 99% of all the print statements
 */

public class VisualUserInteraction {

	public final static void enterCountryCode() {
		System.out.print("Enter a country code: ");
	}

	public final static void enterNameOfCountry() {
		System.out.print("Enter a name of a country: ");
	}

	public final static void getUserInteraction() {
		System.out.println("\nEnter 0 to exit the system");
		System.out.println("Enter 1 to list all countries in database");
		System.out.println("Enter 2 to find country by code");
		System.out.println("Enter 3 to find country by name");
		System.out.println("Enter 4 to add a new country\n");
	}

	public final static void showAllCountries(ArrayList<CountryBuilderClass> countryBuilderClass) {
		//if the variable is empty that means there is no data
		if (countryBuilderClass.isEmpty()) {
			System.out.println("\nNo data available");
			return;
		}
		for (CountryBuilderClass countryBuilder : countryBuilderClass) {
			System.out.println("\nCode: \t\t" + countryBuilder.getCode());
			System.out.println("Country: \t" + countryBuilder.getCountryName());
			System.out.println("Continent: \t" + countryBuilder.getContinent().getContinentName());
			System.out.println("Surface Area: \t" + countryBuilder.getSurfaceArea());
			System.out.println("Head of state: \t" + countryBuilder.getHeadOfState() + "\n");
		}
	}

	public final static void resultOfFindingCountryByCode(CountryBuilderClass countryBuilderClass) {
		//if the object of the builder class is null it means there is no data
		if (countryBuilderClass == null) {
			System.out.println("\nNo data available");
			return;
		}
		System.out.println("\nCountry: \t" + countryBuilderClass.getCountryName());
		System.out.println("Continent: \t" + countryBuilderClass.getContinent().getContinentName());
		System.out.println("Surface area: \t" + countryBuilderClass.getSurfaceArea());
		System.out.println("Head Of State: \t" + countryBuilderClass.getHeadOfState() + "\n");

	}

	public final static void selectContinentName() {

		//this is printing all the names of the continents
		System.out.println("Enter 1 for:\t" + Continents.Asia.getContinentName());
		System.out.println("Enter 2 for:\t" + Continents.Africa.getContinentName());
		System.out.println("Enter 3 for:\t" + Continents.Antarctica.getContinentName());
		System.out.println("Enter 4 for:\t" + Continents.Europe.getContinentName());
		System.out.println("Enter 5 for:\t" + Continents.NorthAmerica.getContinentName());
		System.out.println("Enter 6 for:\t" + Continents.SouthAmerica.getContinentName());
		System.out.println("Enter 7 for:\t" + Continents.Oceania.getContinentName());
	}

	public final static void enterSurfaceArea() {
		System.out.print("Enter surface area: ");
	}

	public final static void enterHeadOfState() {
		System.out.print("Enter the head of state: ");
	}

	public final static void somethingIsWrong() {
		System.out.println("Something is wrong! Please follow the instructions\n");
	}
}