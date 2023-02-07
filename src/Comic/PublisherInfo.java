package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PublisherInfo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5958618214909327689L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublisherInfo frame = new PublisherInfo();
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
	public PublisherInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Comic Dungeon \t Publisher Name: " + LoginInfo.getPublisherName());
		setResizable(false);
		ImageIcon icon = new ImageIcon(Login.class.getResource("/Comic/Icons/dungeon door 2.png"));
		Image image = icon.getImage();
		setIconImage(image);
		setBounds(0, 0, 784, 490);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBorder(new LineBorder(new Color(0, 0, 0), 9, true));
		backgroundPanel.setBackground(new Color(68, 68, 68));
		backgroundPanel.setBounds(0, 0, 768, 453);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);

		List<Map<String, String>> pubInfo = DBConnection.pullPublisherInfo(LoginInfo.getIdView());
		JTextArea pubInfoTxt = new JTextArea();

		String name = null;
		String year_began = null;
		String notes = null;
		String series_count = null;
		String created = null;
		String issue_count = null;
		for (Map<String, String> information : pubInfo) {
			for (Map.Entry<String, String> entry : information.entrySet()) {
				if (entry.getKey().equals("name")) {
					name = entry.getValue();
				} else if (entry.getKey().equals("year_began")) {
					year_began = entry.getValue();
				} else if (entry.getKey().equals("notes")) {
					notes = entry.getValue();
				} else if (entry.getKey().equals("series_count")) {
					series_count = entry.getValue();
				} else if (entry.getKey().equals("created")) {
					created = entry.getValue();
				} else if (entry.getKey().equals("issue_count")) {
					issue_count = entry.getValue();
				}
			}
		}
		pubInfoTxt.setText(
				"Publisher Name:\n\t" + name + " \nYear Began:\n\t" + year_began + "\nSeries Count:\n\t" + series_count
						+ "\nissue_count:\n\t" + issue_count + "\nCreated:\n\t" + created + "\nNotes:\n\t" + notes);
		pubInfoTxt.setCaretPosition(0);
		pubInfoTxt.setLineWrap(true);
		pubInfoTxt.setWrapStyleWord(true);
		pubInfoTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		pubInfoTxt.setFocusable(false);
		pubInfoTxt.setBackground(new Color(128, 128, 128));
		pubInfoTxt.setBounds(60, 24, 643, 402);

		JScrollPane publisherViewSP = new JScrollPane(pubInfoTxt);
		publisherViewSP.setBounds(60, 24, 643, 402);
		backgroundPanel.add(publisherViewSP);
	}
}
