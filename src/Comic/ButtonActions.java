package Comic;

import javax.swing.JOptionPane;

public class ButtonActions extends Login {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static CreateAccount createA = new CreateAccount();
	static ChangePassword changeP = new ChangePassword();

	public static boolean ButtonActionsSubmit() {
		String username = LoginInfo.getUsername();
		String userPass = LoginInfo.getPass();

		boolean nameAndPassInDB = DBConnection.checkUNnPass(username, userPass);

		if (nameAndPassInDB) {
			UserInterface.main(null);
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"The username or Password may be incorrect, please try again or create a new account.");
			return false;
		}
	}

	public static void ButtonActionsCreate() {
		CreateAccount.main(null);
	}

	public static void ButtonActionsForgot() {
		ForgotPassword.main(null);
	}

	public static void ButtonActionsCreateSub() {

		boolean isInDB = DBConnection.caIsInDB(LoginInfo.getUsernameCA());
		boolean emailInDB = DBConnection.emailInDB(LoginInfo.getEmail());
		if (isInDB == true && emailInDB == true) {
			JOptionPane.showMessageDialog(null, "Username and email is already in the database.");
			createA.dispose();
		} else if (isInDB == false && emailInDB == true) {
			JOptionPane.showMessageDialog(null, "Email is already in the database.");
		} else if (isInDB == true && emailInDB == false) {
			JOptionPane.showMessageDialog(null, "Username is already in the database.");
		} else {
			DBConnection.insertCA(LoginInfo.getUsernameCA(), LoginInfo.getFirstName(), LoginInfo.getLastName(),
					LoginInfo.getEmail(), LoginInfo.getYear(), LoginInfo.getMonth(), LoginInfo.getDay(),
					LoginInfo.getPassCA(), LoginInfo.getQ1Index(), LoginInfo.getQ1Answer(), LoginInfo.getQ2Index(),
					LoginInfo.getQ2Answer(), LoginInfo.getQ3Index(), LoginInfo.getQ3Answer());
			JOptionPane.showMessageDialog(null, "User information has been saved to the database.");
		}
	}

	public static boolean ButtonActionsSubCPW() {
		boolean isOldPassInDB = DBConnection.changePW(LoginInfo.getUsername(), LoginInfo.getPrevPass(),
				LoginInfo.getNewPass());
		if (isOldPassInDB == true) {
			JOptionPane.showMessageDialog(null, "User password has been updated.");
			changeP.dispose();
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "User password was not in database.");
			return false;
		}
	}

	public static void ButtonActionsSearchPublishers(String getPublisherNameToSearch) {
		DBConnection.pullPublisher(getPublisherNameToSearch);
	}
	public static boolean BASubmitForgotPass() {
		String username = LoginInfo.getUsername();
		String email = LoginInfo.getEmail();

		boolean nameAndEmailInDB = DBConnection.checkUserNameAndEmail(username, email);

		if (nameAndEmailInDB) {
			DBConnection.pullQuestions(LoginInfo.getUserID());
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Username or email is not in the database.");
			return false;
		}
	}
	public static boolean BASubmitSecurityQuestions() {
		int id = LoginInfo.getUserID();
		String q1 = LoginInfo.getQ1Answer();
		String q2 = LoginInfo.getQ2Answer();
		String q3 = LoginInfo.getQ3Answer();

		boolean answersCorrect = DBConnection.checkSecurityQuestions(id, q1, q2, q3);

		if (answersCorrect) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"One or more of your security questions may be wrong.");
			return false;
		}
	}
}