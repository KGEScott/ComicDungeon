package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
	protected static String userPassCA;
	protected static String retypePassCA;
	private JPanel contentPane;
	private static String q1Answers;
	private static String q2Answers;
	private static String q3Answers;

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
		setBounds(100, 100, 400, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 46, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel FieldPanel = new JPanel();
		FieldPanel.setBackground(new Color(46, 46, 46));
		FieldPanel.setBounds(10, 11, 364, 496);
		contentPane.add(FieldPanel);
		FieldPanel.setLayout(null);

		JTextField firstNameField = new JTextField();
		firstNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		firstNameField.setBorder(emptyBorder);
		firstNameField.setForeground(Color.WHITE);
		firstNameField.setColumns(20);
		firstNameField.setBackground(new Color(73, 73, 73));
		firstNameField.setBounds(103, 14, 251, 22);
		FieldPanel.add(firstNameField);

		JTextArea firstName = new JTextArea();
		firstName.setEditable(false);
		firstName.setFocusable(false);
		firstName.setText("First Name: ");
		firstName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		firstName.setForeground(Color.WHITE);
		firstName.setBackground(new Color(46, 46, 46));
		firstName.setBounds(10, 11, 96, 31);
		FieldPanel.add(firstName);

		JTextArea LastName = new JTextArea();
		LastName.setEditable(false);
		LastName.setFocusable(false);
		LastName.setForeground(Color.WHITE);
		LastName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		LastName.setBackground(new Color(46, 46, 46));
		LastName.setText("Last Name: ");
		LastName.setBounds(10, 44, 89, 22);
		FieldPanel.add(LastName);

		JTextField lastNameField = new JTextField();
		lastNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lastNameField.setBorder(emptyBorder);
		lastNameField.setForeground(Color.WHITE);
		lastNameField.setColumns(30);
		lastNameField.setBackground(new Color(73, 73, 73));
		lastNameField.setBounds(103, 47, 251, 22);
		FieldPanel.add(lastNameField);

		JTextField emailField = new JTextField();
		emailField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		emailField.setBorder(emptyBorder);
		emailField.setForeground(Color.WHITE);
		emailField.setColumns(40);
		emailField.setBackground(new Color(73, 73, 73));
		emailField.setBounds(103, 80, 251, 22);
		FieldPanel.add(emailField);
		emailField.setColumns(10);

		JTextArea emailTxtArea = new JTextArea();
		emailTxtArea.setEditable(false);
		emailTxtArea.setFocusable(false);
		emailTxtArea.setForeground(Color.WHITE);
		emailTxtArea.setBackground(new Color(46, 46, 46));
		emailTxtArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		emailTxtArea.setText("Email:");
		emailTxtArea.setBounds(10, 77, 73, 22);
		FieldPanel.add(emailTxtArea);

		JTextArea DOBTextArea = new JTextArea();
		DOBTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		DOBTextArea.setBackground(new Color(46, 46, 46));
		DOBTextArea.setForeground(Color.WHITE);
		DOBTextArea.setEditable(false);
		DOBTextArea.setFocusable(false);
		DOBTextArea.setText("D.O.B.:");
		DOBTextArea.setBounds(10, 110, 73, 22);
		FieldPanel.add(DOBTextArea);

		JTextArea usernameTextArea = new JTextArea();
		usernameTextArea.setForeground(Color.WHITE);
		usernameTextArea.setEditable(false);
		usernameTextArea.setFocusable(false);
		usernameTextArea.setBackground(new Color(46, 46, 46));
		usernameTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		usernameTextArea.setText("Username: ");
		usernameTextArea.setBounds(10, 143, 81, 22);
		FieldPanel.add(usernameTextArea);

		JTextField userNameField = new JTextField();
		userNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		userNameField.setBorder(emptyBorder);
		userNameField.setForeground(Color.WHITE);
		userNameField.setColumns(40);
		userNameField.setBackground(new Color(73, 73, 73));
		userNameField.setBounds(103, 146, 251, 22);
		FieldPanel.add(userNameField);
		userNameField.setColumns(10);

		JTextArea passTextArea = new JTextArea();
		passTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		passTextArea.setEditable(false);
		passTextArea.setFocusable(false);
		passTextArea.setForeground(Color.WHITE);
		passTextArea.setBackground(new Color(46, 46, 46));
		passTextArea.setText("Password: ");
		passTextArea.setBounds(10, 179, 73, 22);
		FieldPanel.add(passTextArea);

		JPasswordField passField = new JPasswordField();
		passField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		passField.setBorder(emptyBorder);
		passField.setForeground(Color.WHITE);
		passField.setColumns(17);
		passField.setBackground(new Color(73, 73, 73));
		passField.setBounds(103, 179, 251, 20);
		FieldPanel.add(passField);
		passField.setColumns(10);

		JTextArea retypePassTextArea = new JTextArea();
		retypePassTextArea.setEditable(false);
		retypePassTextArea.setFocusable(false);
		retypePassTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		retypePassTextArea.setForeground(Color.WHITE);
		retypePassTextArea.setBackground(new Color(46, 46, 46));
		retypePassTextArea.setText("Retype:");
		retypePassTextArea.setBounds(10, 206, 89, 31);
		FieldPanel.add(retypePassTextArea);

		JPasswordField retypePassField = new JPasswordField();
		retypePassField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		retypePassField.setBorder(emptyBorder);
		retypePassField.setForeground(Color.WHITE);
		retypePassField.setColumns(17);
		retypePassField.setBackground(new Color(73, 73, 73));
		retypePassField.setBounds(103, 210, 251, 20);
		FieldPanel.add(retypePassField);
		retypePassField.setColumns(10);

		JButton confirmButton = new JButton("Submit");
		contentPane.getRootPane().setDefaultButton(confirmButton);
		confirmButton.setBorder(emptyBorder);
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		confirmButton.setFocusable(false);
		confirmButton.setBorder(BorderFactory.createEtchedBorder());
		confirmButton.setBackground(new Color(85, 85, 85));
		confirmButton.setBounds(45, 458, 128, 27);
		FieldPanel.add(confirmButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBorder(emptyBorder);
		cancelButton.setForeground(Color.BLACK);
		cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cancelButton.setFocusable(false);
		cancelButton.setBorder(BorderFactory.createEtchedBorder());
		cancelButton.setBackground(new Color(85, 85, 85));
		cancelButton.setBounds(210, 458, 128, 27);
		FieldPanel.add(cancelButton);

		JComboBox monthCombo = new JComboBox();
		monthCombo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		monthCombo.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
		monthCombo.setBorder(emptyBorder);
		monthCombo.setForeground(Color.WHITE);
		monthCombo.setBackground(new Color(73, 73, 73));
		monthCombo.setBounds(103, 113, 96, 22);
		FieldPanel.add(monthCombo);

		ArrayList<String> day_tmp = new ArrayList<String>();
		for (int day = 1; day <= 31; day++) {
			day_tmp.add(day + "");
		}
		JComboBox dayCombo = new JComboBox(day_tmp.toArray());
		dayCombo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		dayCombo.setBorder(emptyBorder);
		dayCombo.setForeground(Color.WHITE);
		dayCombo.setBackground(new Color(73, 73, 73));
		dayCombo.setBounds(210, 113, 65, 22);
		FieldPanel.add(dayCombo);

		ArrayList<String> years_tmp = new ArrayList<String>();
		for (int years = 2023; years >= 1900; years--) {
			years_tmp.add(years + "");
		}
		JComboBox yearCombo = new JComboBox(years_tmp.toArray());
		yearCombo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		yearCombo.setBorder(emptyBorder);
		yearCombo.setForeground(Color.WHITE);
		yearCombo.setBackground(new Color(73, 73, 73));
		yearCombo.setBounds(285, 113, 69, 22);
		FieldPanel.add(yearCombo);
		
		String[] questions = {"What was your childhood nickname?",
				"What street did you live on in third grade?", "What is the middle name of your youngest child?",
				"What is your oldest sibling's middle name?", "What school did you attend for sixth grade?",
				"What is your oldest cousin's first and last name?", "What was the name of your first stuffed animal?",
				"Where were you when you had your first kiss?", "In what city does your nearest sibling live?",
				"In what city or town was your first job?" };
		
		JComboBox q1Combo = new JComboBox();
		q1Combo.setModel(new DefaultComboBoxModel(questions));
		q1Combo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		q1Combo.setForeground(new Color(255, 255, 255));
		q1Combo.setBackground(new Color(73, 73, 73));
		q1Combo.setBounds(45, 241, 309, 22);
		FieldPanel.add(q1Combo);
		
		JTextField q1Answer = new JTextField();
		q1Answer.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q1Answer.setForeground(new Color(255, 255, 255));
		q1Answer.setBackground(new Color(73, 73, 73));
		q1Answer.setBounds(103, 274, 251, 20);
		q1Answer.setBorder(emptyBorder);
		FieldPanel.add(q1Answer);
		q1Answer.setColumns(10);
		
		JComboBox q2Combo = new JComboBox();
		q2Combo.setModel(new DefaultComboBoxModel(questions));
		q2Combo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		q2Combo.setForeground(new Color(255, 255, 255));
		q2Combo.setBackground(new Color(73, 73, 73));
		q2Combo.setBounds(45, 305, 309, 22);
		FieldPanel.add(q2Combo);
		
		JTextField q2Answer = new JTextField();
		q2Answer.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q2Answer.setForeground(new Color(255, 255, 255));
		q2Answer.setBackground(new Color(73, 73, 73));
		q2Answer.setBounds(103, 338, 251, 20);
		q2Answer.setBorder(emptyBorder);
		FieldPanel.add(q2Answer);
		q2Answer.setColumns(10);
		
		JComboBox q3Combo = new JComboBox();
		q3Combo.setModel(new DefaultComboBoxModel(questions));
		q3Combo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		q3Combo.setForeground(new Color(255, 255, 255));
		q3Combo.setBackground(new Color(73, 73, 73));
		q3Combo.setBounds(45, 369, 309, 22);
		FieldPanel.add(q3Combo);
		
		JTextField q3Answer = new JTextField();
		q3Answer.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q3Answer.setForeground(new Color(255, 255, 255));
		q3Answer.setBackground(new Color(73, 73, 73));
		q3Answer.setBounds(103, 402, 251, 20);
		q3Answer.setBorder(emptyBorder);
		FieldPanel.add(q3Answer);
		q3Answer.setColumns(10);
		
		JTextArea q1TextArea = new JTextArea();
		q1TextArea.setForeground(new Color(255, 255, 255));
		q1TextArea.setBackground(new Color(46, 46, 46));
		q1TextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q1TextArea.setEditable(false);
		q1TextArea.setText("Q1:");
		q1TextArea.setBounds(10, 240, 73, 22);
		FieldPanel.add(q1TextArea);
		
		JTextArea q1AnswerTextArea = new JTextArea();
		q1AnswerTextArea.setForeground(new Color(255, 255, 255));
		q1AnswerTextArea.setBackground(new Color(46, 46, 46));
		q1AnswerTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q1AnswerTextArea.setEditable(false);
		q1AnswerTextArea.setText("Q1 Answer:");
		q1AnswerTextArea.setBounds(10, 272, 89, 22);
		FieldPanel.add(q1AnswerTextArea);
		
		JTextArea q2TextArea = new JTextArea();
		q2TextArea.setForeground(new Color(255, 255, 255));
		q2TextArea.setBackground(new Color(46, 46, 46));
		q2TextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q2TextArea.setEditable(false);
		q2TextArea.setText("Q2:");
		q2TextArea.setBounds(10, 304, 35, 22);
		FieldPanel.add(q2TextArea);
		
		JTextArea q2AnswerTextArea = new JTextArea();
		q2AnswerTextArea.setForeground(new Color(255, 255, 255));
		q2AnswerTextArea.setBackground(new Color(46, 46, 46));
		q2AnswerTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q2AnswerTextArea.setEditable(false);
		q2AnswerTextArea.setText("Q2 Answer:");
		q2AnswerTextArea.setBounds(10, 336, 89, 22);
		FieldPanel.add(q2AnswerTextArea);
		
		JTextArea q3TextArea = new JTextArea();
		q3TextArea.setForeground(new Color(255, 255, 255));
		q3TextArea.setBackground(new Color(46, 46, 46));
		q3TextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q3TextArea.setEditable(false);
		q3TextArea.setText("Q3:");
		q3TextArea.setBounds(10, 368, 35, 22);
		FieldPanel.add(q3TextArea);
		
		JTextArea q3AnswerTextArea = new JTextArea();
		q3AnswerTextArea.setForeground(new Color(255, 255, 255));
		q3AnswerTextArea.setBackground(new Color(46, 46, 46));
		q3AnswerTextArea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		q3AnswerTextArea.setEditable(false);
		q3AnswerTextArea.setText("Q3 Answer:");
		q3AnswerTextArea.setBounds(10, 400, 89, 22);
		FieldPanel.add(q3AnswerTextArea);
		

		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String email = emailField.getText();
				String dobMonth = monthCombo.getSelectedItem().toString();
				String dayC = dayCombo.getSelectedItem().toString();
				String yearC = yearCombo.getSelectedItem().toString();
				String userNameC = userNameField.getText();
				int q1Index = q1Combo.getSelectedIndex();
				int q2Index = q2Combo.getSelectedIndex();
				int q3Index = q3Combo.getSelectedIndex();
				q1Answers = q1Answer.getText();
				q2Answers = q2Answer.getText();
				q3Answers = q3Answer.getText();
				char[] userPass = passField.getPassword();
				char[] retypePass = retypePassField.getPassword();
				userPassCA = new String(userPass);
				retypePassCA = new String(retypePass);

				boolean compare = Arrays.equals(userPass, retypePass);
				if (compare == true) {
					LoginInfo.setFirstName(firstName);
					LoginInfo.setLastName(lastName);
					LoginInfo.setEmail(email);
					LoginInfo.setMonth(dobMonth);
					LoginInfo.setDay(dayC);
					LoginInfo.setYear(yearC);
					LoginInfo.setUsernameCA(userNameC);
					LoginInfo.setPassCA(userPassCA);
					LoginInfo.setQ1Index(q1Index);
					LoginInfo.setQ2Index(q2Index);
					LoginInfo.setQ3Index(q3Index);
					LoginInfo.setQ1Answer(q1Answers);
					LoginInfo.setQ2Answer(q2Answers);
					LoginInfo.setQ3Answer(q3Answers);
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