package enumerators;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;
/*
 * Enumerator class used to get database connection
 * Singleton pattern implemented in the safest way
 */
public enum DatabaseConnection {

	Connection;
	private Connection connection;

	public static DatabaseConnection getInstance() {
		return Connection;//return the instance of the enumerator class
	}
	
	public Connection getDatabaseConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:MySql://52.50.23.197:3306/world", "cctstudent", "Pass1234!");
			//if database is connected show a message
			if (!connection.isClosed()) {
				System.out.println("\n////////// Database Connected //////////\n");
			}
		} catch (Exception e) {
			//if some error display a message
			JOptionPane.showMessageDialog(null, e.toString());
			System.exit(0);
		}
		return connection;//return the database connection
	}
}