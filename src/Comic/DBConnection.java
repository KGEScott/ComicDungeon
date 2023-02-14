package Comic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class DBConnection {

	protected static String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
	protected static String user = "root";
	protected static String password = "new_password";

	public static boolean checkUNnPass(String username, String userPassword) {

		String pwd = userPassword;
		String uNToDB = username;
		boolean nameAndPassInDB = false;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String sql = "SELECT userName, password FROM user WHERE userName = " + "'" + uNToDB + "'";
			ResultSet rs = stmt.executeQuery(sql);

			// Check if the username is in the result set
			boolean isUsernameInDB = rs.next();

			if (isUsernameInDB) {

				// Get the hashed password from the database
				String storedPassword = rs.getString("password");

				// Compare the hashed password with the password from the user
				if (BCrypt.checkpw(pwd, storedPassword)) {
					nameAndPassInDB = true;
					con.close();
				} else {
					nameAndPassInDB = false;
					con.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nameAndPassInDB;
	}

	public static boolean caIsInDB(String username) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		String uNToDB = username;
		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String sql = "SELECT * FROM user WHERE userName = " + "'" + uNToDB + "'";
			ResultSet rs = stmt.executeQuery(sql);

			// Check if the username is in the result set
			boolean isUsernameInDB = rs.next();

			if (isUsernameInDB == true) {
				con.close();
				return isUsernameInDB;
			} else {
				con.close();
				return false;

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return false;
		}
	}

	public static boolean emailInDB(String email) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		String isEmail = email;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String sql = "SELECT * FROM user WHERE email = " + "'" + isEmail + "'";
			ResultSet rs = stmt.executeQuery(sql);

			// Check if the username is in the result set
			boolean isEmailInDB = rs.next();

			if (isEmailInDB == true) {
				con.close();
				return isEmailInDB;

			} else {
				con.close();
				return false;

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return false;
		}
	}

	public static void insertCA(String userNameCA, String userFirstName, String userLastName, String userEmail,
			String userYear, String userMonth, String userDay, String userPassCA, int q1Index, String q1Answer,
			int q2Index, String q2Answer, int q3Index, String q3Answer) {

		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		String hashedPassword = BCrypt.hashpw(userPassCA, BCrypt.gensalt());
		String id = null;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO user (userName, firstName, lastName, email, DoB, securityQ1, securityQ2, securityQ3, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "SELECT id FROM user WHERE userName = " + "'" + userNameCA + "'";
			String sql3 = "INSERT INTO security_questions (q1, q2, q3, user_id) VALUES (?, ?, ?, ?)";

			PreparedStatement insertStmt = con.prepareStatement(sql);
			String month = LoginInfo.getMonth();

			int monthNum = 0;
			int dayInt = Integer.parseInt(userDay);
			String dayToStr = "01";
			String monthToStr = "01";

			if (month == "Jan") {
				monthNum = 1;
			}
			if (month == "Feb") {
				monthNum = 2;
			}
			if (month == "Mar") {
				monthNum = 3;
			}
			if (month == "Apr") {
				monthNum = 4;
			}
			if (month == "May") {
				monthNum = 5;
			}
			if (month == "Jun") {
				monthNum = 6;
			}
			if (month == "Jul") {
				monthNum = 7;
			}
			if (month == "Aug") {
				monthNum = 8;
			}
			if (month == "Sep") {
				monthNum = 9;
			}
			if (month == "Oct") {
				monthNum = 10;
			}
			if (month == "Nov") {
				monthNum = 11;
			}
			if (month == "Dec") {
				monthNum = 12;
			}
			if (monthNum <= 9) {
				String toString = String.valueOf(monthNum);
				monthToStr = "0" + toString;
			} else {
				monthToStr = String.valueOf(monthNum);
			}
			if (dayInt <= 9) {
				dayToStr = "0" + String.valueOf(dayInt);
			}
			String date = userYear + "-" + monthToStr + "-" + dayToStr;

			insertStmt.setString(1, userNameCA);
			insertStmt.setString(2, userFirstName);
			insertStmt.setString(3, userLastName);
			insertStmt.setString(4, userEmail);
			insertStmt.setString(5, date);
			insertStmt.setString(6, q1Answer);
			insertStmt.setString(7, q2Answer);
			insertStmt.setString(8, q3Answer);
			insertStmt.setString(9, hashedPassword);
			insertStmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(sql2);
			if (rs.next()) {
				id = rs.getString("id");
			}
			PreparedStatement qIndexInsertStmt = con.prepareStatement(sql3);
			String q1IS = String.valueOf(q1Index);
			String q2IS = String.valueOf(q2Index);
			String q3IS = String.valueOf(q3Index);
			qIndexInsertStmt.setString(1, q1IS);
			qIndexInsertStmt.setString(2, q2IS);
			qIndexInsertStmt.setString(3, q3IS);
			qIndexInsertStmt.setString(4, id);
			qIndexInsertStmt.executeUpdate();
			con.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			// return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			// return false;
		}
	}

	public static List<String> pullUserInfo(String username) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		String uNToDB = username;

		List<String> userInfo = null;
		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String sql = "SELECT * FROM user WHERE userName = " + "'" + uNToDB + "'";
			ResultSet rs = stmt.executeQuery(sql);

			// Check if the username is in the result set
			userInfo = new ArrayList<String>();
			while (rs.next()) {
				for (int iteration = 2; iteration <= 6; iteration++)
					userInfo.add(rs.getString(iteration));
			}
			con.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
		return userInfo;
	}

	public static boolean changePW(String username, String prevPass, String newPass) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		List<String> userPW = null;
		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String cPWQ = "SELECT password FROM user WHERE userName = " + "'" + username + "'";
			ResultSet rs = stmt.executeQuery(cPWQ);

			// Check if the username is in the result set
			userPW = new ArrayList<String>();
			while (rs.next()) {
				userPW.add(rs.getString(1));
			}

			if (BCrypt.checkpw(prevPass, userPW.get(0))) {
				String addPass = "UPDATE user SET password=? WHERE userName= " + "'" + username + "'";

				PreparedStatement insertStmt = con.prepareStatement(addPass);
				insertStmt.setString(1, newPass);
				insertStmt.executeUpdate();
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return false;
		}
	}

	public static List<Map<String, String>> pullPublisher(String getPublisher) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String pubSQL = "SELECT id, name FROM gcd_publisher WHERE name LIKE " + "'%" + getPublisher
					+ "%' ORDER BY name";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> publisherData = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> publisher = new HashMap<String, String>();
				publisher.put("id", rs.getString("id"));
				publisher.put("name", rs.getString("name"));
				publisherData.add(publisher);
			}
			con.close();
			return publisherData;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullSeries(String idEnter) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Set the input parameter value
			// Execute a query to retrieve data from the "user" table
			String pubSQL = "SELECT id, name FROM gcd_series WHERE publisher_id = " + "'" + idEnter
					+ "' ORDER BY name, year_began";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> seriesData = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> series = new HashMap<String, String>();
				series.put("id", rs.getString("id"));
				series.put("name", rs.getString("name"));
				seriesData.add(series);
			}
			con.close();
			return seriesData;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullSeriesName(String seriesName) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Set the input parameter value
			// Execute a query to retrieve data from the "user" table
			String pubSQL = "SELECT id, name, publisher_id FROM gcd_series WHERE name LIKE " + "'%" + seriesName
					+ "%' ORDER BY name, year_began";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> seriesData = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> series = new HashMap<String, String>();
				series.put("id", rs.getString("id"));
				series.put("name", rs.getString("name"));
				series.put("publisher_id", rs.getString("publisher_id"));
				seriesData.add(series);
			}
			con.close();
			return seriesData;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullPublisherInfo(String idView) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String pubSQL = "SELECT id, name, year_began, notes, series_count, created, issue_count FROM gcd_publisher WHERE id = "
					+ "'" + idView + "' ORDER BY name";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> publisherInfo = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> publisherInformation = new HashMap<String, String>();
				publisherInformation.put("id", rs.getString("id"));
				publisherInformation.put("name", rs.getString("name"));
				publisherInformation.put("year_began", rs.getString("year_began"));
				publisherInformation.put("notes", rs.getString("notes"));
				publisherInformation.put("series_count", rs.getString("series_count"));
				publisherInformation.put("created", rs.getString("created"));
				publisherInformation.put("issue_count", rs.getString("issue_count"));
				publisherInfo.add(publisherInformation);
			}
			con.close();
			return publisherInfo;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullComics(String seriesID) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Set the input parameter value
			// Execute a query to retrieve data from the "user" table
			String pubSQL = "SELECT volume, number, publication_date, id FROM gcd_issue WHERE series_id = " + "'"
					+ seriesID + "'";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> comicData = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> series = new HashMap<String, String>();
				series.put("volume", rs.getString("volume"));
				series.put("number", rs.getString("number"));
				series.put("publication_date", rs.getString("publication_date"));
				series.put("id", rs.getString("id"));
				comicData.add(series);
			}
			con.close();
			return comicData;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullSeriesInfo(String seriesID) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String pubSQL = "SELECT id, name, year_began, year_ended, notes, color, dimensions, paper_stock,"
					+ "binding, publishing_format FROM gcd_series WHERE id = " + "'" + seriesID + "' ORDER BY name";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> seriesInfo = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> seriesInformation = new HashMap<String, String>();
				seriesInformation.put("id", rs.getString("id"));
				seriesInformation.put("name", rs.getString("name"));
				seriesInformation.put("year_began", rs.getString("year_began"));
				seriesInformation.put("year_ended", rs.getString("year_ended"));
				seriesInformation.put("notes", rs.getString("notes"));
				seriesInformation.put("color", "color");
				seriesInformation.put("dimensions", rs.getString("dimensions"));
				seriesInformation.put("paper_stock", rs.getString("paper_stock"));
				seriesInformation.put("binding", rs.getString("binding"));
				seriesInformation.put("publishing_format", rs.getString("publishing_format"));
				seriesInfo.add(seriesInformation);
			}
			con.close();
			return seriesInfo;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullComicsInfo(String comicsID) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String pubSQL = "SELECT id, number, publication_date, price, page_count, editing, notes, on_sale_date  FROM gcd_issue WHERE id = "
					+ "'" + comicsID + "'";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> comicsInfo = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> comicsInformation = new HashMap<String, String>();
				comicsInformation.put("id", rs.getString("id"));
				comicsInformation.put("number", rs.getString("number"));
				comicsInformation.put("publication_date", rs.getString("publication_date"));
				comicsInformation.put("price", rs.getString("price"));
				comicsInformation.put("page_count", rs.getString("page_count"));
				comicsInformation.put("editing", rs.getString("editing"));
				comicsInformation.put("notes", rs.getString("notes"));
				comicsInformation.put("on_sale_date", rs.getString("on_sale_date"));
				comicsInfo.add(comicsInformation);
			}
			con.close();
			return comicsInfo;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;
		}
	}

	public static boolean checkUserNameAndEmail(String username, String newEmail) {
		String email = newEmail;
		String uNInDB = username;
		boolean nameAndEmailInDB = false;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement stmt = con
					.prepareStatement("SELECT id, username, email FROM user WHERE username = ? AND email = ?");
			stmt.setString(1, uNInDB);
			stmt.setString(2, email);

			// Execute a query to retrieve data from the "user" table
			ResultSet rs = stmt.executeQuery();

			// Check if the username is in the result set
			if (rs.next()) {
				// Get the username and email from db
				int storedUserID = rs.getInt("id");
				String storedUsername = rs.getString("username");
				String storedEmail = rs.getString("email");
				LoginInfo.setUserID(storedUserID);
				LoginInfo.setUsername(storedUsername);
				LoginInfo.setEmail(storedEmail);
				nameAndEmailInDB = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nameAndEmailInDB;
	}

	public static void pullQuestions(int userID) {
		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		int userIDInDB = userID;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);

			// Execute a query to retrieve data from the "security_questions" table
			PreparedStatement stmt = con
					.prepareStatement("SELECT q1, q2, q3 FROM security_questions WHERE user_id = ?");
			stmt.setInt(1, userIDInDB);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Sets int values for the security questions
				int q1Int = rs.getInt("q1");
				int q2Int = rs.getInt("q2");
				int q3Int = rs.getInt("q3");
				LoginInfo.setQ1Index(q1Int);
				LoginInfo.setQ2Index(q2Int);
				LoginInfo.setQ3Index(q3Int);
			} else {
				System.out.println("No matching rows found for userID: " + userID);
			}
			con.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public static boolean checkSecurityQuestions(int id, String q1Answers, String q2Answers, String q3Answers) {

		boolean securityAnswersSame = false;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement stmt = con
					.prepareStatement("SELECT securityQ1, securityQ2, securityQ3 FROM user WHERE id = ?");
			stmt.setInt(1, id);

			// Execute a query to retrieve data from the "user" table
			ResultSet rs = stmt.executeQuery();

			// Check if the username is in the result set
			if (rs.next()) {
				// Get the username and email from db
				String storedQ1 = rs.getString("securityQ1");
				String storedQ2 = rs.getString("securityQ2");
				String storedQ3 = rs.getString("securityQ3");

				if (q1Answers.equalsIgnoreCase(storedQ1) && q2Answers.equalsIgnoreCase(storedQ2)
						&& q3Answers.equalsIgnoreCase(storedQ3)) {
					securityAnswersSame = true;
				} else {
					securityAnswersSame = false;
				}
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return securityAnswersSame;
	}

	public static void forgotPWChange(int id, String newPass) {

		// URL, username, and password to access the database
		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		String hashedPassword = BCrypt.hashpw(newPass, BCrypt.gensalt());

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);

			// Execute a query to change the password within the database.
			PreparedStatement stmt = con.prepareStatement("UPDATE user SET password = ? WHERE id = ?");
			stmt.setString(1, hashedPassword);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			con.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public static void addComic(String userName, String comicID, String seriesID, String publisherID) {

		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			con.setAutoCommit(false);
			String sql = "SELECT id FROM user WHERE username = ?";
			PreparedStatement selectStmt = con.prepareStatement(sql);
			selectStmt.setString(1, userName);
			ResultSet resultSet = selectStmt.executeQuery();
			int userID = 0;
			if (resultSet.next()) {
				userID = resultSet.getInt("id");
			}

			String sql2 = "SELECT count FROM user_collection WHERE user_id = ? AND comic_id = ?";
			PreparedStatement selectStmt2 = con.prepareStatement(sql2);
			selectStmt2.setInt(1, userID);
			selectStmt2.setString(2, comicID);
			ResultSet resultSet2 = selectStmt2.executeQuery();
			int count = 0;
			if (resultSet2.next()) {
				count = resultSet2.getInt("count");
				count++;
				String sql3 = "UPDATE user_collection SET count=? WHERE user_id=? AND comic_id=?";
				PreparedStatement updateStmt = con.prepareStatement(sql3);
				updateStmt.setInt(1, count);
				updateStmt.setInt(2, userID);
				updateStmt.setString(3, comicID);
				updateStmt.executeUpdate();
			} else {
				count = 1;
				String sql4 = "INSERT INTO user_collection (user_id, comic_id, series_id, publisher_id, count) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement insertStmt = con.prepareStatement(sql4);
				insertStmt.setInt(1, userID);
				insertStmt.setString(2, comicID);
				insertStmt.setString(3, seriesID);
				insertStmt.setString(4, publisherID);
				insertStmt.setInt(5, count);
				insertStmt.executeUpdate();
			}

			con.commit();
			JOptionPane.showMessageDialog(null,
					"This comic has been added to your library.\nThe current count is: " + count);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
