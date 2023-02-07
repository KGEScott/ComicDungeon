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

		boolean nameAndPassInDB = DBConnection.checkUNnPass(LoginInfo.getUsername(), LoginInfo.getPass());
		if (nameAndPassInDB) {
			UserInterface.main(null);
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"The username or Password may be wrong, please try again or create a new account.");
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
					LoginInfo.getPassCA());
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
}