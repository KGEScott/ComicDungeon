package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ForgotPassword() {
		emptyBorder = BorderFactory.createEmptyBorder();
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 46, 46));
		panel.setBounds(30, 33, 327, 394);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextField emailTextField = new JTextField();
		emailTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		emailTextField.setBorder(emptyBorder);
		emailTextField.setForeground(Color.WHITE);
		emailTextField.setBackground(new Color(73, 73, 73));
		emailTextField.setBounds(10, 104, 291, 22);
		panel.add(emailTextField);

		JTextField passTextField = new JTextField();
		passTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		passTextField.setBorder(emptyBorder);
		passTextField.setForeground(Color.WHITE);
		passTextField.setBackground(new Color(73, 73, 73));
		passTextField.setBounds(10, 187, 291, 20);
		panel.add(passTextField);

		JTextField textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		textField.setBorder(emptyBorder);
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(73, 73, 73));
		textField.setBounds(10, 261, 291, 20);
		panel.add(textField);

		JButton confirmButton = new JButton("Submit");
		contentPane.getRootPane().setDefaultButton(confirmButton);
		confirmButton.setBorder(emptyBorder);
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		confirmButton.setFocusable(false);
		confirmButton.setBorder(BorderFactory.createEtchedBorder());
		confirmButton.setBackground(new Color(85, 85, 85));
		confirmButton.setBounds(98, 325, 128, 27);
		panel.add(confirmButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBorder(emptyBorder);
		cancelButton.setForeground(Color.BLACK);
		cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cancelButton.setFocusable(false);
		cancelButton.setBorder(BorderFactory.createEtchedBorder());
		cancelButton.setBackground(new Color(85, 85, 85));
		cancelButton.setBounds(98, 363, 128, 27);
		panel.add(cancelButton);

		JComboBox securityQ1 = new JComboBox();
		securityQ1.setModel(new DefaultComboBoxModel(new String[] { "What was your childhood nickname?",
				"What street did you live on in third grade?", "What is the middle name of your youngest child?",
				"What is your oldest sibling's middle name?", "What school did you attend for sixth grade?",
				"What is your oldest cousin's first and last name?", "What was the name of your first stuffed animal?",
				"Where were you when you had your first kiss?", "In what city does your nearest sibling live?",
				"In what city or town was your first job?" }));
		securityQ1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		securityQ1.setForeground(Color.WHITE);
		securityQ1.setBackground(new Color(73, 73, 73));
		securityQ1.setBounds(10, 71, 291, 22);
		panel.add(securityQ1);

		JComboBox securityQ2 = new JComboBox();
		securityQ2.setModel(new DefaultComboBoxModel(new String[] { "What was your childhood nickname?",
				"What street did you live on in third grade?", "What is the middle name of your youngest child?",
				"What is your oldest sibling's middle name?", "What school did you attend for sixth grade?",
				"What is your oldest cousin's first and last name?", "What was the name of your first stuffed animal?",
				"Where were you when you had your first kiss?", "In what city does your nearest sibling live?",
				"In what city or town was your first job?" }));
		securityQ2.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		securityQ2.setForeground(Color.WHITE);
		securityQ2.setBackground(new Color(73, 73, 73));
		securityQ2.setBounds(10, 154, 291, 22);
		panel.add(securityQ2);

		JComboBox securityQ3 = new JComboBox();
		securityQ3.setModel(new DefaultComboBoxModel(new String[] { "What was your childhood nickname?",
				"What street did you live on in third grade?", "What is the middle name of your youngest child?",
				"What is your oldest sibling's middle name?", "What school did you attend for sixth grade?",
				"What is your oldest cousin's first and last name?", "What was the name of your first stuffed animal?",
				"Where were you when you had your first kiss?", "In what city does your nearest sibling live?",
				"In what city or town was your first job?" }));
		securityQ3.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		securityQ3.setForeground(Color.WHITE);
		securityQ3.setBackground(new Color(73, 73, 73));
		securityQ3.setBounds(10, 228, 291, 22);
		panel.add(securityQ3);

		JTextArea txtrPleaseChooseAnd = new JTextArea();
		textField.setBorder(emptyBorder);
		txtrPleaseChooseAnd.setFocusable(false);
		txtrPleaseChooseAnd.setBackground(new Color(46, 46, 46));
		txtrPleaseChooseAnd.setEditable(false);
		txtrPleaseChooseAnd.setForeground(new Color(192, 192, 192));
		txtrPleaseChooseAnd.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtrPleaseChooseAnd.setText("Please choose and answer your security\r\n                  questions.");
		txtrPleaseChooseAnd.setBounds(0, 11, 327, 49);
		panel.add(txtrPleaseChooseAnd);

		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}