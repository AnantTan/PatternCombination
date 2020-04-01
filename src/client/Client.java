package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import dataObjectConcrete.CountryDAO;
import enumerators.Continents;
import valueObject.CountryBuilderClass;

public class Client {

	BufferedReader bufferedReader;
	private int numberEntered, selectContinentName;
	private CountryDAO countryDAO;
	private CountryBuilderClass countryBuilderClass;
	private String enterCountryCode, enterCountryName, enterHeadOfState, continentName;
	private float enterSurfaceArea;

	Client() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		giveUserChoice();
	}

	private void giveUserChoice() {
		// a loop to ask the user for choice again and again
		do {
			start();
		} while (numberEntered != 0);
	}

	private void start() {
		VisualUserInteraction.getUserInteraction();// getting user interaction by printing lines
		try {
			numberEntered = Integer.parseInt(bufferedReader.readLine());// get user input
		} catch (Exception e) {
			System.out.println("Please enter a number");
			giveUserChoice();
		}
		workAccordingToInput(numberEntered);// proceed according to the user input
	}

	private void workAccordingToInput(int num) {

		switch (num) {
		// this case is responsible for printing all the countries in the database
		case 1:
			countryDAO = new CountryDAO();
			VisualUserInteraction.showAllCountries(countryDAO.listAllCountries());// print all the countries
			break;

		// this case is responsible for printing the country at a given code in the
		// database
		case 2:
			VisualUserInteraction.enterCountryCode();// print out the related prompt
			enterCountryCode = getUserInputAsString();// getting user input for the code
			countryDAO = new CountryDAO();// creating an object of the data access object class
			// printing the country related to the code
			VisualUserInteraction.resultOfFindingCountryByCode(countryDAO.findCountryByCountryCode(enterCountryCode));
			break;

		// this case is responsible for printing all the countries in the database for a
		// given set of letters
		case 3:
			VisualUserInteraction.enterNameOfCountry();// print out the related prompt
			enterCountryName = getUserInputAsString();// getting user input for the country name
			countryDAO = new CountryDAO();
			// printing all the countries found with that set of letters
			VisualUserInteraction.showAllCountries(countryDAO.findCountryByName(enterCountryName));
			break;

		// this case is responsible for adding a new country in the database
		case 4:
			VisualUserInteraction.enterCountryCode();// print out the related prompt
			enterCountryCode = getUserInputAsString();// getting user input for code

			VisualUserInteraction.enterNameOfCountry();// print out the related prompt
			enterCountryName = getUserInputAsString();// getting user input for country name

			VisualUserInteraction.selectContinentName();// print out the related prompt
			selectContinentName = getUserInputForContinent();// getting user input for continent number selected
			continentName = getContinentName(selectContinentName);// getting the continent from the number selected

			VisualUserInteraction.enterSurfaceArea();// print out the related prompt
			enterSurfaceArea = getSurfaceArea();// getting the user input for surface area

			VisualUserInteraction.enterHeadOfState();// print out the related prompt
			enterHeadOfState = getUserInputAsString();// getting the user input for head of state

			// passing all the user input that will be used to create an object
			createNewCountry(enterCountryCode, enterCountryName, continentName, enterSurfaceArea, enterHeadOfState);
		}
	}

	private final void createNewCountry(String countryCode, String countryName, String continentName, float surfaceArea,
			String headOfState) {

		// creating a new country object using the builder class
		countryBuilderClass = new CountryBuilderClass.CountryBuilder().code(countryCode).countryName(countryName)
				.continent(Continents.getContinent(continentName)).surfaceArea(surfaceArea).headOfState(headOfState)
				.build();

		countryDAO = new CountryDAO();
		countryDAO.addNewCountry(countryBuilderClass);// passing the object to add a new country in the database
	}

	private String getUserInputAsString() {
		String input = "";
		boolean isValid = false;
		// do while to validate a wrong input
		do {
			try {
				input = bufferedReader.readLine();// get user input
			} catch (Exception e) {
				VisualUserInteraction.somethingIsWrong();// print related message
				isValid = false;
			}
			if (input.isEmpty()) {
				System.out.println("Blank entry is not allowed");
				isValid = false;
			} else
				isValid = true;// setting boolean to true
		} while (isValid != true);// while boolean is not true keep going
		return input;
	}

	private int getUserInputForContinent() {
		boolean isValid = false;
		do {
			System.out.print("Enter here: ");
			try {
				selectContinentName = Integer.parseInt(bufferedReader.readLine());
			} catch (Exception e) {
				VisualUserInteraction.somethingIsWrong();
				isValid = false;
			}
			// selection should be between 0-8
			if (selectContinentName > 0 && selectContinentName < 8) {
				isValid = true;
			}
		} while (isValid != true);
		return selectContinentName;
	}

	private float getSurfaceArea() {
		boolean isValid = false;
		do {
			try {
				enterSurfaceArea = Float.parseFloat(bufferedReader.readLine());
			} catch (Exception e) {
				VisualUserInteraction.somethingIsWrong();
				isValid = false;
			}
			// surface area should be greater than 0
			if (enterSurfaceArea > 0) {
				isValid = true;
			} else
				System.out.println("It has to be more than 0");
		} while (isValid != true);
		return enterSurfaceArea;
	}

	// this method will return the continent at the selected number
	private final String getContinentName(int num) {
		switch (num) {
		case 1:
			return Continents.Asia.getContinentName();
		case 2:
			return Continents.Africa.getContinentName();
		case 3:
			return Continents.Antarctica.getContinentName();
		case 4:
			return Continents.Europe.getContinentName();
		case 5:
			return Continents.NorthAmerica.getContinentName();
		case 6:
			return Continents.SouthAmerica.getContinentName();
		case 7:
			return Continents.Oceania.getContinentName();
		default:
			return null;
		}
	}
}