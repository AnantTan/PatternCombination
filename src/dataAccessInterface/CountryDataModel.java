package dataAccessInterface;

import java.util.ArrayList;

import valueObject.Country;

public interface CountryDataModel {
	
	public ArrayList<Country> listAllCountries();
	public Country findCountryByCountryCode(String code);
	public ArrayList<Country> findCountryByName(String countryToBeFound);
	public void addNewCountry(Country country);
}
