package valueObject;

import enumerators.Continents;

public class Country {

	private int code;
	private String countryName;
	private Continents continent;
	private float surfaceArea;
	private String headOfState;
	
	public Country(int code,String countryName,Continents continent,float surfaceArea,String headOfState)
	{
		this.code = code;
		this.countryName = countryName;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
	}
	
	public Country(){
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Continents getContinent() {
		return continent;
	}

	public void setContinent(Continents continent) {
		this.continent = continent;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	
}
