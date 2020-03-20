package enumerators;

public enum DatabaseConnection {

	Connection;

	private DatabaseConnection() {

	}

	public static DatabaseConnection getDatabaseConnection() {
		return Connection;
	}

}
