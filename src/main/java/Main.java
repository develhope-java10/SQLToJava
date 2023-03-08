import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;

import java.sql.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Connection connection = null;
		ArrayList<User> usersList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/forum", "root", "Mysqlpass123");
			System.out.println(connection != null);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM forum.users WHERE name= 'federica' AND surname = 'rossi'");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		try {
			while(resultSet.next()){
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String surName = resultSet.getString(3);
				User user = new User(id,name,surName);
				usersList.add(user);

			}
		}   catch (SQLException e){
			throw new RuntimeException(e);
		}
		System.out.println(usersList);



	}
}