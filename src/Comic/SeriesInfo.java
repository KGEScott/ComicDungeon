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

public class SeriesInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 801635198570498158L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeriesInfo frame = new SeriesInfo();
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
	public SeriesInfo() {
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

		List<Map<String, String>> seriesInfo = DBConnection.pullSeriesInfo(LoginInfo.getIdView());
		JTextArea seriesInfoTxt = new JTextArea();

		//String id = null;
		String name = null;
		String year_began = null;
		String year_ended = null;
		String notes = null;
		String color = null;
		String dimensions = null;
		String paper_stock = null;
		String binding = null;
		String publishing_format = null;

		for (Map<String, String> information : seriesInfo) {
			for (Map.Entry<String, String> entry : information.entrySet()) {
//				if (entry.getKey().equals("id")) {
//					id = entry.getValue();
//				}
				if (entry.getKey().equals("name")) {
					name = entry.getValue();
				} else if (entry.getKey().equals("year_began")) {
					year_began = entry.getValue();
				} else if (entry.getKey().equals("year_ended")) {
					year_ended = entry.getValue();
				} else if (entry.getKey().equals("notes")) {
					notes = entry.getValue();
				} else if (entry.getKey().equals("color")) {
					color = entry.getValue();
				} else if (entry.getKey().equals("dimensions")) {
					dimensions = entry.getValue();
				} else if (entry.getKey().equals("paper_stock")) {
					paper_stock = entry.getValue();
				} else if (entry.getKey().equals("binding")) {
					binding = entry.getValue();
				} else if (entry.getKey().equals("publishing_format")) {
					publishing_format = entry.getValue();
				}
			}
		}
		seriesInfoTxt.setText("Publisher Name:\n\t" + LoginInfo.getPublisherName() + "\nSeries Name:\n\t" + name
				+ "\nYear Began:\n\t" + year_began + "\nYear Ended:\n\t" + year_ended + "\nColor:\n\t" + color
				+ "\nDimensions:\n\t" + dimensions + "\nPaper Stock:\n\t" + paper_stock + "\nBinding:\n\t" + binding
				+ "\nPublish Format:\n\t" + publishing_format + "\nNotes:\n\t" + notes);
		seriesInfoTxt.setCaretPosition(0);
		seriesInfoTxt.setLineWrap(true);
		seriesInfoTxt.setWrapStyleWord(true);
		seriesInfoTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		seriesInfoTxt.setFocusable(false);
		seriesInfoTxt.setBackground(new Color(128, 128, 128));
		seriesInfoTxt.setBounds(60, 24, 643, 402);

		JScrollPane seriesViewSP = new JScrollPane(seriesInfoTxt);
		seriesViewSP.setBounds(60, 24, 643, 402);
		backgroundPanel.add(seriesViewSP);
	}

}
