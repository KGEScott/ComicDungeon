package Comic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

public class UserInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private Border emptyBorder;
	public static String currentSeriesScroll;
	public static String getPublisherNameToSearch;
	public static String idView;
	public static String idEnter;
	public static String seriesID;
	public static String currentScrollPanel;
	public static String publisherName;
	public static String seriesName;
	public static String comicsID;
	public static String comicsIssue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.addComponentListener(new ComponentAdapter() {
						public void componentResized(ComponentEvent e) {
							frame.getContentPane().revalidate();
							frame.getContentPane().repaint();
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		ImageIcon icon = new ImageIcon(Login.class.getResource("/Comic/Icons/dungeon door 2.png"));
		Image image = icon.getImage();
		setIconImage(image);
		setTitle("Comic Dungeon");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the JFrame bounds to the screen size

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		setBounds(screenWidth / 2 - 640, screenHeight / 2 - 400, 1280, 800);
		setMinimumSize(new Dimension(1250, 845));

		JPanel bannerPanel = new JPanel();
		bannerPanel.setBorder(new LineBorder(new Color(73, 73, 73), 10, true));
		bannerPanel.setBackground(new Color(30, 30, 30));
		bannerPanel.setLayout(new GridBagLayout());

		JLabel comicDungeonIcon = new JLabel("");
		comicDungeonIcon.setIcon(new ImageIcon(UserInterface.class.getResource("/Comic/Icons/comicDungeonbit2.png")));

		// Set GridBagConstraints to center the image
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		bannerPanel.add(comicDungeonIcon, gbc);

		JPanel menuButtonPanel = new JPanel();
		menuButtonPanel.setBorder(new LineBorder(new Color(44, 44, 44), 5, true));
		menuButtonPanel.setBackground(new Color(2, 48, 57));
		menuButtonPanel.setLayout(new BorderLayout());

		// Set the preferred size to be 50 pixels wider
		menuButtonPanel.setPreferredSize(new Dimension(250, 800));

		CardLayout c1 = new CardLayout();
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(73, 73, 73));
		infoPanel.setLayout(c1);

		JPanel searchPublishersPanel = new JPanel(new BorderLayout());
		searchPublishersPanel.setBackground(new Color(38, 38, 38));
		infoPanel.add(searchPublishersPanel, "Search Publisher Panel");

		JPanel searchComicsPanel = new JPanel(new BorderLayout());
		searchComicsPanel.setBackground(new Color(38, 38, 38));
		infoPanel.add(searchComicsPanel, "Search Comics Panel");

		JPanel myComicsPanel = new JPanel(new BorderLayout());
		myComicsPanel.setBackground(new Color(38, 38, 38));
		myComicsPanel.setLayout(new BorderLayout());
		infoPanel.add(myComicsPanel, "My Comics Panel");

		JPanel accountPanel = new JPanel();
		accountPanel.setBackground(new Color(38, 38, 38));
		accountPanel.setLayout(new BorderLayout());
		infoPanel.add(accountPanel, "Account Panel");

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 46, 46));
		contentPane.setLayout(new BorderLayout());
		contentPane.add(bannerPanel, BorderLayout.NORTH);
		contentPane.add(menuButtonPanel, BorderLayout.WEST);
		contentPane.add(infoPanel, BorderLayout.CENTER);

		setContentPane(contentPane);

		JTextField getSeriesName = new JTextField();
		getSeriesName.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		getSeriesName.setBorder(emptyBorder);
		getSeriesName.setForeground(Color.WHITE);
		getSeriesName.setBackground(new Color(73, 73, 73));
		getSeriesName.setPreferredSize(new Dimension(216, 20));
//		searchComicsPanel.add(getSeriesName, BorderLayout.WEST);

		JTextField getPublisherName = new JTextField();
		getPublisherName.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		getPublisherName.setBorder(emptyBorder);
		getPublisherName.setForeground(Color.WHITE);
		getPublisherName.setBackground(new Color(73, 73, 73));
		getPublisherName.setPreferredSize(new Dimension(216, 20));
//		searchPublishersPanel.add(getPublisherName, BorderLayout.WEST);

		JTextArea accountPanelInfo = new JTextArea();
		accountPanelInfo.setPreferredSize(new Dimension(216, 20));
		accountPanelInfo.setEditable(false);
		accountPanelInfo.setFocusable(false);

		JButton seriesSearchBtn = new JButton("Search");
		Properties.setLoginButtonProperties(seriesSearchBtn, 477, 16, 89, 20);
		seriesSearchBtn.setPreferredSize(new Dimension(89, 20));
//		searchComicsPanel.add(seriesSearchBtn, BorderLayout.CENTER);
		searchComicsPanel.getRootPane().setDefaultButton(seriesSearchBtn);

		JButton publisherSearchBtn = new JButton("Search");
		Properties.setLoginButtonProperties(publisherSearchBtn, 477, 16, 89, 20);
		publisherSearchBtn.setPreferredSize(new Dimension(89, 20));
