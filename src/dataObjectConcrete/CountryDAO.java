package dataObjectConcrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataAccessInterface.CountryDataModel;
import enumerators.Continents;
import enumerators.DatabaseConnection;
import valueObject.CountryBuilderClass;

public class CountryDAO implements CountryDataModel {

	private Connection connection;
	private PreparedStatement prepareStatement;
	private CountryBuilderClass countryBuilderClass;

	@Override
	public ArrayList<CountryBuilderClass> listAllCountries() {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();// get instance of the enumerator
		connection = instance.getDatabaseConnection();// get the database connection from enumerator
		ArrayList<CountryBuilderClass> countryList = new ArrayList<>();// a list of country type to store all the countries data
		try {
			prepareStatement = connection.prepareStatement("SELECT * FROM country");// query to get everything from the
																					// table country
			ResultSet resultSet = prepareStatement.executeQuery();// execute the query
			if (!resultSet.isBeforeFirst()) {
				return countryList;// if there is nothing in the database return empty arrayList
			} else {
				while (resultSet.next()) {
					// create country object having all the data using the builder class
					countryBuilderClass = new CountryBuilderClass.CountryBuilder().code(resultSet.getString(1))
							.countryName(resultSet.getString(2)).surfaceArea(resultSet.getFloat(4))
							.headOfState(resultSet.getString(5))
							.continent(Continents.getContinent(resultSet.getString(3))).build();
					countryList.add(countryBuilderClass);// adding the object to the list
				}
				connection.close();// close the connection when the data has been retrieved
			}
		} catch (SQLException e) {
			System.out.println("There could be a blank entry" + e);// problem occurred
		}
		return countryList;
	}

	@Override
	public CountryBuilderClass findCountryByCountryCode(String code) {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();// get instance of the enumerator
		connection = instance.getDatabaseConnection();// get the database connection from enumerator
		try {
			prepareStatement = connection
					.prepareStatement("SELECT name,continent,surfacearea,headofstate FROM country where code = '" + code + "'");// query
																													// to
																													// find
																													// rows
																													// where
																													// given
																													// code
																													// is
																													// found
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				// creating country objects with the found country
				countryBuilderClass = new CountryBuilderClass.CountryBuilder().countryName(resultSet.getString(1))
						.continent(Continents.getContinent(resultSet.getString(2))).surfaceArea(resultSet.getFloat(3)).headOfState(resultSet.getString(4))
						.build();
			}
			connection.close();// close the database connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryBuilderClass;// returning country object
	}

	@Override
	public ArrayList<CountryBuilderClass> findCountryByName(String countryToBeFound) {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();
		connection = instance.getDatabaseConnection();
		ArrayList<CountryBuilderClass> countryList = new ArrayList<>();
		try {
			prepareStatement = connection
					.prepareStatement("SELECT * FROM country where name LIKE '%" + countryToBeFound + "%'");// query to
																											// get all
																											// the rows
																											// where the
																											// country
																											// name is
																											// found
			ResultSet resultSet = prepareStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
			} else {
				while (resultSet.next()) {
					// creating country objects for all the rows that match
					countryBuilderClass = new CountryBuilderClass.CountryBuilder().code(resultSet.getString(1))
							.countryName(resultSet.getString(2))
							.continent(Continents.getContinent(resultSet.getString(3)))
							.headOfState(resultSet.getString(5)).surfaceArea(resultSet.getFloat(4)).build();
					countryList.add(countryBuilderClass);// adding the objects to the list
				}
				connection.close();// close the connection
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryList;
	}

	@Override
	public void addNewCountry(CountryBuilderClass countryBuilderClass) {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();
		connection = instance.getDatabaseConnection();
		try {
			prepareStatement = connection.prepareStatement("INSERT INTO country VALUES(?,?,?,?,?)");// query to add a
																									// new country
			prepareStatement.setString(1, countryBuilderClass.getCode());// gets country code from the object
			prepareStatement.setString(2, countryBuilderClass.getCountryName());// gets the country name from the object
			prepareStatement.setString(3, countryBuilderClass.getContinent().getContinentName());// gets the continent and pass it
																						// as a string from the object
			prepareStatement.setFloat(4, countryBuilderClass.getSurfaceArea());// get the surface area from the object
			prepareStatement.setString(5, countryBuilderClass.getHeadOfState());// gets the head of state from the object

			int count = prepareStatement.executeUpdate();// execute the update to add the country
			if (count > 0) {
				System.out.println("New country added successfuly");
			}
			connection.close();// close the database connection after the operation
		} catch (Exception e) {
			System.out.println(
					"\nCountry code may already have been used \nOR" + "\nCountry code SHOULD be of MAX 3 letters\nOR\n"
							+ "Surface area too big (10,2)\nTRY AGAIN!");
		}
	}
}