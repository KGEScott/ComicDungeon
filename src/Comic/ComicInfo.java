package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ComicInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3650978427635966970L;
	private JPanel contentPane;
	private String[] imgUrls;
	Image image;

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
	 * 
	 * @throws IOException
	 */
	public ComicInfo() throws IOException {
		Border emptyBorder = BorderFactory.createEmptyBorder();
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

		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(128, 128, 128));
		imagePanel.setBounds(543, 11, 215, 279);
		backgroundPanel.add(imagePanel);
		imagePanel.setLayout(null);

		JLabel comicImageLbl = new JLabel();
		comicImageLbl.setBorder(new LineBorder(Color.BLACK, 5));
		comicImageLbl.setBounds(0, 0, 215, 279);
		imagePanel.add(comicImageLbl);

		JLabel lblNewLabel = new JLabel("No Image Found");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel.setBounds(54, 108, 120, 22);
		imagePanel.add(lblNewLabel);

		List<Map<String, String>> comicInfo = DBConnection.pullComicsInfo(LoginInfo.getComicsID());
		JTextArea comicInfoTxt = new JTextArea();
		comicInfoTxt.setBorder(new LineBorder(Color.BLACK, 5));

		// String id = null;
		String number = null;
		String publication_date = null;
		String price = null;
		String page_count = null;
		String editing = null;
		String notes = null;
		String on_sale_date = null;
		for (Map<String, String> information : comicInfo) {
			for (Map.Entry<String, String> entry : information.entrySet()) {
				// if (entry.getKey().equals("id")) {
				// id = entry.getValue();
				if (entry.getKey().equals("number")) {
					number = entry.getValue();
				} else if (entry.getKey().equals("publication_date")) {
					publication_date = entry.getValue();
				} else if (entry.getKey().equals("price")) {
					price = entry.getValue();
				} else if (entry.getKey().equals("page_count")) {
					page_count = entry.getValue();
				} else if (entry.getKey().equals("editing")) {
					editing = entry.getValue();
				} else if (entry.getKey().equals("notes") && entry.getValue().equals(null)
						|| entry.getValue().equals("") || entry.getValue().equals(" ")) {
					notes = "No Notes";
				} else if (entry.getKey().equals("notes") && entry.getValue() != null) {
					notes = entry.getValue();
				} else if (entry.getKey().equals("on_sale_date")) {
					on_sale_date = entry.getValue();
				}
			}
		}
		comicInfoTxt.setText(notes);
		comicInfoTxt.setCaretPosition(0);
		comicInfoTxt.setLineWrap(true);
		comicInfoTxt.setWrapStyleWord(true);
		comicInfoTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		comicInfoTxt.setFocusable(false);
		comicInfoTxt.setBackground(new Color(128, 128, 128));
		comicInfoTxt.setBounds(60, 24, 643, 402);

		JScrollPane comicsViewSP = new JScrollPane(comicInfoTxt);
		comicsViewSP.setBounds(10, 298, 748, 128);
		backgroundPanel.add(comicsViewSP);

		JTextArea publisherNameTA = new JTextArea();
		publisherNameTA.setBackground(new Color(68, 68, 68));
		publisherNameTA.setForeground(new Color(255, 255, 255));
		publisherNameTA.setEditable(false);
		publisherNameTA.setText("Publisher Name:");
		publisherNameTA.setBounds(23, 22, 122, 22);
		backgroundPanel.add(publisherNameTA);

		JTextArea seriesNameTA = new JTextArea();
		seriesNameTA.setBackground(new Color(68, 68, 68));
		seriesNameTA.setForeground(new Color(255, 255, 255));
		seriesNameTA.setEditable(false);
		seriesNameTA.setText("Series Name:");
		seriesNameTA.setBounds(22, 55, 98, 22);
		backgroundPanel.add(seriesNameTA);

		JTextArea issueNumberTA = new JTextArea();
		issueNumberTA.setBackground(new Color(68, 68, 68));
		issueNumberTA.setForeground(new Color(255, 255, 255));
		issueNumberTA.setEditable(false);
		issueNumberTA.setText("Issue Number:");
		issueNumberTA.setBounds(23, 88, 106, 22);
		backgroundPanel.add(issueNumberTA);

		JTextArea pubDateTA = new JTextArea();
		pubDateTA.setBackground(new Color(68, 68, 68));
		pubDateTA.setForeground(new Color(255, 255, 255));
		pubDateTA.setEditable(false);
		pubDateTA.setText("Publication Date:");
		pubDateTA.setBounds(23, 121, 138, 22);
		backgroundPanel.add(pubDateTA);

		JTextArea pageCountTA = new JTextArea();
		pageCountTA.setBackground(new Color(68, 68, 68));
		pageCountTA.setForeground(new Color(255, 255, 255));
		pageCountTA.setEditable(false);
		pageCountTA.setText("Page Count:");
		pageCountTA.setBounds(23, 154, 97, 22);
		backgroundPanel.add(pageCountTA);

		JTextArea editingTA = new JTextArea();
		editingTA.setBackground(new Color(68, 68, 68));
		editingTA.setForeground(new Color(255, 255, 255));
		editingTA.setEditable(false);
		editingTA.setText("Editing:");
		editingTA.setBounds(23, 187, 73, 22);
		backgroundPanel.add(editingTA);

		JTextArea priceTA = new JTextArea();
		priceTA.setBackground(new Color(68, 68, 68));
		priceTA.setForeground(new Color(255, 255, 255));
		priceTA.setEditable(false);
		priceTA.setText("Price:");
		priceTA.setBounds(23, 220, 57, 22);
		backgroundPanel.add(priceTA);

		JTextArea notesTA = new JTextArea();
		notesTA.setBackground(new Color(68, 68, 68));
		notesTA.setForeground(new Color(255, 255, 255));
		notesTA.setEditable(false);
		notesTA.setText("Notes:");
		notesTA.setBounds(23, 269, 57, 22);
		backgroundPanel.add(notesTA);

		JTextArea saleDateTA = new JTextArea();
		saleDateTA.setBackground(new Color(68, 68, 68));
		saleDateTA.setForeground(new Color(255, 255, 255));
		saleDateTA.setEditable(false);
		saleDateTA.setText("On Sale Date:");
		saleDateTA.setBounds(240, 220, 113, 22);
		backgroundPanel.add(saleDateTA);

		try {
			imgUrls = IssueParser.getImageUrls();
		} catch (IOException e) {
			System.out.println("Error connecting to the website: " + e.getMessage());
		}

		JComboBox<UrlWithIndex> variantDropDown = new JComboBox<>();
		variantDropDown.setBorder(new LineBorder(Color.BLACK, 1));
		variantDropDown.setForeground(new Color(255, 255, 255));
		variantDropDown.setBackground(new Color(68, 68, 68));
		variantDropDown.setBounds(427, 268, 106, 22);

		int index = 1;
		for (String url : imgUrls) {
			variantDropDown.addItem(new UrlWithIndex(index, url));
			index++;
		}
		backgroundPanel.add(variantDropDown);

		JTextArea pubNameD = new JTextArea();
		pubNameD.setForeground(new Color(255, 255, 255));
		pubNameD.setBackground(new Color(68, 68, 68));
		pubNameD.setEditable(false);
		pubNameD.setText(LoginInfo.getPublisherName());
		pubNameD.setBounds(171, 22, 246, 22);
		backgroundPanel.add(pubNameD);

		JTextArea seriesNameD = new JTextArea();
		seriesNameD.setForeground(new Color(255, 255, 255));
		seriesNameD.setBackground(new Color(68, 68, 68));
		seriesNameD.setEditable(false);
		seriesNameD.setText(LoginInfo.getSeriesName());
		seriesNameD.setBounds(171, 55, 246, 22);
		backgroundPanel.add(seriesNameD);

		JTextArea issueNumD = new JTextArea();
		issueNumD.setForeground(new Color(255, 255, 255));
		issueNumD.setBackground(new Color(68, 68, 68));
		issueNumD.setEditable(false);
		issueNumD.setText(number);
		issueNumD.setBounds(171, 88, 246, 22);
		backgroundPanel.add(issueNumD);

		JTextArea pubDateD = new JTextArea();
		pubDateD.setForeground(new Color(255, 255, 255));
		pubDateD.setBackground(new Color(68, 68, 68));
		pubDateD.setEditable(false);
		pubDateD.setText(publication_date);
		pubDateD.setBounds(171, 121, 246, 22);
		backgroundPanel.add(pubDateD);

		JTextArea pageCountD = new JTextArea();
		pageCountD.setForeground(new Color(255, 255, 255));
		pageCountD.setBackground(new Color(68, 68, 68));
		pageCountD.setEditable(false);
		pageCountD.setText(page_count);
		pageCountD.setBounds(171, 154, 98, 22);
		backgroundPanel.add(pageCountD);

		JTextArea editingD = new JTextArea();
		editingD.setForeground(new Color(255, 255, 255));
		editingD.setBackground(new Color(68, 68, 68));
		editingD.setEditable(false);
		editingD.setText(editing);
		editingD.setBounds(171, 187, 362, 22);
		backgroundPanel.add(editingD);

		JTextArea priceD = new JTextArea();
		priceD.setForeground(new Color(255, 255, 255));
		priceD.setBackground(new Color(68, 68, 68));
		priceD.setEditable(false);
		priceD.setText(price);
		priceD.setBounds(90, 220, 140, 22);
		backgroundPanel.add(priceD);

		JTextArea saleDateD = new JTextArea();
		saleDateD.setForeground(new Color(255, 255, 255));
		saleDateD.setBackground(new Color(68, 68, 68));
		saleDateD.setEditable(false);
		saleDateD.setText(on_sale_date);
		saleDateD.setBounds(363, 220, 170, 22);
		backgroundPanel.add(saleDateD);

		JButton addComicBtn = new JButton("Add Comic");
		addComicBtn.setBorder(emptyBorder);
		addComicBtn.setForeground(Color.BLACK);
		addComicBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addComicBtn.setFocusable(false);
		addComicBtn.setBorder(BorderFactory.createEtchedBorder());
		addComicBtn.setBackground(new Color(85, 85, 85));
		addComicBtn.setBounds(444, 23, 89, 23);
		backgroundPanel.add(addComicBtn);

		try {
			if (imgUrls.length > 0) {
				Image initialImg = ImageIO.read(new URL(imgUrls[0]));
				comicImageLbl.setIcon(new ImageIcon(initialImg.getScaledInstance(215, 279, Image.SCALE_DEFAULT)));
			} else {
				comicImageLbl.setIcon(null);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		variantDropDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UrlWithIndex selectedItem = (UrlWithIndex) variantDropDown.getSelectedItem();
				String selectedUrl = selectedItem.getUrl();

				try {
					Image image = ImageIO.read(new URL(selectedUrl));
					comicImageLbl.setIcon(new ImageIcon(image.getScaledInstance(215, 279, Image.SCALE_DEFAULT)));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		addComicBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call the addComic method from the DBConnection class
				DBConnection.addComic(LoginInfo.getUsername(), LoginInfo.getComicsID(), LoginInfo.getSeriesID(),
						LoginInfo.getPublisherID());
			}
		});
	}

	class UrlWithIndex {
		private int index;
		private String url;

		public UrlWithIndex(int index, String url) {
			this.index = index;
			this.url = url;
		}

		@Override
		public String toString() {
			return Integer.toString(index);
		}

		public int getIndex() {
			return index;
		}

		public String getUrl() {
			return url;
		}
	}
}
