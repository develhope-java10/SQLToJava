import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");

			List<Student> students = new ArrayList<>();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");

				Student student = new Student(id, firstName, lastName);
				students.add(student);
			}

			System.out.println(students);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		try {
			Student student = new Student(-1, "Paolo", "Novellini");

			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Students(first_name, last_name) VALUES (?, ?)"
			);

			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());

			statement.execute();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}
}
