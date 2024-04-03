package registration;
//this is for registration 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
/*
 * singleton class key
 * N\A
 */
public class DbManager {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/csmathapp";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1M@Y0URb17144473";

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	}

	public static void disconnect(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public boolean authenticateUser(String username, String password) {
		try (Connection connection = connect()) {
			String hashedPassword = hashPassword(password); // Implement the password hashing method 
			String query = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, hashedPassword);

			ResultSet resultSet = pstmt.executeQuery();
			return resultSet.next(); // Return true if a matching user is found
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean StudentspwAuthentication(String username, String password) {



		try (Connection connection = connect()){
			String query = "SELECT * FROM Students WHERE username = ? AND password = ?";
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();



			while (rs.next()) {
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");

				if (username.equals(dbUsername) && password.equals(dbPassword)) {

					return true;
				}
			}


			if (connection != null) {
				connection.close();
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		return false;
	}

	public boolean TeacherspwAuthentication(String name, String password) {
		try (Connection connection = connect()){
			String query = "SELECT * FROM Teachers WHERE username = ? AND password = ?";
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, name);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();



			while (rs.next()) {
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");

				if (name.equals(dbUsername) && password.equals(dbPassword)) {

					return true;
				}
			}


			if (connection != null) {
				connection.close();
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		return false;
	}


	private static String hashPassword(String password) {
		// Implement your password hashing logic here
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	//sign up methods
	public boolean studentExistence(String username) {
		try (Connection connection = connect()) {
			String query = ("SELECT * FROM students WHERE username = '" + username + "'");
			PreparedStatement pstmt = connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean teacherExistence(String username) {
		try (Connection connection = connect()) {
			String query = ("SELECT * FROM teachers WHERE username = '" + username + "'");
			PreparedStatement pstmt = connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public void studentCreation(String inputUN_SU, String hashed, String inputSCH_SU, String inputMAIL_SU) throws SQLException {
		//Create a SQL insert statement
		String insertQuery = "INSERT INTO students (username, password, school, email) VALUES (?, ?, ?, ?)";
		try (Connection connection = connect()) {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, inputUN_SU);
			preparedStatement.setString(2, hashed); 
			preparedStatement.setString(3, inputSCH_SU); 
			preparedStatement.setString(4, inputMAIL_SU); 


			// Execute the SQL statement
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("User registered successfully.");
			} else {
				System.out.println("User registration failed.");
			}
			preparedStatement.close();
		}
	}
	public void teacherCreation(String inputUN_SU, String hashed, String inputSCH_SU, String inputMAIL_SU) throws SQLException {
		//Create a SQL insert statement
		String insertQuery = "INSERT INTO teachers (username, password, school, email) VALUES (?, ?, ?, ?)";
		try (Connection connection = connect()) {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, inputUN_SU);
			preparedStatement.setString(2, hashed); 
			preparedStatement.setString(3, inputSCH_SU); 
			preparedStatement.setString(4, inputMAIL_SU); 


			// Execute the SQL statement
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("User registered successfully.");
			} else {
				System.out.println("User registration failed.");
			}
			preparedStatement.close();
		}
	}

}
