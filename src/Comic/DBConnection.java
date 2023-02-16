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

	private static final String url = "jdbc:mysql://localhost:3306/Comic_Dungeon";
	private static final String user = "root";
	private static final String password = "new_password";

	public static boolean checkUNnPass(String username, String userPassword) {
		String pwd = userPassword;
		boolean nameAndPassInDB = false;

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con
						.prepareStatement("SELECT userName, password, id FROM user WHERE userName = ?")) {
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			// Check if the username is in the result set
			boolean isUsernameInDB = rs.next();

			if (isUsernameInDB) {
				// Get the hashed password from the database
				String storedPassword = rs.getString("password");

				// Compare the hashed password with the password from the user
				if (BCrypt.checkpw(pwd, storedPassword)) {
					nameAndPassInDB = true;

					// Save the user ID to LoginInfo
					LoginInfo.setUserID(rs.getInt("id"));
				} else {
					nameAndPassInDB = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nameAndPassInDB;
	}

	public static boolean caIsInDB(String username) {
		boolean isUsernameInDB = false;

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM user WHERE userName = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			isUsernameInDB = rs.next();
			con.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}

		return isUsernameInDB;
	}

	public static boolean emailInDB(String email) {

		try (Connection con = DriverManager.getConnection(url, user, password)) {

			String sql = "SELECT * FROM user WHERE email = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public static void insertCA(String userNameCA, String userFirstName, String userLastName, String userEmail,
			String userYear, String userMonth, String userDay, String userPassCA, int q1Index, String q1Answer,
			int q2Index, String q2Answer, int q3Index, String q3Answer) {

		String url = "jdbc:mysql://localhost:3306/Comic_Dungeon", user = "root", password = "new_password", id = null;

		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String month = LoginInfo.getMonth();
			int monthNum = month.equals("Jan") ? 1
					: month.equals("Feb") ? 2
							: month.equals("Mar") ? 3
									: month.equals("Apr") ? 4
											: month.equals("May") ? 5
													: month.equals("Jun") ? 6
															: month.equals("Jul") ? 7
																	: month.equals("Aug") ? 8
																			: month.equals("Sep") ? 9
																					: month.equals("Oct") ? 10
																							: month.equals("Nov") ? 11
																									: month.equals(
																											"Dec") ? 12
																													: 0;
			String date = userYear + "-" + (monthNum < 10 ? "0" : "") + monthNum + "-"
					+ (Integer.parseInt(userDay) < 10 ? "0" : "") + userDay;
			String sql = "INSERT INTO user (userName, firstName, lastName, email, DoB, securityQ1, securityQ2, securityQ3, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "SELECT id FROM user WHERE userName = '" + userNameCA + "'";
			String sql3 = "INSERT INTO security_questions (q1, q2, q3, user_id) VALUES (?, ?, ?, ?)";
			PreparedStatement insertStmt = con.prepareStatement(sql);
			insertStmt.setString(1, userNameCA);
			insertStmt.setString(2, userFirstName);
			insertStmt.setString(3, userLastName);
			insertStmt.setString(4, userEmail);
			insertStmt.setString(5, date);
			insertStmt.setString(6, q1Answer);
			insertStmt.setString(7, q2Answer);
			insertStmt.setString(8, q3Answer);
			insertStmt.setString(9, BCrypt.hashpw(userPassCA, BCrypt.gensalt()));
			insertStmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(sql2);
			if (rs.next())
				id = rs.getString("id");
			PreparedStatement qIndexInsertStmt = con.prepareStatement(sql3);
			qIndexInsertStmt.setString(1, String.valueOf(q1Index));
			qIndexInsertStmt.setString(2, String.valueOf(q2Index));
			qIndexInsertStmt.setString(3, String.valueOf(q3Index));
			qIndexInsertStmt.setString(4, id);
			qIndexInsertStmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<String> pullUserInfo(String username) {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT userName, firstName, lastName, email, DoB, password FROM user WHERE userName = ?");
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			List<String> userInfo = new ArrayList<>();
			if (rs.next()) {
				for (int i = 1; i <= 5; i++) {
					userInfo.add(rs.getString(i));
				}
			}

			return userInfo;

		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}

	public static boolean changePW(String username, String prevPass, String newPass) {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String cPWQ = "SELECT password FROM user WHERE userName = ?";
			PreparedStatement pstmt = con.prepareStatement(cPWQ);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next() && BCrypt.checkpw(prevPass, rs.getString(1))) {
				String addPass = "UPDATE user SET password=? WHERE userName=?";
				PreparedStatement insertStmt = con.prepareStatement(addPass);
				insertStmt.setString(1, BCrypt.hashpw(newPass, BCrypt.gensalt()));
				insertStmt.setString(2, username);
				insertStmt.executeUpdate();
				return true;
			}
			return false;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return false;
		}
	}

	public static List<Map<String, String>> pullPublisher(String getPublisher) {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String pubSQL = "SELECT id, name FROM gcd_publisher WHERE name LIKE ? ORDER BY name";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setString(1, "%" + getPublisher + "%");
			ResultSet rs = pstmt.executeQuery();

			List<Map<String, String>> publisherData = new ArrayList<>();

			while (rs.next()) {
				Map<String, String> publisher = new HashMap<>();
				publisher.put("id", rs.getString("id"));
				publisher.put("name", rs.getString("name"));
				publisherData.add(publisher);
			}
			return publisherData;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullSeries(String idEnter) {
		try {
			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			String pubSQL = "SELECT id, name FROM gcd_series WHERE publisher_id = ? ORDER BY name, year_began";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setString(1, idEnter);
			ResultSet rs = pstmt.executeQuery();

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

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String pubSQL = "SELECT id, name, publisher_id FROM gcd_series WHERE name LIKE ? ORDER BY name, year_began";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setString(1, "%" + seriesName + "%");
			ResultSet rs = pstmt.executeQuery();

			List<Map<String, String>> seriesData = new ArrayList<Map<String, String>>();

			// Check if the username is in the result set
			while (rs.next()) {
				Map<String, String> series = new HashMap<String, String>();
				series.put("id", rs.getString("id"));
				series.put("name", rs.getString("name"));
				series.put("publisher_id", rs.getString("publisher_id"));
				seriesData.add(series);
			}
			return seriesData;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullPublisherInfo(String idView) {

		try {
			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			String pubSQL = "SELECT id, name, year_began, notes, series_count, created, issue_count FROM gcd_publisher WHERE id = ? ORDER BY name";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setString(1, idView);
			ResultSet rs = pstmt.executeQuery();

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
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String pubSQL = "SELECT volume, number, publication_date, id FROM gcd_issue WHERE series_id = ? ORDER BY number, publication_date";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setString(1, seriesID);
			ResultSet rs = pstmt.executeQuery();

			List<Map<String, String>> comicData = new ArrayList<>();

			while (rs.next()) {
				Map<String, String> series = new HashMap<>();
				series.put("volume", rs.getString("volume"));
				series.put("number", rs.getString("number"));
				series.put("publication_date", rs.getString("publication_date"));
				series.put("id", rs.getString("id"));
				comicData.add(series);
			}
			return comicData;

		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullSeriesInfo(String seriesID) {

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String pubSQL = "SELECT id, name, year_began, year_ended, notes, color, dimensions, paper_stock,"
					+ "binding, publishing_format FROM gcd_series WHERE id = ? ORDER BY name";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setString(1, seriesID);
			ResultSet rs = pstmt.executeQuery();

			List<Map<String, String>> seriesInfo = new ArrayList<Map<String, String>>();

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
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, String>> pullComicsInfo(String comicsID) {

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String pubSQL = "SELECT id, number, publication_date, price, page_count, editing, notes, on_sale_date  FROM gcd_issue WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setString(1, comicsID);
			ResultSet rs = pstmt.executeQuery();

			List<Map<String, String>> comicsInfo = new ArrayList<Map<String, String>>();

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
			return comicsInfo;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		}
	}

	public static boolean checkUserNameAndEmail(String username, String newEmail) {
		boolean nameAndEmailInDB = false;
		try {
			// Open a connection to the database and set the character encoding to UTF-8mb4
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement stmt = con
					.prepareStatement("SELECT id, username, email FROM user WHERE username = ? AND email = ?");
			stmt.setString(1, username);
			stmt.setString(2, newEmail);

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

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			// Execute a query to retrieve data from the "security_questions" table
			PreparedStatement stmt = con
					.prepareStatement("SELECT q1, q2, q3 FROM security_questions WHERE user_id = ?");
			stmt.setInt(1, userID);
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
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
	}

	public static boolean checkSecurityQuestions(int id, String q1Answers, String q2Answers, String q3Answers) {

		boolean securityAnswersSame = false;

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			PreparedStatement stmt = con
					.prepareStatement("SELECT securityQ1, securityQ2, securityQ3 FROM user WHERE id = ?");
			stmt.setInt(1, id);

			// Execute a query to retrieve data from the "user" table
			try (ResultSet rs = stmt.executeQuery()) {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return securityAnswersSame;
	}

	public static void forgotPWChange(int id, String newPass) {

		String hashedPassword = BCrypt.hashpw(newPass, BCrypt.gensalt());

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement stmt = con.prepareStatement("UPDATE user SET password = ? WHERE id = ?")) {

			// Execute a query to change the password within the database.
			stmt.setString(1, hashedPassword);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
	}

	public static void addComic(String userName, String comicID, String seriesID, String publisherID, String cover) {
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
				String sql4 = "INSERT INTO user_collection (user_id, comic_id, series_id, publisher_id, count, cover) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement insertStmt = con.prepareStatement(sql4);
				insertStmt.setInt(1, userID);
				insertStmt.setString(2, comicID);
				insertStmt.setString(3, seriesID);
				insertStmt.setString(4, publisherID);
				insertStmt.setInt(5, count);
				insertStmt.setString(6, cover);
				insertStmt.executeUpdate();
			}

			con.commit();
			JOptionPane.showMessageDialog(null,
					"This comic has been added to your library.\nThe current count is: " + count);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static List<Map<String, String>> pullCollection(int userID) {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String pubSQL = "SELECT uc.comic_id, uc.series_id, uc.publisher_id, uc.count, uc.cover, gs.name AS series_name, gp.name AS publisher_name, gi.number "
					+ "FROM user_collection uc " + "JOIN gcd_series gs ON uc.series_id = gs.id "
					+ "JOIN gcd_publisher gp ON uc.publisher_id = gp.id " + "JOIN gcd_issue gi ON uc.comic_id = gi.id "
					+ "WHERE uc.user_id = ? " + "ORDER BY uc.publisher_id";
			PreparedStatement pstmt = con.prepareStatement(pubSQL);
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();

			List<Map<String, String>> myCollection = new ArrayList<Map<String, String>>();

			while (rs.next()) {
				Map<String, String> myCollectionMap = new HashMap<String, String>();
				myCollectionMap.put("comic_id", rs.getString("comic_id"));
				myCollectionMap.put("series_id", rs.getString("series_id"));
				myCollectionMap.put("series_name", rs.getString("series_name"));
				myCollectionMap.put("publisher_id", rs.getString("publisher_id"));
				myCollectionMap.put("publisher_name", rs.getString("publisher_name"));
				myCollectionMap.put("count", rs.getString("count"));
				myCollectionMap.put("cover", rs.getString("cover"));
				myCollectionMap.put("number", rs.getString("number"));
				myCollection.add(myCollectionMap);
			}
			return myCollection;

		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}

}
