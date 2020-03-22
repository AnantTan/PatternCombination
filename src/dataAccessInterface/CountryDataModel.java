package dataAccessInterface;

import valueObject.Country;

public interface CountryDataModel {
	
	public Country listAllCountries();
	public String findCountryByCountryCode(int code);
	public String findCountryByName(String countryToBeFound);
	public void addNewCountry(String details);
}
