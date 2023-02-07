package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CreateAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8476362587776251719L;
	protected static String firstName;
	protected static String lastName;
	protected static String userEmail;
	protected static String month;
	protected static String day;
	protected static String year;
	protected static String userNameCA;
	protected static char[] userPassCA;
	protected static char[] retypePassCA;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CreateAccount() {
		Border emptyBorder = BorderFactory.createEmptyBorder();
		UIManager.put("Button.select", new Color(21, 56, 70));
		ImageIcon icon = new ImageIcon(Login.class.getResource("/Comic/Icons/dungeon door 2.png"));
		Image image = icon.getImage();
		setIconImage(image);
		setTitle("Comic Dungeon Create Account");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 46, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel basePanel = new JPanel();
		basePanel.setBackground(new Color(46, 46, 46));
		basePanel.setBounds(30, 33, 327, 394);
		contentPane.add(basePanel);
		basePanel.setLayout(null);

		JTextField firstNameField = new JTextField();
		firstNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		firstNameField.setBorder(emptyBorder);
		firstNameField.setForeground(Color.WHITE);
		firstNameField.setColumns(20);
		firstNameField.setBackground(new Color(73, 73, 73));
		firstNameField.setBounds(103, 14, 198, 22);
		basePanel.add(firstNameField);

		JTextArea firstName = new JTextArea();
		firstName.setEditable(false);
		firstName.setFocusable(false);
		firstName.setText("First Name: ");
		firstName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		firstName.setForeground(Color.WHITE);
		firstName.setBackground(new Color(46, 46, 46));
		firstName.setBounds(10, 11, 96, 31);
		basePanel.add(firstName);

		JTextArea LastName = new JTextArea();
		LastName.setEditable(false);
		LastName.setFocusable(false);
		LastName.setForeground(Color.WHITE);
		LastName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		LastName.setBackground(new Color(46, 46, 46));
		LastName.setText("Last Name: ");
		LastName.setBounds(10, 53, 89, 22);
		basePanel.add(LastName);

		JTextField lastNameField = new JTextField();
		lastNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lastNameField.setBorder(emptyBorder);
		lastNameField.setForeground(Color.WHITE);
		lastNameField.setColumns(30);
		lastNameField.setBackground(new Color(73, 73, 73));
		lastNameField.setBounds(103, 53, 198, 22);
		basePanel.add(lastNameField);

		JTextField emailField = new JTextField();
		emailField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		emailField.setBorder(emptyBorder);
		emailField.setForeground(Color.WHITE);
		emailField.setColumns(40);
		emailField.setBackground(new Color(73, 73, 73));
		emailField.setBounds(103, 91, 198, 22);
		basePanel.add(emailField);
		emailField.setColumns(10);

		JTextArea emailTxtArea = new JTextArea();
		emailTxtArea.setEditable(false);
		emailTxtArea.setFocusable(false);
		emailTxtArea.setForeground(Color.WHITE);
		emailTxtArea.setBackground(new Color(46, 46, 46));
		emailTxtArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		emailTxtArea.setText("Email:");
		emailTxtArea.setBounds(10, 86, 73, 22);
		basePanel.add(emailTxtArea);

		JTextArea DOBTextArea = new JTextArea();
		DOBTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		DOBTextArea.setBackground(new Color(46, 46, 46));
		DOBTextArea.setForeground(Color.WHITE);
		DOBTextArea.setEditable(false);
		DOBTextArea.setFocusable(false);
		DOBTextArea.setText("D.O.B.:");
		DOBTextArea.setBounds(10, 122, 73, 22);
		basePanel.add(DOBTextArea);

		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setForeground(Color.WHITE);
		txtrUsername.setEditable(false);
		txtrUsername.setFocusable(false);
		txtrUsername.setBackground(new Color(46, 46, 46));
		txtrUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtrUsername.setText("Username: ");
		txtrUsername.setBounds(10, 162, 81, 22);
		basePanel.add(txtrUsername);

		JTextField userNameField = new JTextField();
		userNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		userNameField.setBorder(emptyBorder);
		userNameField.setForeground(Color.WHITE);
		userNameField.setColumns(40);
		userNameField.setBackground(new Color(73, 73, 73));
		userNameField.setBounds(103, 166, 198, 22);
		basePanel.add(userNameField);
		userNameField.setColumns(10);

		JTextArea txtrPass = new JTextArea();
		txtrPass.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtrPass.setEditable(false);
		txtrPass.setFocusable(false);
		txtrPass.setForeground(Color.WHITE);
		txtrPass.setBackground(new Color(46, 46, 46));
		txtrPass.setText("Password: ");
		txtrPass.setBounds(10, 209, 73, 22);
		basePanel.add(txtrPass);

		JPasswordField passField = new JPasswordField();
		passField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		passField.setBorder(emptyBorder);
		passField.setForeground(Color.WHITE);
		passField.setColumns(17);
		passField.setBackground(new Color(73, 73, 73));
		passField.setBounds(103, 209, 198, 20);
		basePanel.add(passField);
		passField.setColumns(10);

		JTextArea txtrRetypePass = new JTextArea();
		txtrRetypePass.setEditable(false);
		txtrRetypePass.setFocusable(false);
		txtrRetypePass.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtrRetypePass.setForeground(Color.WHITE);
		txtrRetypePass.setBackground(new Color(46, 46, 46));
		txtrRetypePass.setText("Retype\r\nPassword:");
		txtrRetypePass.setBounds(10, 242, 81, 48);
		basePanel.add(txtrRetypePass);

		JPasswordField retypePassField = new JPasswordField();
		retypePassField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		retypePassField.setBorder(emptyBorder);
		retypePassField.setForeground(Color.WHITE);
		retypePassField.setColumns(17);
		retypePassField.setBackground(new Color(73, 73, 73));
		retypePassField.setBounds(103, 258, 198, 20);
		basePanel.add(retypePassField);
		retypePassField.setColumns(10);

		JButton confirmButton = new JButton("Submit");
		contentPane.getRootPane().setDefaultButton(confirmButton);
		confirmButton.setBorder(emptyBorder);
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		confirmButton.setFocusable(false);
		confirmButton.setBorder(BorderFactory.createEtchedBorder());
		confirmButton.setBackground(new Color(85, 85, 85));
		confirmButton.setBounds(112, 326, 128, 27);
		basePanel.add(confirmButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBorder(emptyBorder);
		cancelButton.setForeground(Color.BLACK);
		cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cancelButton.setFocusable(false);
		cancelButton.setBorder(BorderFactory.createEtchedBorder());
		cancelButton.setBackground(new Color(85, 85, 85));
		cancelButton.setBounds(112, 360, 128, 27);
		basePanel.add(cancelButton);

		JComboBox monthCombo = new JComboBox();
		monthCombo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		monthCombo.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
		monthCombo.setBorder(emptyBorder);
		monthCombo.setForeground(Color.WHITE);
		monthCombo.setBackground(new Color(73, 73, 73));
		monthCombo.setBounds(103, 126, 63, 22);
		basePanel.add(monthCombo);

		ArrayList<String> day_tmp = new ArrayList<String>();
		for (int day = 1; day <= 31; day++) {
			day_tmp.add(day + "");
		}
		JComboBox dayCombo = new JComboBox(day_tmp.toArray());
		dayCombo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		dayCombo.setBorder(emptyBorder);
		dayCombo.setForeground(Color.WHITE);
		dayCombo.setBackground(new Color(73, 73, 73));
		dayCombo.setBounds(176, 126, 46, 22);
		basePanel.add(dayCombo);

		ArrayList<String> years_tmp = new ArrayList<String>();
		for (int years = 2023; years >= 1900; years--) {
			years_tmp.add(years + "");
		}
		JComboBox yearCombo = new JComboBox(years_tmp.toArray());
		yearCombo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		yearCombo.setBorder(emptyBorder);
		yearCombo.setForeground(Color.WHITE);
		yearCombo.setBackground(new Color(73, 73, 73));
		yearCombo.setBounds(232, 126, 69, 22);
		basePanel.add(yearCombo);

		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String email = emailField.getText();
				String dobMonth = monthCombo.getSelectedItem().toString();
				String dayC = dayCombo.getSelectedItem().toString();
				String yearC = yearCombo.getSelectedItem().toString();
				String userNameC = userNameField.getText();
				char[] userPass = passField.getPassword();
				char[] retypePass = retypePassField.getPassword();

				boolean compare = Arrays.equals(userPass, retypePass);
				if (compare == true) {
					LoginInfo.setFirstName(firstName);
					LoginInfo.setLastName(lastName);
					LoginInfo.setEmail(email);
					LoginInfo.setMonth(dobMonth);
					LoginInfo.setDay(dayC);
					LoginInfo.setYear(yearC);
					LoginInfo.setUsernameCA(userNameC);
					LoginInfo.setPassCA(userPass);
					LoginInfo.setRetypePassCA(retypePass);
					ButtonActions.ButtonActionsCreateSub();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Your Passwords are not the same, please try again.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

	}
}