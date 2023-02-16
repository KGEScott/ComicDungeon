package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Login extends JFrame {
	/**
		 * 
		 */
	private static final long serialVersionUID = -2093583572269751429L;
	public static String userName;
//	private static String userPass;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	/**
	 * 
	 */
	public Login() {

		setTitle("Comic Dungeon");
		setResizable(false);
		ImageIcon icon = new ImageIcon(Login.class.getResource("/Comic/Icons/dungeon door 2.png"));
		Image image = icon.getImage();
		setIconImage(image);
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel frameBanner = new JLabel();
		frameBanner.setVerticalAlignment(SwingConstants.TOP);
		frameBanner.setBounds(132, 11, 968, 300);
		frameBanner.setHorizontalAlignment(SwingConstants.CENTER);
		frameBanner.setIcon(new ImageIcon(Login.class.getResource("/Comic/Icons/comicDungeonbit3.png")));

		JPanel bannerPannel = new JPanel();
		bannerPannel.setBounds(995, 160, 0, 0);
		contentPane.setLayout(null);
		contentPane.add(frameBanner);
		contentPane.add(bannerPannel);
		bannerPannel.setLayout(null);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBounds(0, 0, 1185, 961);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);

		JPanel loginUI = new JPanel();
		loginUI.setLayout(null);
		loginUI.setBorder(new LineBorder(new Color(35, 35, 35), 15));
		loginUI.setBackground(new Color(3, 66, 80));
		loginUI.setBounds(486, 497, 188, 257);
		backgroundPanel.add(loginUI);

		JTextArea txtrUsername = new JTextArea();
		Properties.setLoginTextProperties(txtrUsername, "UserName: ");
		txtrUsername.setBounds(46, 24, 108, 30);
		loginUI.add(txtrUsername);

		JTextArea txtrPassword = new JTextArea();
		Properties.setLoginTextProperties(txtrPassword, "Password: ");
		txtrPassword.setBounds(46, 79, 108, 30);
		loginUI.add(txtrPassword);

		JPasswordField passwordField = new JPasswordField();
		((AbstractDocument) passwordField.getDocument()).setDocumentFilter(new PasswordDocumentFilter());
		Properties.setLoginTextFieldProperties(passwordField);
		passwordField.setBounds(34, 110, 128, 20);

		loginUI.add(passwordField);

		JButton submit = new JButton("Submit");
		contentPane.getRootPane().setDefaultButton(submit);
		Properties.setLoginButtonProperties(submit, 34, 143, 128, 27);
		loginUI.add(submit);

		JButton createAccount = new JButton("Create Account");
		Properties.setLoginButtonProperties(createAccount, 34, 175, 128, 27);
		loginUI.add(createAccount);

		JButton forgotPass = new JButton("Forgot?");
		Properties.setLoginButtonProperties(forgotPass, 34, 206, 128, 27);
		loginUI.add(forgotPass);

		JTextField userNameField = new JTextField();
		userNameField.setBounds(34, 55, 128, 20);
		loginUI.add(userNameField);

		// Set the maximum character limit
		userNameField.setDocument(new JTextFieldLimit(20));

		// Add a document filter to escape symbols
		((AbstractDocument) userNameField.getDocument()).setDocumentFilter(new EscapeSymbolDocumentFilter());

		// Set other properties
		Properties.setLoginTextFieldProperties(userNameField);

		JLabel backgroundImage = new JLabel();
		backgroundImage.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundImage.setVerticalAlignment(SwingConstants.TOP);
		backgroundImage.setBounds(0, 0, 1200, 1000);
		backgroundImage.setIcon(new ImageIcon(Login.class.getResource("/Comic/Icons/dungeonbg1.jpg")));
		backgroundPanel.add(backgroundImage);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Validate the user name input
				String userName = userNameField.getText();
				if (userName == null || !userName.matches("^[a-zA-Z0-9]{4,20}$")) {
					JOptionPane.showMessageDialog(loginUI,
							"User name must be 4-20 characters and contain only letters and numbers.");
					return;
				}

				// Validate the password input
				String userPass = new String();
				try {
					Document passwordDoc = passwordField.getDocument();
					((AbstractDocument) passwordDoc).setDocumentFilter(new PasswordDocumentFilter()); // Use the new
																										// PasswordDocumentFilter
																										// class
					userPass = passwordDoc.getText(0, passwordDoc.getLength());
					((AbstractDocument) passwordDoc).setDocumentFilter(new EscapeSymbolDocumentFilter()); // Reset the
																											// document
																											// filter
				} catch (BadLocationException ex) {
					ex.printStackTrace();
				}

				if (userPass == null || userPass.length() == 0) {
					JOptionPane.showMessageDialog(loginUI, "Password is required.");
					return;
				}

				// Store the user name and password inputs in the LoginInfo class
				LoginInfo.setUsername(userName);
				LoginInfo.setPass(userPass);

				// Call the ButtonActionsSubmit method to perform the login actions
				if (ButtonActions.ButtonActionsSubmit() == true) {
					dispose();
				} else {
					passwordField.setText("");
				}
			}
		});

		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonActions.ButtonActionsCreate();

			}
		});
		forgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonActions.ButtonActionsForgot();

			}
		});

	}

	public class EscapeSymbolDocumentFilter extends DocumentFilter {
		@Override
		public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr)
				throws BadLocationException {
			if (str == null) {
				return;
			}
			String filtered = filterString(str);
			super.insertString(fb, offset, filtered, attr);
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
				throws BadLocationException {
			if (str == null) {
				return;
			}
			String filtered = filterString(str);
			super.replace(fb, offset, length, filtered, attrs);
		}

		private String filterString(String str) {
			// Remove all characters that are not letters or numbers
			return str.replaceAll("[^a-zA-Z0-9]", "");
		}
	}

	public class PasswordDocumentFilter extends DocumentFilter {
		private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*~`";
		private static final String DISALLOWED_CHARACTERS = "+_)(=-09|}{\\][\":';?></.,";

		@Override
		public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr)
				throws BadLocationException {
			if (str == null) {
				return;
			}
			String filtered = filterString(str);
			super.insertString(fb, offset, filtered, attr);
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
				throws BadLocationException {
			if (str == null) {
				return;
			}
			String filtered = filterString(str);
			super.replace(fb, offset, length, filtered, attrs);
		}

		private String filterString(String str) {
			StringBuilder filtered = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (ALLOWED_CHARACTERS.indexOf(c) != -1 && DISALLOWED_CHARACTERS.indexOf(c) == -1) {
					filtered.append(c);
				}
			}
			return filtered.toString().substring(0, Math.min(filtered.length(), 15));
		}
	}

	public class JTextFieldLimit extends PlainDocument {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8334549265947591445L;
		private int limit;

		public JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		@Override
		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null) {
				return;
			}

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
	}
}