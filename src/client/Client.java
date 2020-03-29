package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dataObjectConcrete.CountryDAO;
import enumerators.Continents;
import enumerators.DatabaseConnection;
import valueObject.Country;

public class Client {

	BufferedReader bufferedReader;
	int numberEntered;
	CountryDAO countryDAO;
	private Country country;
	private ArrayList<Country> countries;
	private String userInput;

	private Client() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// data();
		// start();
		giveUserChoice();
	}

//	private void data()
//	{
//		DatabaseConnection connection = DatabaseConnection.getInstance();
//		Connection connection2 = connection.getDatabaseConnection();
//		try {
//		PreparedStatement prepareStatement = connection2.prepareStatement("INSERT INTO country VALUES(?,?,?,?,?)");
//		prepareStatement.setInt(1, 89);
//		prepareStatement.setString(2, "Man");
//		prepareStatement.setString(3, String.valueOf(Continents.Antarctica));
//		prepareStatement.setFloat(4, 11);
//		prepareStatement.setString(5, "myself");
//	int	count = prepareStatement.executeUpdate();
//		if (count > 0) {
//			JOptionPane.showMessageDialog(null, "Your Verfication is Pending");
//
//		}
//		
//		}catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//	
	private void giveUserChoice() {
		// a loop to ask the user for choice again and again
		do {
			start();
		} while (numberEntered != 0);
	}

	private void start() {
		System.out.println("\nEnter 0 to exit the system");
		System.out.println("Enter 1 to list all countries in database");
		System.out.println("Enter 2 to find country by code");
		System.out.println("Enter 3 to find country by name\n");
		try {
			numberEntered = Integer.parseInt(bufferedReader.readLine());
		} catch (Exception e) {
			System.out.println("Please enter a number");
			giveUserChoice();
		}
		workAccordingToInput(numberEntered);
	}

	private void workAccordingToInput(int num) {
		
		switch (num) {
		case 1:
			System.out.println("1111");
			countryDAO = new CountryDAO();
			showAllCountries(countries = countryDAO.listAllCountries());
			break;

		case 2:
			System.out.println("Enter a country code");
			userInput = getUserInput();
			countryDAO = new CountryDAO();
			country = countryDAO.findCountryByCountryCode(userInput);
			System.out.println("Country found: " + country.getCountryName());
			break;

		case 3:
			System.out.println("Enter a name of a country");
			userInput = getUserInput();
			countryDAO = new CountryDAO();
			showAllCountries(countryDAO.findCountryByName(userInput));
			break;
		}
	}
	
	private String getUserInput()
	{
		String input = "";
		try {
			input = bufferedReader.readLine();
		} catch (Exception e) {
			System.out.println("Something is wrong! Please follow the instructions");
		}
		return input;
	}
	
	private void showAllCountries(ArrayList<Country> countries)
	{
		for (Country country : countries) {
			System.out.println(country.getCountryName());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client();
	}

}
