package enumerators;

public enum Continents {

	// name of continents
	Asia("Asia"), Europe("Europe"), NorthAmerica("North America"), SouthAmerica("South America"), Africa("Africa"),
	Oceania("Oceania"), Antarctica("Antarctica");

	private String contientName;

	Continents(String name) {
		this.contientName = name;
	}

	// mapper class to match the entries in the database
	public final static Continents getContinent(String continent) {
		switch (continent) {
		case "Asia":
			return Continents.Asia;
		case "Europe":
			return Continents.Europe;
		case "North America":
			return Continents.NorthAmerica;
		case "South America":
			return Continents.SouthAmerica;
		case "Africa":
			return Continents.Africa;
		case "Oceania":
			return Continents.Oceania;
		case "Antarctica":
			return Continents.Antarctica;
		default:
			return null;
		}
	}

	public String getContinentName() {
		return contientName;// return the name of the continent
	}
}