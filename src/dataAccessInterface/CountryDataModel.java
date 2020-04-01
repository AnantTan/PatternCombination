package dataAccessInterface;

import java.util.ArrayList;

import valueObject.CountryBuilderClass;

/*
 * interface for the methods that have to be implemented
 */
public interface CountryDataModel {

	public ArrayList<CountryBuilderClass> listAllCountries();

	public CountryBuilderClass findCountryByCountryCode(String code);

	public ArrayList<CountryBuilderClass> findCountryByName(String countryToBeFound);

	public void addNewCountry(CountryBuilderClass countryBuilderClass);
}
