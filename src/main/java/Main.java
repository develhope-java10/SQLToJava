import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;

import java.sql.*;

public class Main {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "tommaso-123");
			System.out.println(connection != null);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM newdb.user");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		try {
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
			}
		}   catch (SQLException e){
			throw new RuntimeException(e);
		}



	}
}