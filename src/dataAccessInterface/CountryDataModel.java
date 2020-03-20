package dataAccessInterface;

public interface CountryDataModel {
	
	public String listAllCountries();
	public String findCountryByCountryCode(int code);
	public String findCountryByName(String countryToBeFound);
	public void addNewCountry(String details);
}
