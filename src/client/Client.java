package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import dataObjectConcrete.CountryDAO;
import enumerators.Continents;
import valueObject.Country;

public class Client {

	BufferedReader bufferedReader;
	private int numberEntered, selectContinentName;
	private CountryDAO countryDAO;
	private Country country;
	private String enterCountryCode, enterCountryName, enterHeadOfState, continentName;
	private float enterSurfaceArea;

	private Client() {
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
		VisualUserInteraction.getUserInteraction();
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
			countryDAO = new CountryDAO();
			VisualUserInteraction.showAllCountries(countryDAO.listAllCountries());
			break;

		case 2:
			VisualUserInteraction.enterCountryCode();
			enterCountryCode = getUserInputAsString();
			countryDAO = new CountryDAO();
			country = countryDAO.findCountryByCountryCode(enterCountryCode);
			VisualUserInteraction.resultOfFindingCountryByCode(country);
			break;

		case 3:
			VisualUserInteraction.enterNameOfCountry();
			enterCountryName = getUserInputAsString();
			countryDAO = new CountryDAO();
			VisualUserInteraction.showAllCountries(countryDAO.findCountryByName(enterCountryName));
			break;

		case 4:
			VisualUserInteraction.enterCountryCode();
			enterCountryCode = getUserInputAsString();

			VisualUserInteraction.enterNameOfCountry();
			enterCountryName = getUserInputAsString();

			VisualUserInteraction.selectContinentName();
			selectContinentName = getUserInputForContinent();
			continentName = getContinentName(selectContinentName);

			VisualUserInteraction.enterSurfaceArea();
			enterSurfaceArea = getSurfaceArea();

			VisualUserInteraction.enterHeadOfState();
			enterHeadOfState = getUserInputAsString();

			createNewCountry(enterCountryCode, enterCountryName, continentName, enterSurfaceArea, enterHeadOfState);
		}
	}

	private void createNewCountry(String countryCode, String countryName, String continentName, float surfaceArea,
			String headOfState) {
		
		country = new Country.CountryBuilder().code(countryCode).countryName(countryName)
				.continent(Continents.getContinent(continentName)).surfaceArea(surfaceArea).headOfState(headOfState).build();
		
		countryDAO = new CountryDAO();
		countryDAO.addNewCountry(country);
	}

	private String getUserInputAsString() {
		String input = "";
		boolean isValid = false;
		do {
			try {
				input = bufferedReader.readLine();
			} catch (Exception e) {
				System.out.println("Something is wrong! Please follow the instructions");
				isValid = false;
			}
			if (input.isEmpty()) {
				System.out.println("Blank entry is not allowed");
				isValid = false;
			} else
				isValid = true;
		} while (isValid != true);
		return input;
	}

	private int getUserInputForContinent() {
		boolean isValid = false;
		do {
			System.out.print("Enter here: ");
			try {
				selectContinentName = Integer.parseInt(bufferedReader.readLine());
			} catch (Exception e) {
				System.out.println("Something is wrong! Please follow the instructions\n");
				isValid = false;
			}
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
				System.out.println("Something is wrong! Please follow the instructions\n");
				isValid = false;
			}
			if (enterSurfaceArea > 0) {
				isValid = true;
			} else
				System.out.println("It has to be more than 0");
		} while (isValid != true);
		return enterSurfaceArea;
	}

	private String getContinentName(int num) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client();
	}
}