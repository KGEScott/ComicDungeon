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

public class DBConnection {

	protected static String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
	protected static String user = "root";
	protected static String password = "new_password";

	public static boolean checkUNnPass(String username, char[] userPassword) {

		// URL, username, and password to access the database

		char[] pwd = userPassword;
		String pwdStr = String.copyValueOf(pwd);
		String uNToDB = username;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			Statement pwStmt = con.createStatement();

			// Execute a query to retrieve data from the "user" table
			String sql = "SELECT * FROM user WHERE userName = " + "'" + uNToDB + "'";
			ResultSet rs = stmt.executeQuery(sql);
			String sql2 = "SELECT * FROM user WHERE username = " + "'" + uNToDB + "' && password = " + "'" + pwdStr
					+ "'";
			ResultSet rs2 = pwStmt.executeQuery(sql2);

			// Check if the username is in the result set
			boolean nameAndPassInDB = false;
			boolean isUsernameInDB = rs.next();
			boolean isUserPassInDB = rs2.next();

			if (isUserPassInDB == true && isUsernameInDB == true) {
				nameAndPassInDB = true;
				return nameAndPassInDB;

			} else {
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

	public static boolean createAccountDBC(String username, char[] userPassword) {
		return false;

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
				return isUsernameInDB;

			} else {
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
				return isEmailInDB;

			} else {
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
			String userYear, String userMonth, String userDay, char[] userPassCA) {

		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
		String user = "root";
		String password = "new_password";
		char[] pwd = userPassCA;
		String pwdAsString = new String(pwd);

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO user (userName, firstName, lastName, email, DoB, password) VALUES (?, ?, ?, ?, ?, ?)";

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
			insertStmt.setString(6, pwdAsString);
			insertStmt.executeUpdate();

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
			if (prevPass.equals(userPW.get(0))) {
				String addPass = "UPDATE user SET password=? WHERE userName= " + "'" + username + "'";

				PreparedStatement insertStmt = con.prepareStatement(addPass);
				insertStmt.setString(1, newPass);
				insertStmt.executeUpdate();
				return true;
			} else {
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
			String pubSQL = "SELECT id, name FROM gcd_publisher WHERE name LIKE " + "'%" + getPublisher + "%'";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> publisherData = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> publisher = new HashMap<String, String>();
				publisher.put("id", rs.getString("id"));
				publisher.put("name", rs.getString("name"));
				publisherData.add(publisher);
			}

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
			String pubSQL = "SELECT id, name FROM gcd_series WHERE publisher_id = " + "'" + idEnter + "'";
			ResultSet rs = stmt.executeQuery(pubSQL);

			List<Map<String, String>> seriesData = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> series = new HashMap<String, String>();
				series.put("id", rs.getString("id"));
				series.put("name", rs.getString("name"));
				seriesData.add(series);
			}

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
					+ "'" + idView + "'";
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
//            for (Map<String, String> information : publisherInfo) {
//                System.out.println("Publisher Information:");
//                for (Map.Entry<String, String> entry : information.entrySet()) {
//                    System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
//                }
//            }

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

	public static List<Map<String, String>> pullComics(String idSeries) {

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
					+ idSeries + "'";
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

	public static List<Map<String, String>> pullSeriesInfo(String idSeries) {

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
					+ "binding, publishing_format FROM gcd_series WHERE id = " + "'" + idSeries + "'";
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
//            for (Map<String, String> information : publisherInfo) {
//                System.out.println("Publisher Information:");
//                for (Map.Entry<String, String> entry : information.entrySet()) {
//                    System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
//                }
//            }

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
//            for (Map<String, String> information : publisherInfo) {
//                System.out.println("Publisher Information:");
//                for (Map.Entry<String, String> entry : information.entrySet()) {
//                    System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
//                }
//            }

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

}
