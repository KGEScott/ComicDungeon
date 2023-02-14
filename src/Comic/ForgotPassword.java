package Comic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ForgotPassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5784143379601031281L;
	private JPanel contentPane;
	private Border emptyBorder;
	private static int q1Index;
	private static int q2Index;
	private static int q3Index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ForgotPassword() {
		String[] questions = { "What was your childhood nickname?", "What street did you live on in third grade?",
				"What is the middle name of your youngest child?", "What is your oldest sibling's middle name?",
				"What school did you attend for sixth grade?", "What is your oldest cousin's first and last name?",
				"What was the name of your first stuffed animal?", "Where were you when you had your first kiss?",
				"In what city does your nearest sibling live?", "In what city or town was your first job?" };

		emptyBorder = BorderFactory.createEmptyBorder();
		UIManager.put("Button.select", new Color(21, 56, 70));
		ImageIcon icon = new ImageIcon(Login.class.getResource("/Comic/Icons/dungeon door 2.png"));
		Image image = icon.getImage();
		setIconImage(image);
		setTitle("Comic Dungeon Forgot Password");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 46, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panelAccount = new JPanel();
		panelAccount.setBackground(new Color(46, 46, 46));
		contentPane.add(panelAccount, "AccountPanel");
		panelAccount.setLayout(null);

		JButton submitBtnAccount = new JButton("Submit");
		contentPane.getRootPane().setDefaultButton(submitBtnAccount);
		submitBtnAccount.setBorder(emptyBorder);
		submitBtnAccount.setForeground(Color.BLACK);
		submitBtnAccount.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		submitBtnAccount.setFocusable(false);
		submitBtnAccount.setBorder(BorderFactory.createEtchedBorder());
		submitBtnAccount.setBackground(new Color(85, 85, 85));
		submitBtnAccount.setBounds(117, 361, 128, 27);
		panelAccount.add(submitBtnAccount);

		JButton cancelBtnAccount = new JButton("Cancel");
		cancelBtnAccount.setBorder(emptyBorder);
		cancelBtnAccount.setForeground(Color.BLACK);
		cancelBtnAccount.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cancelBtnAccount.setFocusable(false);
		cancelBtnAccount.setBorder(BorderFactory.createEtchedBorder());
		cancelBtnAccount.setBackground(new Color(85, 85, 85));
		cancelBtnAccount.setBounds(117, 399, 128, 27);
		panelAccount.add(cancelBtnAccount);

		JTextArea Prompt = new JTextArea();
		Prompt.setWrapStyleWord(true);
		Prompt.setFocusable(false);
		Prompt.setBackground(new Color(46, 46, 46));
		Prompt.setEditable(false);
		Prompt.setForeground(new Color(192, 192, 192));
		Prompt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		Prompt.setText("Please type in your username and email.");
		Prompt.setBounds(23, 11, 327, 53);
		panelAccount.add(Prompt);

		JTextArea userNameText = new JTextArea();
		userNameText.setWrapStyleWord(true);
		userNameText.setText("User Name:");
		userNameText.setForeground(Color.LIGHT_GRAY);
		userNameText.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		userNameText.setFocusable(false);
		userNameText.setEditable(false);
		userNameText.setBackground(new Color(46, 46, 46));
		userNameText.setBounds(138, 108, 89, 22);
		panelAccount.add(userNameText);

		JTextArea emailText = new JTextArea();
		emailText.setWrapStyleWord(true);
		emailText.setText("Email:");
		emailText.setForeground(Color.LIGHT_GRAY);
		emailText.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		emailText.setFocusable(false);
		emailText.setEditable(false);
		emailText.setBackground(new Color(46, 46, 46));
		emailText.setBounds(160, 175, 53, 22);
		panelAccount.add(emailText);

		JTextField userNameField = new JTextField();
		userNameField.setForeground(Color.WHITE);
		userNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		userNameField.setBorder(emptyBorder);
		userNameField.setBackground(new Color(73, 73, 73));
		userNameField.setBounds(62, 142, 250, 22);
		panelAccount.add(userNameField);

		JTextField emailField = new JTextField();
		emailField.setForeground(Color.WHITE);
		emailField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		emailField.setBorder(emptyBorder);
		emailField.setBackground(new Color(73, 73, 73));
		emailField.setBounds(62, 212, 250, 22);
		panelAccount.add(emailField);

		JPanel qPanel = new JPanel();
		qPanel.setBackground(new Color(46, 46, 46));
		contentPane.add(qPanel, "Questions");
		qPanel.setLayout(null);

		JTextField q1UserInput = new JTextField();
		q1UserInput.setForeground(new Color(192, 192, 192));
		q1UserInput.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		q1UserInput.setBorder(emptyBorder);
		q1UserInput.setBackground(new Color(73, 73, 73));
		q1UserInput.setBounds(36, 149, 307, 22);
		qPanel.add(q1UserInput);

		JTextField q2UserInput = new JTextField();
		q2UserInput.setForeground(new Color(192, 192, 192));
		q2UserInput.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		q2UserInput.setBorder(emptyBorder);
		q2UserInput.setBackground(new Color(73, 73, 73));
		q2UserInput.setBounds(36, 242, 307, 20);
		qPanel.add(q2UserInput);

		JTextField q3UserInput = new JTextField();
		q3UserInput.setForeground(new Color(192, 192, 192));
		q3UserInput.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		q3UserInput.setBorder(emptyBorder);
		q3UserInput.setBackground(new Color(73, 73, 73));
		q3UserInput.setBounds(36, 333, 307, 20);
		qPanel.add(q3UserInput);

		JTextArea q1Text = new JTextArea();
		q1Text.setWrapStyleWord(true);
		q1Text.setEditable(false);
		q1Text.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		q1Text.setForeground(new Color(255, 255, 255));
		q1Text.setText(null);
		q1Text.setBackground(new Color(46, 46, 46));
		q1Text.setBounds(36, 116, 307, 22);
		qPanel.add(q1Text);

		JTextArea q2Text = new JTextArea();
		q2Text.setWrapStyleWord(true);
		q2Text.setEditable(false);
		q2Text.setText(null);
		q2Text.setForeground(Color.WHITE);
		q2Text.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		q2Text.setBackground(new Color(46, 46, 46));
		q2Text.setBounds(36, 209, 307, 22);
		qPanel.add(q2Text);

		JTextArea q3Text = new JTextArea();
		q3Text.setWrapStyleWord(true);
		q3Text.setEditable(false);
		q3Text.setText(null);
		q3Text.setForeground(Color.WHITE);
		q3Text.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		q3Text.setBackground(new Color(46, 46, 46));
		q3Text.setBounds(36, 300, 307, 22);
		qPanel.add(q3Text);

		JTextArea securityQPrompt = new JTextArea();
		securityQPrompt.setWrapStyleWord(true);
		securityQPrompt.setEditable(false);
		securityQPrompt.setText("Please answer the Security Questions\r\n                 Below.");
		securityQPrompt.setForeground(new Color(192, 192, 192));
		securityQPrompt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		securityQPrompt.setBackground(new Color(46, 46, 46));
		securityQPrompt.setBounds(36, 11, 307, 67);
		qPanel.add(securityQPrompt);

		JButton submitButtonQ = new JButton("Submit");
		submitButtonQ.setBorder(emptyBorder);
		submitButtonQ.setForeground(Color.BLACK);
		submitButtonQ.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		submitButtonQ.setFocusable(false);
		submitButtonQ.setBorder(BorderFactory.createEtchedBorder());
		submitButtonQ.setBackground(new Color(85, 85, 85));
		submitButtonQ.setBounds(117, 361, 128, 27);
		qPanel.add(submitButtonQ);

		JButton cancelButtonQ = new JButton("Cancel");
		cancelButtonQ.setBorder(emptyBorder);
		cancelButtonQ.setForeground(Color.BLACK);
		cancelButtonQ.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cancelButtonQ.setFocusable(false);
		cancelButtonQ.setBorder(BorderFactory.createEtchedBorder());
		cancelButtonQ.setBackground(new Color(85, 85, 85));
		cancelButtonQ.setBounds(117, 399, 128, 27);
		qPanel.add(cancelButtonQ);

		JPanel changePasswordPanel = new JPanel();
		changePasswordPanel.setBackground(new Color(46, 46, 46));
		contentPane.add(changePasswordPanel, "Change Password");
		changePasswordPanel.setLayout(null);

		JTextArea newPassTxt = new JTextArea();
		newPassTxt.setEditable(false);
		newPassTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		newPassTxt.setForeground(new Color(192, 192, 192));
		newPassTxt.setBackground(new Color(46, 46, 46));
		newPassTxt.setText("New Password:");
		newPassTxt.setBounds(128, 115, 110, 22);
		changePasswordPanel.add(newPassTxt);

		JTextArea RetypePassTxt = new JTextArea();
		RetypePassTxt.setEditable(false);
		RetypePassTxt.setText("Retype Password:");
		RetypePassTxt.setForeground(new Color(192, 192, 192));
		RetypePassTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		RetypePassTxt.setBackground(new Color(46, 46, 46));
		RetypePassTxt.setBounds(117, 188, 136, 22);
		changePasswordPanel.add(RetypePassTxt);

		JTextField newPassField = new JTextField();
		newPassField.setForeground(new Color(192, 192, 192));
		newPassField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		newPassField.setBackground(new Color(73, 73, 73));
		newPassField.setBounds(99, 148, 177, 20);
		changePasswordPanel.add(newPassField);
		newPassField.setColumns(10);

		JTextField rePassField = new JTextField();
		rePassField.setForeground(new Color(192, 192, 192));
		rePassField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		rePassField.setColumns(10);
		rePassField.setBackground(new Color(73, 73, 73));
		rePassField.setBounds(99, 221, 177, 20);
		changePasswordPanel.add(rePassField);

		JButton submitPassBtn = new JButton("Submit");
		submitPassBtn.setForeground(Color.BLACK);
		submitPassBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		submitPassBtn.setFocusable(false);
		submitPassBtn.setBorder(emptyBorder);
		submitPassBtn.setBackground(new Color(85, 85, 85));
		submitPassBtn.setBounds(117, 334, 128, 27);
		changePasswordPanel.add(submitPassBtn);

		JButton cancelPassBtn = new JButton("Cancel");
		cancelPassBtn.setForeground(Color.BLACK);
		cancelPassBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cancelPassBtn.setFocusable(false);
		cancelPassBtn.setBorder(emptyBorder);
		cancelPassBtn.setBackground(new Color(85, 85, 85));
		cancelPassBtn.setBounds(117, 372, 128, 27);
		changePasswordPanel.add(cancelPassBtn);

		submitBtnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userNameFP = userNameField.getText();
				String emailFP = emailField.getText();
				LoginInfo.setUsername(userNameFP);
				LoginInfo.setEmail(emailFP);
				if (ButtonActions.BASubmitForgotPass() == true) {
					DBConnection.pullQuestions(LoginInfo.getUserID());
					q1Index = LoginInfo.getQ1Index();
					q2Index = LoginInfo.getQ2Index();
					q3Index = LoginInfo.getQ3Index();
					contentPane.remove(panelAccount);
					contentPane.remove(changePasswordPanel);
					contentPane.add(qPanel);
					q1Text.setText(questions[q1Index]);
					q2Text.setText(questions[q2Index]);
					q3Text.setText(questions[q3Index]);
				} else
					userNameField.setText("");
				emailField.setText("");
			}
		});

		cancelBtnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		submitButtonQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q1Answer = q1UserInput.getText();
				String q2Answer = q2UserInput.getText();
				String q3Answer = q3UserInput.getText();
				LoginInfo.setQ1Answer(q1Answer);
				LoginInfo.setQ2Answer(q2Answer);
				LoginInfo.setQ3Answer(q3Answer);
				if (ButtonActions.BASubmitSecurityQuestions() == true) {
					contentPane.remove(qPanel);
					contentPane.add(changePasswordPanel);
					repaint();
					revalidate();
				} else {
					q1UserInput.setText(null);
					q2UserInput.setText(null);
					q3UserInput.setText(null);
				}
			}
		});

		cancelButtonQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		submitPassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPass = newPassField.getText();
				String newPassS = rePassField.getText();
				if (newPass.equals(newPassS)) {
					LoginInfo.setNewPass(newPass);
					DBConnection.forgotPWChange(LoginInfo.getUserID(), newPassS);
					JOptionPane.showMessageDialog(null, "User password has been set. Please try logging in.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Your passwords do not match.");
					newPassField.setText("");
					rePassField.setText("");
				}
			}
		});
		cancelPassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}