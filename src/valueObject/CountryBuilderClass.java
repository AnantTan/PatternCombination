package valueObject;

import enumerators.Continents;

/*
 * this is the builder class that will be used to create objects of new country using builder pattern
 */
public class CountryBuilderClass {

	private String code;
	private String countryName;
	private Continents continent;
	private float surfaceArea;
	private String headOfState;

	private CountryBuilderClass(CountryBuilder builder) {
		// putting values in the global variables from the static builder class
		this.code = builder.code;
		this.countryName = builder.countryName;
		this.continent = builder.continent;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
	}

	// getters to access the values of the private variables
	public String getCode() {
		return code;
	}

	public String getCountryName() {
		return countryName;
	}

	public Continents getContinent() {
		// patch for null continents
//		if(continent==null)
//		{
//			return Continents.Asia;
//		}
		return continent;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	// implementing the builder pattern
	// static inner class to create object of outer class
	public static class CountryBuilder {
		private String code;
		private String countryName;
		private Continents continent;
		private float surfaceArea;
		private String headOfState;

		public CountryBuilder code(final String code) {
			this.code = code;
			return this;//return the Country builder object
		}

		public CountryBuilder countryName(final String countryName) {
			this.countryName = countryName;
			return this;
		}

		public CountryBuilder continent(final Continents continent) {
			this.continent = continent;
			return this;
		}

		public CountryBuilder surfaceArea(final float surfaceArea) {
			this.surfaceArea = surfaceArea;
			return this;
		}

		public CountryBuilder headOfState(final String headOfState) {
			this.headOfState = headOfState;
			return this;
		}

		public CountryBuilderClass build() {
			return new CountryBuilderClass(this);// return the object parent class country builder
		}
	}
}