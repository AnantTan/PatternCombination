package dataObjectConcrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataAccessInterface.CountryDataModel;
import enumerators.Continents;
import enumerators.DatabaseConnection;
import valueObject.Country;

public class CountryDAO implements CountryDataModel {

	private Connection connection;
	private PreparedStatement prepareStatement;
	private Country country;

	@Override
	public ArrayList<Country> listAllCountries() {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();// get instance of the enumerator
		connection = instance.getDatabaseConnection();// get the database connection from enumerator
		ArrayList<Country> countryList = new ArrayList<>();
		try {
			prepareStatement = connection.prepareStatement("SELECT * FROM country");
			ResultSet resultSet = prepareStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println("No data available");
			} else {
				while (resultSet.next()) {
					country = new Country.CountryBuilder().code(resultSet.getString(1))
							.countryName(resultSet.getString(2)).surfaceArea(resultSet.getFloat(4))
							.headOfState(resultSet.getString(5)).continent(Continents.valueOf(resultSet.getString(3)))
							.build();
					countryList.add(country);
				}
				connection.close();// close the connection when the data has been retrieved
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryList;
	}

	@Override
	public Country findCountryByCountryCode(String code) {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();
		connection = instance.getDatabaseConnection();
		try {
			prepareStatement = connection
					.prepareStatement("SELECT name,continent,headofstate FROM country where code = '" + code + "'");
			ResultSet resultSet = prepareStatement.executeQuery();
			// country = new Country();

			if (!resultSet.isBeforeFirst()) {
				System.out.println("No data available");
			} else {
				while (resultSet.next()) {
					country = new Country.CountryBuilder().countryName(resultSet.getString(1)).continent(Continents.valueOf(resultSet.getString(2)))
							.headOfState(resultSet.getString(3)).build();
				}
				connection.close();// close the database connection
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
	}

	@Override
	public ArrayList<Country> findCountryByName(String countryToBeFound) {
		// TODO Auto-generated method stub
		DatabaseConnection instance = DatabaseConnection.getInstance();
		connection = instance.getDatabaseConnection();
		ArrayList<Country> countryList = new ArrayList<>();
		try {
			prepareStatement = connection.prepareStatement(
					"SELECT * FROM country where name LIKE '%" + countryToBeFound + "%'");
			ResultSet resultSet = prepareStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
			} else {
				while (resultSet.next()) {
					country = new Country.CountryBuilder().code(resultSet.getString(1))
							.countryName(resultSet.getString(2)).continent(Continents.valueOf(resultSet.getString(3)))
							.headOfState(resultSet.getString(5)).surfaceArea(resultSet.getFloat(4)).build();
					countryList.add(country);
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
	public void addNewCountry(String details) {
		// TODO Auto-generated method stub

	}
}