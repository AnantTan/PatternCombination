package valueObject;

import enumerators.Continents;

public class Country {

	private final String code;
	private String countryName;
	private Continents continent;
	private float surfaceArea;
	private String headOfState;

	private Country(CountryBuilder builder) {
		this.code = builder.code;
		this.countryName = builder.countryName;
		this.continent = builder.continent;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
	}

	public String getCode() {
		return code;
	}

	public String getCountryName() {
		return countryName;
	}

	public Continents getContinent() {
		return continent;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public static class CountryBuilder {
		private String code;
		private String countryName;
		private Continents continent;
		private float surfaceArea;
		private String headOfState;

		public CountryBuilder code(final String code) {
			this.code = code;
			return this;
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

		public Country build() {
			return new Country(this);
		}
	}
}