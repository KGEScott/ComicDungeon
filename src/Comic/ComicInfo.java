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

public class ComicInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3650978427635966970L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComicInfo frame = new ComicInfo();
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
	public ComicInfo() {
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

		List<Map<String, String>> comicInfo = DBConnection.pullComicsInfo(LoginInfo.getComicsID());
		JTextArea comicInfoTxt = new JTextArea();

		String id = null;
		String number = null;
		String publication_date = null;
		String price = null;
		String page_count = null;
		String editing = null;
		String notes = null;
		String on_sale_date = null;
		for (Map<String, String> information : comicInfo) {
			for (Map.Entry<String, String> entry : information.entrySet()) {
				if (entry.getKey().equals("id")) {
					id = entry.getValue();
				} else if (entry.getKey().equals("number")) {
					number = entry.getValue();
				} else if (entry.getKey().equals("publication_date")) {
					publication_date = entry.getValue();
				} else if (entry.getKey().equals("price")) {
					price = entry.getValue();
				} else if (entry.getKey().equals("page_count")) {
					page_count = entry.getValue();
				} else if (entry.getKey().equals("editing")) {
					editing = entry.getValue();
				} else if (entry.getKey().equals("notes")) {
					notes = entry.getValue();
				} else if (entry.getKey().equals("on_sale_date")) {
					on_sale_date = entry.getValue();
				}
			}
		}
		comicInfoTxt.setText("Publisher Name:\n\t" + LoginInfo.getPublisherName() + "\nSeries Name:\n\t"
				+ LoginInfo.getSeriesName() + "\nIssue Number:\n\t" + number + "\nPublication Date:\n\t"
				+ publication_date + "\nPage Count:\n\t" + page_count + "\nEditing:\n\t" + editing + "\nPrice:\n\t"
				+ price + "\nOn Sale Date:\n\t" + on_sale_date + "\nNotes:\n\t" + notes);
		comicInfoTxt.setCaretPosition(0);
		comicInfoTxt.setLineWrap(true);
		comicInfoTxt.setWrapStyleWord(true);
		comicInfoTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		comicInfoTxt.setFocusable(false);
		comicInfoTxt.setBackground(new Color(128, 128, 128));
		comicInfoTxt.setBounds(60, 24, 643, 402);

		JScrollPane comicsViewSP = new JScrollPane(comicInfoTxt);
		comicsViewSP.setBounds(60, 24, 643, 402);
		backgroundPanel.add(comicsViewSP);
	}
}
