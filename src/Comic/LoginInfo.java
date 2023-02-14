package Comic;

public class LoginInfo {
	public static String uName;
	public static String uPass;
	public static String nFirstName;
	private static String nLastName;
	private static String newEmail;
	private static String newMonth;
	public static String dayC;
	private static String yearC;
	private static String newNameCA;
	private static String newPassCA;
	public static String newRPassCA;
	private static String newPrevPass;
	private static String newNowPass;
	private static String getPublisher;
	private static String idView;
	private static String idEnter;
	private static String seriesID;
	private static String currentScrollPanel;
	private static String publisherName;
	private static String publisherID;
	private static String seriesName;
	private static String comicsID;
	private static String comicsIssue;
	private static int q1Index;
	private static int q2Index;
	private static int q3Index;
	private static String q1Answer;
	private static String q2Answer;
	private static String q3Answer;
	private static int userID;

	// Login Screen
	public static void setUsername(String uName) {
		LoginInfo.uName = uName;
	}

	public static String getUsername() {
		return uName;
	}

	public static void setPass(String uPass) {
		LoginInfo.uPass = uPass;
	}

	public static String getPass() {
		return uPass;
	}

	// Create Account Screen
	// first name
	public static void setFirstName(String nFirstName) {
		LoginInfo.nFirstName = nFirstName;
	}

	public static String getFirstName() {
		return nFirstName;
	}

	// last name
	public static void setLastName(String nLastName) {
		LoginInfo.nLastName = nLastName;
	}

	public static String getLastName() {
		return nLastName;
	}

	// email
	public static void setEmail(String newEmail) {
		LoginInfo.newEmail = newEmail;
	}

	public static String getEmail() {
		return newEmail;
	}

	// month combo drop down
	public static void setMonth(String newMonth) {
		LoginInfo.newMonth = newMonth;
	}

	public static String getMonth() {
		return newMonth;
	}

	// day combo drop down
	public static void setDay(String dayC) {
		LoginInfo.dayC = dayC;
	}

	public static String getDay() {
		return dayC;
	}

	// year combo drop down
	public static void setYear(String yearC) {
		LoginInfo.yearC = yearC;
	}

	public static String getYear() {
		return yearC;
	}

	// create account username
	public static void setUsernameCA(String newNameCA) {
		LoginInfo.newNameCA = newNameCA;
	}

	public static String getUsernameCA() {
		return newNameCA;
	}

	// create account password
	public static void setPassCA(String newPassCA) {
		LoginInfo.newPassCA = newPassCA;
	}

	public static String getPassCA() {
		return newPassCA;
	}

	// create account retype password
	public static void setRetypePassCA(String newRPassCA) {
		LoginInfo.newRPassCA = newRPassCA;
	}

	public static String getRetypePassCA() {
		return newRPassCA;
	}

	// create account retype password
	public static void setPrevPass(String oldPass) {
		LoginInfo.newPrevPass = oldPass;
	}

	public static String getPrevPass() {
		return newPrevPass;
	}

	// reset passwords
	public static void setNewPass(String newPass) {
		LoginInfo.newNowPass = newPass;
	}

	public static String getNewPass() {
		return newNowPass;
	}

	public static void setPublisher(String getPublisher) {
		LoginInfo.getPublisher = getPublisher;
	}

	public static String getPublisher() {
		return getPublisher;
	}

	public static void setIdView(String idView) {
		LoginInfo.idView = idView;
	}

	public static String getIdView() {
		return idView;
	}

	public static void setIdEnter(String idEnter) {
		LoginInfo.idEnter = idEnter;
	}

	public static String getIdEnter() {
		return idEnter;
	}

	public static void setSeriesID(String seriesID) {
		LoginInfo.seriesID = seriesID;
	}

	public static String getSeriesID() {
		return seriesID;
	}

	public static String getCurrentScrollPanel() {
		return currentScrollPanel;
	}

	public static void setCurrentScrollPanel(String currentScrollPanel) {
		LoginInfo.currentScrollPanel = currentScrollPanel;
	}

	public static String getPublisherName() {
		return publisherName;
	}

	public static void setPublisherName(String publisherName) {
		LoginInfo.publisherName = publisherName;
	}

	public static String getPublisherID() {
		return publisherID;
	}

	public static void setPublisherID(String publisherID) {
		LoginInfo.publisherID = publisherID;
	}

	public static String getSeriesName() {
		return seriesName;
	}

	public static void setSeriesName(String seriesName) {
		LoginInfo.seriesName = seriesName;
	}

	public static String getComicsID() {
		return comicsID;
	}

	public static void setComicsID(String comicsID) {
		LoginInfo.comicsID = comicsID;
	}

	public static String getComicsIssue() {
		return comicsIssue;
	}

	public static void setComicsIssue(String comicsIssue) {
		LoginInfo.comicsIssue = comicsIssue;
	}

	public static int getQ1Index() {
		return q1Index;
	}

	public static void setQ1Index(int q1Index) {
		LoginInfo.q1Index = q1Index;
	}

	public static int getQ2Index() {
		return q2Index;
	}

	public static void setQ2Index(int q2Index) {
		LoginInfo.q2Index = q2Index;
	}

	public static int getQ3Index() {
		return q3Index;
	}

	public static void setQ3Index(int q3Index) {
		LoginInfo.q3Index = q3Index;
	}

	public static String getQ1Answer() {
		return q1Answer;
	}

	public static void setQ1Answer(String q1Answer) {
		LoginInfo.q1Answer = q1Answer;
	}

	public static String getQ2Answer() {
		return q2Answer;
	}

	public static void setQ2Answer(String q2Answer) {
		LoginInfo.q2Answer = q2Answer;
	}

	public static String getQ3Answer() {
		return q3Answer;
	}

	public static void setQ3Answer(String q3Answer) {
		LoginInfo.q3Answer = q3Answer;
	}
	public static int getUserID() {
		return userID;
	}
	public static void setUserID(int userID) {
		LoginInfo.userID = userID;
	}
}