package enumerators;

public enum Continents {

	Asia("Asia"), Europe("Europe"), NorthAmerica("North America"), SouthAmerica("South America"), Africa("Africa"),
	Oceania("Oceania"), Antarctica("Antarctica");

	private String contientName;

	Continents(String name) {
		this.contientName = name;
	}

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
		return contientName;
	}
}