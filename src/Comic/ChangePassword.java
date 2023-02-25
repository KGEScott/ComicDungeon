package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ChangePassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Border emptyBorder;
	public static String oldPass;
	public static String newPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		emptyBorder = BorderFactory.createEmptyBorder();
		ImageIcon icon = new ImageIcon(Login.class.getResource("/Comic/Icons/dungeon door 2.png"));
		Image image = icon.getImage();
		setIconImage(image);
		setTitle("Comic Dungeon Change Password");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 266);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 46, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 46, 46));
		panel.setBounds(10, 11, 313, 213);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextField oldPassTextField = new JTextField();
		oldPassTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		oldPassTextField.setBorder(emptyBorder);
		oldPassTextField.setForeground(Color.WHITE);
		oldPassTextField.setBackground(new Color(73, 73, 73));
		oldPassTextField.setBounds(10, 40, 291, 22);
		panel.add(oldPassTextField);

		JTextField passTextField = new JTextField();
		passTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		passTextField.setBorder(emptyBorder);
		passTextField.setForeground(Color.WHITE);
		passTextField.setBackground(new Color(73, 73, 73));
		passTextField.setBounds(10, 103, 291, 20);
		panel.add(passTextField);

		JButton confirmButton = new JButton("Submit");
		contentPane.getRootPane().setDefaultButton(confirmButton);
		confirmButton.setBorder(emptyBorder);
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		confirmButton.setFocusable(false);
		confirmButton.setBorder(BorderFactory.createEtchedBorder());
		confirmButton.setBackground(new Color(85, 85, 85));
		confirmButton.setBounds(98, 134, 128, 27);
		panel.add(confirmButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBorder(emptyBorder);
		cancelButton.setForeground(Color.BLACK);
		cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cancelButton.setFocusable(false);
		cancelButton.setBorder(BorderFactory.createEtchedBorder());
		cancelButton.setBackground(new Color(85, 85, 85));
		cancelButton.setBounds(98, 172, 128, 27);
		panel.add(cancelButton);

		JTextArea txtrChangePass = new JTextArea();
		txtrChangePass.setFocusable(false);
		txtrChangePass.setBackground(new Color(46, 46, 46));
		txtrChangePass.setEditable(false);
		txtrChangePass.setForeground(new Color(192, 192, 192));
		txtrChangePass.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtrChangePass.setText("Old Password");
		txtrChangePass.setBounds(98, 11, 233, 27);
		panel.add(txtrChangePass);

		JTextArea txtrNewPassText = new JTextArea();
		txtrNewPassText.setText("New Password");
		txtrNewPassText.setForeground(Color.LIGHT_GRAY);
		txtrNewPassText.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtrNewPassText.setFocusable(false);
		txtrNewPassText.setEditable(false);
		txtrNewPassText.setBackground(new Color(46, 46, 46));
		txtrNewPassText.setBounds(98, 74, 233, 27);
		panel.add(txtrNewPassText);

		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldPass = oldPassTextField.getText();
				String newPassS = passTextField.getText();

				// Validate new password
				String error = "";
				String disallowedPasswordCharacters = "+_)(=-09|}{\\][\":';?></.,~`";
				if (newPassS.length() < 8 || newPassS.length() > 15
						|| newPassS.matches(".[" + Pattern.quote(disallowedPasswordCharacters) + "].*")) {
					error += "Password must be between 8 and 15 characters and must not contain any disallowed characters.\n";
				} else if (!newPassS.matches(".*[a-z].*") || !newPassS.matches(".*[A-Z].*")
						|| !newPassS.matches(".*[!@#$%^&*].*")) {
					error += "Password must contain at least 1 lowercase letter, 1 uppercase letter, and 1 symbol from !@#$%^&*.\n";
				}

				if (error.isEmpty()) {
					LoginInfo.setPrevPass(oldPass);
					LoginInfo.setNewPass(newPassS);
					if (ButtonActions.ButtonActionsSubCPW() == true) {
						dispose();
					} else {
						oldPassTextField.setText("");
						passTextField.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
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