package enumerators;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

public enum DatabaseConnection {

	Connection;
	private Connection connection;
	public int i;

	public static DatabaseConnection getInstance() {
		return Connection;
	}
	
	public Connection getDatabaseConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:MySql://52.50.23.197:3306/world", "cctstudent", "Pass1234!");
			if (!connection.isClosed()) {
				JOptionPane.showMessageDialog(null, "Database connected");// ensuring the connectivity
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			System.exit(0);
		}
		return connection;
	}
}