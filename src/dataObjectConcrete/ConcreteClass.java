package dataObjectConcrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import dataAccessInterface.CountryDataModel;
import enumerators.Continents;
import enumerators.DatabaseConnection;
import valueObject.Country;

public class ConcreteClass implements CountryDataModel {

	private Connection connection;
	private PreparedStatement prepareStatement;

	@Override
	public Country listAllCountries() {
		// TODO Auto-generated method stub
		//DatabaseConnection instance = DatabaseConnection.getInstance();
		//connection = instance.getDatabaseConnection();
		ArrayList<Country> countryList = new ArrayList<>();
		Country country = new Country();
		country.setCode(2);
		country.setCountryName("India");
		country.setContinent(Continents.Asia);
		country.setSurfaceArea(12);
		country.setHeadOfState("Mysekf");
		countryList.add(country);
		//prepareStatement = 
		return country;
	}

	@Override
	public String findCountryByCountryCode(int code) {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();
		connection = instance.getDatabaseConnection();
		//prepareStatement = 
		return null;
	}

	@Override
	public String findCountryByName(String countryToBeFound) {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();
		connection = instance.getDatabaseConnection();
		//prepareStatement = 
		return null;
	}

	@Override
	public void addNewCountry(String details) {
		// TODO Auto-generated method stub

	}
}