//		searchPublishersPanel.add(publisherSearchBtn, BorderLayout.CENTER);
		searchPublishersPanel.getRootPane().setDefaultButton(publisherSearchBtn);

		Properties.setLoginButtonProperties(publisherSearchBtn, 477, 16, 89, 20);
		publisherSearchBtn.setPreferredSize(new Dimension(89, 20));

		JButton seriesBackBtn = new JButton("Back");
		Properties.setLoginButtonProperties(seriesBackBtn, 100, 110, 89, 20);
		publisherSearchBtn.setPreferredSize(new Dimension(89, 20));

		JButton backBtn = new JButton("Back");
		Properties.setLoginButtonProperties(backBtn, 100, 110, 89, 20);
		publisherSearchBtn.setPreferredSize(new Dimension(89, 20));

		JButton searchPublishers = new JButton("Search Publishers");
		Properties.setMainButtonProperties(searchPublishers);
		searchPublishers.setBorder(new LineBorder(Color.BLACK, 1));
		searchPublishers.setModel(new FixedStateButtonModel());
		menuButtonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		searchPublishers.setBackground(new Color(23, 23, 23));
		searchPublishers.setMinimumSize(new Dimension(244, 52));
		menuButtonPanel.add(searchPublishers);

		JButton searchComics = new JButton("Search Comics");
		Properties.setMainButtonProperties(searchComics);
		searchComics.setBorder(new LineBorder(Color.BLACK, 1));
		searchComics.setModel(new FixedStateButtonModel());
		searchComics.setBackground(new Color(3, 66, 80));
		searchComics.setMinimumSize(new Dimension(244, 52));
		// searchComics.setBounds(0, 68, 244, 52);
		menuButtonPanel.add(searchComics);

		JButton userComics = new JButton("My Comics");
		Properties.setMainButtonProperties(userComics);
		userComics.setBorder(new LineBorder(Color.BLACK, 1));
		userComics.setModel(new FixedStateButtonModel());
		userComics.setBackground(new Color(3, 66, 80));
		userComics.setMinimumSize(new Dimension(244, 52));
		// userComics.setBounds(0, 125, 244, 52);
		menuButtonPanel.add(userComics);

		JButton accountButton = new JButton("Account");
		Properties.setMainButtonProperties(accountButton);
		accountButton.setBorder(new LineBorder(Color.BLACK, 1));
		accountButton.setModel(new FixedStateButtonModel());
		accountButton.setBackground(new Color(3, 66, 80));
		accountButton.setMinimumSize(new Dimension(244, 52));
		// accountButton.setBounds(0, 182, 244, 52);
		menuButtonPanel.add(accountButton);

		JButton signOut = new JButton("Sign Out");
		Properties.setMainButtonProperties(signOut);
		signOut.setBorder(new LineBorder(Color.BLACK, 1));
		signOut.setModel(new FixedStateButtonModel());
		signOut.setBackground(new Color(3, 66, 80));
		signOut.setMinimumSize(new Dimension(244, 52));
		// signOut.setBounds(0, 725, 244, 52);
		menuButtonPanel.add(signOut);

		JLabel space1 = new JLabel("");
		menuButtonPanel.add(space1);

		JLabel space2 = new JLabel("");
		menuButtonPanel.add(space2);

		JLabel space3 = new JLabel("");
		menuButtonPanel.add(space3);

		JLabel space4 = new JLabel("");
		menuButtonPanel.add(space4);

		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new BorderLayout());
		searchPanel.setBackground(new Color(38, 38, 38));

		// Create a new panel for the text field, search button, and back button
		JPanel searchInputPanel = new JPanel(new FlowLayout());
		searchInputPanel.setBackground(new Color(38, 38, 38));
		searchInputPanel.add(getPublisherName);
		searchInputPanel.add(publisherSearchBtn);
		searchInputPanel.add(backBtn);
		searchPanel.add(searchInputPanel, BorderLayout.NORTH);

		JTextPane helpTextPane = new JTextPane();
		helpTextPane.setBackground(new Color(38, 38, 38));
		helpTextPane.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		helpTextPane.setForeground(Color.WHITE);
		helpTextPane.setEditorKit(new StyledEditorKit()); // Set the editor kit to use styled documents
		StyledDocument doc = new DefaultStyledDocument();
		helpTextPane.setStyledDocument(doc);
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		helpTextPane.setText(
				"For additional details about your selection, click 'View'. To see all series or comics within, click 'Enter'.");
		searchPanel.add(helpTextPane, BorderLayout.CENTER);

		JPanel searchPanel2 = new JPanel();
		searchPanel2.setLayout(new BorderLayout());
		searchPanel2.setBackground(new Color(38, 38, 38));

		// Create a new panel for the text field, search button, and back button
		JPanel searchInputPanel2 = new JPanel(new FlowLayout());
		searchInputPanel2.setBackground(new Color(38, 38, 38));
		searchInputPanel2.add(getSeriesName);
		searchInputPanel2.add(seriesSearchBtn);
		searchInputPanel2.add(seriesBackBtn);
		searchPanel2.add(searchInputPanel2, BorderLayout.NORTH);

		JTextPane helpTextPane2 = new JTextPane();
		helpTextPane2.setBackground(new Color(38, 38, 38));
		helpTextPane2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		helpTextPane2.setForeground(Color.WHITE);
		helpTextPane2.setEditorKit(new StyledEditorKit()); // Set the editor kit to use styled documents
		StyledDocument doc2 = new DefaultStyledDocument();
		helpTextPane2.setStyledDocument(doc2);
		SimpleAttributeSet center2 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
		doc2.setParagraphAttributes(0, doc2.getLength(), center2, false);
		helpTextPane2.setText(
				"For additional details about your selection, click 'View'. To see all series or comics within, click 'Enter'.");
		searchPanel2.add(helpTextPane2, BorderLayout.CENTER);

		searchComicsPanel.add(searchPanel2, BorderLayout.NORTH);
		searchPublishersPanel.add(searchPanel, BorderLayout.NORTH);

		JButton changePW = new JButton("Change Password");
		Properties.setLoginButtonProperties(changePW, 372, 540, 134, 23);

		List<String> accountInfo = DBConnection.pullUserInfo(LoginInfo.getUsername());
		JTextArea accountInfoText = new JTextArea();
		accountInfoText.setText("            Account Information" + "\n\n FirstName:        " + accountInfo.get(1)
				+ "\n\n Last Name:        " + accountInfo.get(2) + "\n\n Email:              " + accountInfo.get(3)
				+ "\n\n Date of Birth:     " + accountInfo.get(4) + "\n\n Username:         " + accountInfo.get(0));
		accountInfoText.setForeground(new Color(192, 192, 192));
		accountInfoText.setBackground(new Color(48, 48, 48));
		accountInfoText.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		accountInfoText.setBorder(new LineBorder(new Color(28, 28, 28), 10));
		accountInfoText.setPreferredSize(accountInfoText.getMinimumSize());

		JPanel accountInfoPanel = new JPanel(new GridBagLayout());
		accountInfoPanel.setBackground(new Color(38, 38, 38));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(-200, 0, 0, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		accountInfoPanel.add(accountInfoText, constraints);

		// Set the preferred size of the JPanel to the desired minimum size
		accountInfoPanel.setPreferredSize(new Dimension(984, 778));

		GridBagConstraints constraints2 = new GridBagConstraints();
		constraints2.gridx = 0;
		constraints2.gridy = GridBagConstraints.RELATIVE;
		constraints2.insets = new Insets(0, 100, 0, 100);
		constraints2.fill = GridBagConstraints.HORIZONTAL;
		accountInfoPanel.add(changePW, constraints2);

		accountPanel.add(accountInfoPanel, BorderLayout.CENTER);

		searchPublishers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(infoPanel, "Search Publisher Panel");
				searchPublishers.setBackground(new Color(23, 23, 23));
				accountButton.setBackground(new Color(3, 66, 80));
				searchComics.setBackground(new Color(3, 66, 80));
				userComics.setBackground(new Color(3, 66, 80));
				revalidate();
				repaint();
			}
		});

		searchComics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(infoPanel, "Search Comics Panel");
				searchComics.setBackground(new Color(23, 23, 23));
				userComics.setBackground(new Color(3, 66, 80));
				accountButton.setBackground(new Color(3, 66, 80));
				searchPublishers.setBackground(new Color(3, 66, 80));
				revalidate();
				repaint();
			}
		});

		userComics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(infoPanel, "My Comics Panel");
				userComics.setBackground(new Color(23, 23, 23));
				accountButton.setBackground(new Color(3, 66, 80));
				searchComics.setBackground(new Color(3, 66, 80));
				searchPublishers.setBackground(new Color(3, 66, 80));
				UserCollection userCollectionPanel = new UserCollection();
				myComicsPanel.add(userCollectionPanel);
				revalidate();
				repaint();
			}
		});
		// Action Listeners
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(infoPanel, "Account Panel");
				accountButton.setBackground(new Color(23, 23, 23));
				userComics.setBackground(new Color(3, 66, 80));
				searchComics.setBackground(new Color(3, 66, 80));
				searchPublishers.setBackground(new Color(3, 66, 80));
				revalidate();
				repaint();
			}
		});

		signOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});

		JPanel seriesPanelFlow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		seriesPanelFlow.setBackground(new Color(38, 38, 38));
		seriesPanelFlow.setPreferredSize(infoPanel.getSize());
		searchComicsPanel.add(seriesPanelFlow);

		// search Series Search pane
		JScrollPane searchSeriesScroll = new JScrollPane();
		searchSeriesScroll.setBorder(emptyBorder);
		Properties.setPanelProperties(searchSeriesScroll);
		searchSeriesScroll.getViewport().setBackground(new Color(38, 38, 38));
		searchSeriesScroll.getViewport().setPreferredSize(new Dimension(900, (screenHeight / 2) - 200));
		seriesPanelFlow.add(searchSeriesScroll);

		// search series comic pane
		JScrollPane searchSeriesScroll2 = new JScrollPane();
		searchSeriesScroll2.setBorder(emptyBorder);
		Properties.setPanelProperties(searchSeriesScroll2);
		searchSeriesScroll2.getViewport().setBackground(new Color(38, 38, 38));
		searchSeriesScroll2.getViewport().setPreferredSize(new Dimension(900, (screenHeight / 2) - 200));
		seriesPanelFlow.add(searchSeriesScroll2);

		JPanel pubPanelFlow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pubPanelFlow.setBackground(new Color(38, 38, 38));
		pubPanelFlow.setPreferredSize(infoPanel.getSize());
		searchPublishersPanel.add(pubPanelFlow);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(emptyBorder);
		Properties.setPanelProperties(scrollPane);
		scrollPane.getViewport().setBackground(new Color(38, 38, 38));
		scrollPane.getViewport().setPreferredSize(new Dimension(900, (screenHeight / 2) - 200));
		pubPanelFlow.add(scrollPane);

		// series pane
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(emptyBorder);
		Properties.setPanelProperties(scrollPane2);
		scrollPane2.getViewport().setBackground(new Color(38, 38, 38));
		scrollPane2.getViewport().setPreferredSize(new Dimension(900, (screenHeight / 2) - 200));
		pubPanelFlow.add(scrollPane2);

		// comics pane
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBorder(emptyBorder);
		Properties.setPanelProperties(scrollPane3);
		scrollPane3.getViewport().setBackground(new Color(38, 38, 38));
		scrollPane3.getViewport().setPreferredSize(new Dimension(900, (screenHeight / 2) - 200));
		pubPanelFlow.add(scrollPane3);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int frameHeight = e.getComponent().getHeight();
				int preferredHeight = frameHeight / 2;
				searchSeriesScroll.getViewport().setPreferredSize(new Dimension(900, preferredHeight));
				searchSeriesScroll2.getViewport().setPreferredSize(new Dimension(900, preferredHeight));
				scrollPane.getViewport().setPreferredSize(new Dimension(900, preferredHeight));
				scrollPane2.getViewport().setPreferredSize(new Dimension(900, preferredHeight));
				scrollPane3.getViewport().setPreferredSize(new Dimension(900, preferredHeight));
				repaint();
				revalidate();
			}
		});

		JTable searchSeriesTable = new JTable();
		searchSeriesScroll.setViewportView(searchSeriesTable);

		JTable searchSeriesTable2 = new JTable();
		searchSeriesScroll2.setViewportView(searchSeriesTable2);

		JTable searchTable = new JTable();
		scrollPane.setViewportView(searchTable);

		JTable seriesTable = new JTable();
		scrollPane2.setViewportView(seriesTable);

		JTable comicsTable = new JTable();
		scrollPane3.setViewportView(comicsTable);

		JPanel copyRightPanel2 = new JPanel();
		copyRightPanel2.setBackground(new Color(38, 38, 38));
		copyRightPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JEditorPane copyRight2 = new JEditorPane();
		copyRight2.setContentType("text/html");
		copyRight2.setText(
				"<html><span style='color: #555555;'>Data courtesy of the </span><a href='https://www.comics.org/' "
						+ "style='color: #444444;'>Grand Comics Database\u2122</a> <span style='color: #555555;'>under a "
						+ "</span><a href='https://creativecommons.org/licenses/by-sa/4.0/' style='color: #444444;'>Creative Commons "
						+ "Attribution license</a>.<span style='color: #555555;'> Cover thumbnails are used for identification "
						+ "purposes only. All rights to cover images reserved by the respective copyright holders.  </span></html>");
		copyRight2.setEditable(false);
		copyRight2.setBackground(new Color(38, 38, 38));
		copyRight2.setForeground(Color.WHITE);
		copyRight2.setFont(new Font("Comic Sans MS", Font.PLAIN, 5));
		copyRight2.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					try {
						Desktop.getDesktop().browse(e.getURL().toURI());
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		copyRightPanel2.add(copyRight2);
		searchComicsPanel.add(copyRightPanel2, BorderLayout.SOUTH);

		JPanel copyRightPanel = new JPanel();
		copyRightPanel.setBackground(new Color(38, 38, 38));
		copyRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JEditorPane copyRight = new JEditorPane();
		copyRight.setContentType("text/html");
		copyRight.setText(
				"<html><span style='color: #555555;'>Data courtesy of the </span><a href='https://www.comics.org/' "
						+ "style='color: #444444;'>Grand Comics Database\u2122</a> <span style='color: #555555;'>under a "
						+ "</span><a href='https://creativecommons.org/licenses/by-sa/4.0/' style='color: #444444;'>Creative Commons "
						+ "Attribution license</a>.<span style='color: #555555;'> Cover thumbnails are used for identification "
						+ "purposes only. All rights to cover images reserved by the respective copyright holders.  </span></html>");
		copyRight.setEditable(false);
		copyRight.setBackground(new Color(38, 38, 38));
		copyRight.setForeground(Color.WHITE);
		copyRight.setFont(new Font("Comic Sans MS", Font.PLAIN, 5));
		copyRight.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					try {
						Desktop.getDesktop().browse(e.getURL().toURI());
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		copyRightPanel.add(copyRight);
		searchPublishersPanel.add(copyRightPanel, BorderLayout.SOUTH);

		changePW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword.main(null);
			}
		});

		searchSeriesTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickSeriesSearchTable(searchComicsPanel, searchSeriesScroll, searchSeriesScroll2, searchSeriesTable,
						searchSeriesTable2, seriesBackBtn, e);
			}
		});
		// series table mouse clickies
		searchSeriesTable2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickComicsTable2(searchComicsPanel, searchSeriesTable, searchSeriesTable2, seriesBackBtn, e);
			}
		});

		// search table logic that gets information for series and outputs the values
		// based on where clicked.
		searchTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickSearchTable(searchPublishersPanel, scrollPane, scrollPane2, searchTable, seriesTable, backBtn, e);
			}
		});
		// series table mouse clickies
		seriesTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickSeriesTable(searchPublishersPanel, scrollPane2, scrollPane3, seriesTable, comicsTable, backBtn, e);
			}
		});

		// series table mouse clickies
		comicsTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickComicsTable(searchPublishersPanel, seriesTable, comicsTable, backBtn, e);
			}
		});

		getSeriesName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && !getSeriesName.getText().isEmpty()) {
					seriesSearchBtn.doClick();
				}
			}
		});

		getPublisherName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && !getPublisherName.getText().isEmpty()) {
					publisherSearchBtn.doClick();
				}
			}
		});

		UIManager.put("Table.focusCellHighlightBorder",
				new BorderUIResource.LineBorderUIResource(new Color(5, 167, 176)));
		UIManager.put("Table.focusCellHighlightBorder",
				new BorderUIResource.LineBorderUIResource(new Color(5, 167, 176)));
		UIManager.put("Table.focusCellHighlightBorder",
				new BorderUIResource.LineBorderUIResource(new Color(5, 167, 176)));

		seriesBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentSeriesScroll.equals("Series Scroll Panel")) {
					searchSeriesScroll2.setViewportView(null);
					searchSeriesTable.setVisible(true);
					searchSeriesScroll.setViewportView(searchSeriesTable);
					clickSeriesSearchBtn(searchComicsPanel, getSeriesName, searchSeriesScroll, searchSeriesScroll2,
							searchSeriesTable, searchSeriesTable2, seriesBackBtn);
					repaint();
					revalidate();
					currentSeriesScroll = "false";
				} else {
					repaint();
					revalidate();
				}
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentScrollPanel == "Series Panel") {
					clickPubSearchBtn(searchPublishersPanel, getPublisherName, scrollPane, scrollPane2, scrollPane3,
							searchTable, backBtn);
					currentScrollPanel = null;
					repaint();
					revalidate();
				} else if (currentScrollPanel == "Comics Panel") {
					scrollPane3.setVisible(false);
					scrollPane2.setVisible(true);
					currentScrollPanel = "Series Panel";
				}
			}
		});

		seriesSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSeriesSearchBtn(searchComicsPanel, getSeriesName, searchSeriesScroll, searchSeriesScroll2,
						searchSeriesTable, searchSeriesTable2, seriesBackBtn);
				searchSeriesTable.setVisible(true);
				searchSeriesTable2.setVisible(false);
				searchSeriesScroll.setViewportView(searchSeriesTable);
				repaint();
				revalidate();
			}
		});

		// on search passes value of search text field to dbconnection it assigns values
		// to table from dbconnection and sets up buttons to move to series
		publisherSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clickPubSearchBtn(searchPublishersPanel, getPublisherName, scrollPane, scrollPane2, scrollPane3,
						searchTable, backBtn);
				repaint();
				revalidate();
			}
		});

	}

	public class FixedStateButtonModel extends DefaultButtonModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isRollover() {
			return false;
		}

		@Override
		public void setRollover(boolean b) {
			// NOOP
		}
	}

	private void clickSeriesSearchTable(JPanel searchComicsPanel, JScrollPane searchSeriesScroll,
			JScrollPane searchSeriesScroll2, JTable searchSeriesTable, JTable searchSeriesTable2, JButton seriesBackBtn,
			MouseEvent e) {
		currentSeriesScroll = "Series Scroll Panel";
		repaint();
		revalidate();
		int row = searchSeriesTable.rowAtPoint(e.getPoint());
		int col = searchSeriesTable.columnAtPoint(e.getPoint());
		if (row >= 0 && col == 0) {
			// Get the value of the 4th column of the selected row
			String selectedValue = (String) searchSeriesTable.getValueAt(row, 4);
			LoginInfo.setIdView(selectedValue);
			LoginInfo.setPublisherID(selectedValue);
			List<Map<String, String>> publisherInfo = DBConnection.pullPublisherInfo(selectedValue);
			if (publisherInfo != null && !publisherInfo.isEmpty()) {
				Map<String, String> publisherInformation = publisherInfo.get(0);
				String publisherName = publisherInformation.get("name");
				LoginInfo.setPublisherName(publisherName);
			}
			// view start here
			String selectedName = (String) searchSeriesTable.getValueAt(row, 2);
			seriesName = selectedName;
			LoginInfo.setSeriesName(seriesName);
			SeriesInfo.main(null);
		}
		if (row >= 0 && col == 1) {
			String pubID = (String) searchSeriesTable.getValueAt(row, 4);
			List<Map<String, String>> publisherInfo = DBConnection.pullPublisherInfo(pubID);
			if (publisherInfo != null && !publisherInfo.isEmpty()) {
				Map<String, String> publisherInformation = publisherInfo.get(0);
				String publisherName = publisherInformation.get("name");
				LoginInfo.setPublisherName(publisherName);
			}
			// searchComicsPanel.add(seriesBackBtn);
			String selectedValue = (String) searchSeriesTable.getValueAt(row, 3);
			String selectedName = (String) searchSeriesTable.getValueAt(row, 2);
			LoginInfo.setPublisherID(pubID);
			LoginInfo.setIdView(pubID);
			LoginInfo.setSeriesName(selectedName);
			LoginInfo.setSeriesID(selectedValue);
			DBConnection.pullComics(selectedValue);

			// enter starts here
			// enter to comics

			searchSeriesTable.setVisible(false);
			// searchSeriesScroll.setViewportView(null);
			searchSeriesTable2.setVisible(true);
			repaint();
			revalidate();
			List<Map<String, String>> queriedIssues = DBConnection.pullComics(selectedValue);

			// initialize the columns and rows of the table here
			// Set the number of rows in the table based on the number of elements in the
			// queriedPublisher list
			int numRows = queriedIssues.size();
			Object[][] data = new Object[numRows][5];
			for (int i = 0; i < numRows; i++) {
				data[i][0] = "View";
				data[i][1] = queriedIssues.get(i).get("volume");
				data[i][2] = queriedIssues.get(i).get("number");
				data[i][3] = queriedIssues.get(i).get("publication_date");
				data[i][4] = queriedIssues.get(i).get("id");
			}

			searchSeriesTable2.setModel(
					new DefaultTableModel(data, new String[] { "Comic Info", "Volume", "Number", "Pub. Date", "id" }) {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;
						@SuppressWarnings("rawtypes")
						Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class,
								String.class };

						@SuppressWarnings({ "unchecked", "rawtypes" })
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}

						boolean[] columnEditables = new boolean[] { false, false, false, false, false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			searchSeriesTable2.getColumnModel().getColumn(2).setPreferredWidth(320);
			searchSeriesTable2.getColumnModel().getColumn(3).setResizable(false);
			searchSeriesTable2.getColumnModel().getColumn(3).setPreferredWidth(150);
			searchSeriesTable2.getColumnModel().getColumn(4).setResizable(false);
			searchSeriesTable2.getColumnModel().getColumn(4).setPreferredWidth(50);

			// set the table properties
			Properties.setTableProperties(searchSeriesTable2);
			searchSeriesScroll.setViewportView(searchSeriesTable2);

		}
	}

	private void clickSearchTable(JPanel searchPublishersPanel, JScrollPane scrollPane, JScrollPane scrollPane2,
			JTable searchTable, JTable seriesTable, JButton backBtn, MouseEvent e) {
		currentScrollPanel = "Series Panel";
		repaint();
		revalidate();
		LoginInfo.setCurrentScrollPanel(currentScrollPanel);
		int row = searchTable.rowAtPoint(e.getPoint());
		int col = searchTable.columnAtPoint(e.getPoint());
		if (row >= 0 && col == 0) {
			// Get the value of the 4th column of the selected row
			String selectedValue = (String) searchTable.getValueAt(row, 3);
			// idView = selectedValue;
			LoginInfo.setIdView(selectedValue);
			DBConnection.pullPublisherInfo(selectedValue);
			String selectedName = (String) searchTable.getValueAt(row, 2);
			publisherName = selectedName;
			LoginInfo.setPublisherName(publisherName);
			PublisherInfo.main(null);
		}

		if (row >= 0 && col == 1) {
			// searchPublishersPanel.add(backBtn);
			String selectedValue = (String) searchTable.getValueAt(row, 3);
			String selectedName = (String) searchTable.getValueAt(row, 2);
			LoginInfo.setPublisherName(selectedName);
			LoginInfo.setPublisherID(selectedValue);
			LoginInfo.setIdEnter(selectedValue);
			DBConnection.pullSeries(selectedValue);
			// enter starts here
			scrollPane.setVisible(false);
			scrollPane2.setVisible(true);
			repaint();
			revalidate();
			List<Map<String, String>> queriedSeries = DBConnection.pullSeries(selectedValue);
			// initialize the columns and rows of the table here
			// Set the number of rows in the table based on the number of elements in the
			// queriedPublisher list
			int numRows = queriedSeries.size();
			Object[][] data = new Object[numRows][4];
			for (int i = 0; i < numRows; i++) {
				data[i][0] = "View";
				data[i][1] = "Enter";
				data[i][2] = queriedSeries.get(i).get("name");
				data[i][3] = queriedSeries.get(i).get("id");
			}
			seriesTable.setModel(
					new DefaultTableModel(data, new String[] { "Series Info", "Comics", "Series Name", "id" }) {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;
						@SuppressWarnings("rawtypes")
						Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

						@SuppressWarnings({ "unchecked", "rawtypes" })
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}

						boolean[] columnEditables = new boolean[] { false, false, false, false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			seriesTable.getColumnModel().getColumn(2).setPreferredWidth(520);
			// set the table properties
			Properties.setTableProperties(seriesTable);
		}
	}

	private void clickSeriesTable(JPanel searchPublishersPanel, JScrollPane scrollPane2, JScrollPane scrollPane3,
			JTable seriesTable, JTable comicsTable, JButton backBtn, MouseEvent e) {
		currentScrollPanel = "Series Panel";
		repaint();
		revalidate();
		LoginInfo.setCurrentScrollPanel(currentScrollPanel);
		int row = seriesTable.rowAtPoint(e.getPoint());
		int col = seriesTable.columnAtPoint(e.getPoint());
		if (row >= 0 && col == 0) {
			// Get the value of the 4th column of the selected row
			String selectedValue = (String) seriesTable.getValueAt(row, 3);
			LoginInfo.setIdView(selectedValue);
			DBConnection.pullPublisherInfo(selectedValue);
			// view start here
			String selectedName = (String) seriesTable.getValueAt(row, 2);
			seriesName = selectedName;
			LoginInfo.setSeriesName(seriesName);
			SeriesInfo.main(null);
		}
		if (row >= 0 && col == 1) {
			String selectedValue = (String) seriesTable.getValueAt(row, 3);
			String selectedName = (String) seriesTable.getValueAt(row, 2);
			LoginInfo.setSeriesName(selectedName);
			LoginInfo.setSeriesID(selectedValue);
			DBConnection.pullComics(selectedValue);
			// enter starts here
			// enter to comics
			scrollPane2.setVisible(false);
			scrollPane3.setVisible(true);
			repaint();
			revalidate();
			List<Map<String, String>> queriedIssues = DBConnection.pullComics(selectedValue);
			// initialize the columns and rows of the table here
			// Set the number of rows in the table based on the number of elements in the
			// queriedPublisher list
			int numRows = queriedIssues.size();
			Object[][] data = new Object[numRows][5];
			for (int i = 0; i < numRows; i++) {
				data[i][0] = "View";
				data[i][1] = queriedIssues.get(i).get("volume");
				data[i][2] = queriedIssues.get(i).get("number");
				data[i][3] = queriedIssues.get(i).get("publication_date");
				data[i][4] = queriedIssues.get(i).get("id");
			}

			comicsTable.setModel(
					new DefaultTableModel(data, new String[] { "Comic Info", "Volume", "Number", "Pub. Date", "id" }) {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;
						@SuppressWarnings("rawtypes")
						Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class,
								String.class };

						@SuppressWarnings({ "unchecked", "rawtypes" })
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}

						boolean[] columnEditables = new boolean[] { false, false, false, false, false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			comicsTable.getColumnModel().getColumn(2).setPreferredWidth(320);
			comicsTable.getColumnModel().getColumn(3).setResizable(false);
			comicsTable.getColumnModel().getColumn(3).setPreferredWidth(150);
			comicsTable.getColumnModel().getColumn(4).setResizable(false);
			comicsTable.getColumnModel().getColumn(4).setPreferredWidth(50);
			currentScrollPanel = "Comics Panel";
			LoginInfo.setCurrentScrollPanel(currentScrollPanel);

			// set the table properties
			Properties.setTableProperties(comicsTable);

			scrollPane3.setViewportView(comicsTable);
		}
	}

	private void clickComicsTable(JPanel publisherSearchPanel, JTable seriesTable, JTable comicsTable, JButton backBtn,
			MouseEvent e) {
		repaint();
		revalidate();
		int row = comicsTable.rowAtPoint(e.getPoint());
		int col = comicsTable.columnAtPoint(e.getPoint());
		if (row >= 0 && col == 0) {
			// Get the value of the 4th column of the selected row
			String selectedValue = (String) comicsTable.getValueAt(row, 4);
			comicsID = selectedValue;
			LoginInfo.setComicsID(comicsID);
			DBConnection.pullComicsInfo(selectedValue);
			// view start here
			String selectedIssue = (String) comicsTable.getValueAt(row, 2);
			comicsIssue = selectedIssue;
			LoginInfo.setComicsIssue(comicsIssue);
			ComicInfo.main(null);

		}
	}

	private void clickComicsTable2(JPanel searchComicsPanel, JTable searchSeriesTable, JTable searchSeriesTable2,
			JButton seriesBackBtn, MouseEvent e) {
		currentSeriesScroll = "Series Scroll Panel";
		repaint();
		revalidate();
		int row = searchSeriesTable2.rowAtPoint(e.getPoint());
		int col = searchSeriesTable2.columnAtPoint(e.getPoint());
		if (row >= 0 && col == 0) {
			// Get the value of the 4th column of the selected row
			String selectedValue = (String) searchSeriesTable2.getValueAt(row, 4);
			comicsID = selectedValue;
			LoginInfo.setComicsID(comicsID);
			DBConnection.pullComicsInfo(selectedValue);
			// view start here
			String selectedIssue = (String) searchSeriesTable2.getValueAt(row, 2);
			comicsIssue = selectedIssue;
			LoginInfo.setComicsIssue(comicsIssue);
			ComicInfo.main(null);

		}
	}

	private void clickSeriesSearchBtn(JPanel searchComicsPanel, JTextField getSeriesName,
			JScrollPane searchSeriesScroll, JScrollPane searchSeriesScroll2, JTable searchSeriesTable,
			JTable searchSeriesTable2, JButton seriesBackBtn) {
		currentSeriesScroll = "false";
		searchSeriesScroll.setVisible(true);
		searchSeriesScroll2.setVisible(false);
		String searchInfo = getSeriesName.getText();
		List<Map<String, String>> queriedSeries = DBConnection.pullSeriesName(searchInfo);
		// initialize the columns and rows of the table here
		// Set the number of rows in the table based on the number of elements in the
		// queriedPublisher list
		int numRows = queriedSeries.size();
		Object[][] data = new Object[numRows][5];
		for (int i = 0; i < numRows; i++) {
			data[i][0] = "View";
			data[i][1] = "Enter";
			data[i][2] = queriedSeries.get(i).get("name");
			data[i][3] = queriedSeries.get(i).get("id");
			data[i][4] = queriedSeries.get(i).get("publisher_id");
		}
		searchSeriesTable.setModel(
				new DefaultTableModel(data, new String[] { "Series Info", "Comics", "Series", "id", "publisher_id" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class,
							String.class };

					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		searchSeriesTable.getColumnModel().getColumn(2).setPreferredWidth(520);
		Properties.setTableProperties(searchSeriesTable);
		// searchComicsPanel.remove(seriesBackBtn);
		searchSeriesScroll.setViewportView(searchSeriesTable);
	}

	private void clickPubSearchBtn(JPanel publisherSearchPanel, JTextField getPublisherName, JScrollPane scrollPane,
			JScrollPane scrollPane2, JScrollPane scrollPane3, JTable searchTable, JButton backBtn) {
		repaint();
		revalidate();
		scrollPane.setVisible(true);
		scrollPane2.setVisible(false);
		scrollPane3.setVisible(false);
		String searchInfo = getPublisherName.getText();
		List<Map<String, String>> queriedPublisher = DBConnection.pullPublisher(searchInfo);
		// initialize the columns and rows of the table here
		// Set the number of rows in the table based on the number of elements in the
		// queriedPublisher list
		int numRows = queriedPublisher.size();
		Object[][] data = new Object[numRows][4];
		for (int i = 0; i < numRows; i++) {
			data[i][0] = "View";
			data[i][1] = "Enter";
			data[i][2] = queriedPublisher.get(i).get("name");
			data[i][3] = queriedPublisher.get(i).get("id");
		}
		searchTable.setModel(new DefaultTableModel(data, new String[] { "Pub Info", "Series", "Publisher", "id" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		searchTable.getColumnModel().getColumn(2).setPreferredWidth(520);
		Properties.setTableProperties(searchTable);
		publisherSearchPanel.remove(backBtn);
		scrollPane.setViewportView(searchTable);
	}
}