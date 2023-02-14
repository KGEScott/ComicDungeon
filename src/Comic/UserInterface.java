package Comic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;

public class UserInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Border emptyBorder;
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
	public UserInterface() {
		ImageIcon icon = new ImageIcon(Login.class.getResource("/Comic/Icons/dungeon door 2.png"));
		Image image = icon.getImage();
		setIconImage(image);
		setTitle("Comic Dungeon");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 46, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		CardLayout c1 = new CardLayout();
		// CardLayout s1 = new CardLayout();
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(73, 73, 73));
		panel_2.setBounds(266, 197, 897, 739);
		contentPane.add(panel_2);
		panel_2.setLayout(c1);
		c1.show(panel_2, "Search Publisher Panel");

		JPanel searchPublishersPanel = new JPanel();
		searchPublishersPanel.setBackground(new Color(38, 38, 38));
		panel_2.add(searchPublishersPanel, "Search Publisher Panel");
		searchPublishersPanel.setLayout(null);

		JPanel accountPanel = new JPanel();
		accountPanel.setBackground(new Color(38, 38, 38));
		accountPanel.setBounds(10, 11, 877, 717);
		panel_2.add(accountPanel, "Account Panel");
		accountPanel.setLayout(null);

		JTextArea txtrTestingAccountpanel = new JTextArea();
		txtrTestingAccountpanel.setForeground(new Color(192, 192, 192));
		txtrTestingAccountpanel.setBackground(new Color(59, 59, 59));
		txtrTestingAccountpanel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtrTestingAccountpanel.setEditable(false);

		JButton changePW = new JButton("Change Password");
		Properties.setLoginButtonProperties(changePW, 372, 540, 134, 23);
		accountPanel.add(changePW);

		List<String> accountInfo = DBConnection.pullUserInfo(LoginInfo.getUsername());
		// txtrTestingAccountPanel continuation (moved button forward)
		txtrTestingAccountpanel
				.setText("                    Account Information" + "\n\n\n\n FirstName:        " + accountInfo.get(1)
						+ "\n\n\n\n Last Name:        " + accountInfo.get(2) + "\n\n\n\n Email:              "
						+ accountInfo.get(3) + "\n\n\n\n Date of Birth:     " + accountInfo.get(4)
						+ "\n\n\n\n Username:         " + accountInfo.get(0) + "\n\n\n\n Change Password:");
		txtrTestingAccountpanel.setBounds(229, 11, 454, 695);
		accountPanel.add(txtrTestingAccountpanel);

		JPanel myComicsPanel = new JPanel();
		myComicsPanel.setBackground(new Color(38, 38, 38));
		panel_2.add(myComicsPanel, "My Comics Panel");
		myComicsPanel.setLayout(null);

		JPanel searchComicsPanel = new JPanel();
		searchComicsPanel.setBackground(new Color(38, 38, 38));
		panel_2.add(searchComicsPanel, "Search Comics Panel");
		searchComicsPanel.setLayout(null);

		JTextField getSeriesName = new JTextField();
		getSeriesName.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		getSeriesName.setBorder(emptyBorder);
		getSeriesName.setForeground(Color.WHITE);
		getSeriesName.setBackground(new Color(73, 73, 73));
		getSeriesName.setBounds(251, 16, 216, 20);
		searchComicsPanel.add(getSeriesName);
		getSeriesName.setColumns(10);

		JTextField getPublisherName = new JTextField();
		getPublisherName.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		getPublisherName.setBorder(emptyBorder);
		getPublisherName.setForeground(Color.WHITE);
		getPublisherName.setBackground(new Color(73, 73, 73));
		getPublisherName.setBounds(251, 16, 216, 20);
		searchPublishersPanel.add(getPublisherName);
		getPublisherName.setColumns(10);

		JButton seriesSearchBtn = new JButton("Search");
		Properties.setLoginButtonProperties(seriesSearchBtn, 477, 16, 89, 20);
		searchComicsPanel.add(seriesSearchBtn);
		searchComicsPanel.getRootPane().setDefaultButton(seriesSearchBtn);

		JButton publisherSearchBtn = new JButton("Search");
		Properties.setLoginButtonProperties(publisherSearchBtn, 477, 16, 89, 20);
		searchPublishersPanel.add(publisherSearchBtn);
		searchPublishersPanel.getRootPane().setDefaultButton(publisherSearchBtn);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(73, 73, 73), 10, true));
		panel.setBackground(new Color(30, 30, 30));
		panel.setBounds(0, 0, 1185, 175);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserInterface.class.getResource("/Comic/Icons/comicDungeonbit2.png")));
		lblNewLabel.setBounds(104, 0, 1019, 175);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(2, 48, 57));
		panel_1.setBounds(0, 174, 244, 800);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton searchPublishers = new JButton("Search Publishers");
		Properties.setMainButtonProperties(searchPublishers);
		searchPublishers.setModel(new FixedStateButtonModel());
		searchPublishers.setBackground(new Color(23, 23, 23));
		searchPublishers.setBounds(0, 11, 244, 52);
		panel_1.add(searchPublishers);

		JButton userComics = new JButton("My Comics");
		Properties.setMainButtonProperties(userComics);
		userComics.setModel(new FixedStateButtonModel());
		userComics.setBackground(new Color(3, 66, 80));
		userComics.setBounds(0, 125, 244, 52);
		panel_1.add(userComics);

		JButton searchComics = new JButton("Search Comics");
		Properties.setMainButtonProperties(searchComics);
		searchComics.setModel(new FixedStateButtonModel());
		searchComics.setBackground(new Color(3, 66, 80));
		searchComics.setBounds(0, 68, 244, 52);
		panel_1.add(searchComics);

		JButton accountButton = new JButton("Account");
		Properties.setMainButtonProperties(accountButton);
		accountButton.setModel(new FixedStateButtonModel());
		accountButton.setBackground(new Color(3, 66, 80));
		accountButton.setBounds(0, 182, 244, 52);
		panel_1.add(accountButton);

		JButton signOut = new JButton("Sign Out");
		Properties.setMainButtonProperties(signOut);
		signOut.setModel(new FixedStateButtonModel());
		signOut.setBackground(new Color(3, 66, 80));
		signOut.setBounds(0, 725, 244, 52);
		panel_1.add(signOut);

		// search Series Search pane
		JScrollPane searchSeriesScroll = new JScrollPane();
		searchSeriesScroll.setBorder(emptyBorder);
		Properties.setPanelProperties(searchSeriesScroll);
		searchSeriesScroll.getViewport().setBackground(new Color(38, 38, 38));
		searchComicsPanel.add(searchSeriesScroll);

		// search series comic pane
		JScrollPane searchSeriesScroll2 = new JScrollPane();
		searchSeriesScroll2.setBorder(emptyBorder);
		Properties.setPanelProperties(searchSeriesScroll2);
		searchSeriesScroll2.getViewport().setBackground(new Color(38, 38, 38));
		searchComicsPanel.add(searchSeriesScroll2);

		// publisher pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(emptyBorder);
		Properties.setPanelProperties(scrollPane);
		scrollPane.getViewport().setBackground(new Color(38, 38, 38));
		searchPublishersPanel.add(scrollPane);

		// series pane
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(emptyBorder);
		Properties.setPanelProperties(scrollPane2);
		scrollPane2.getViewport().setBackground(new Color(38, 38, 38));
		searchPublishersPanel.add(scrollPane2);

		// comics pane
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBorder(emptyBorder);
		Properties.setPanelProperties(scrollPane3);
		scrollPane3.getViewport().setBackground(new Color(38, 38, 38));
		searchPublishersPanel.add(scrollPane3);

		JButton seriesBackBtn = new JButton("Back");
		Properties.setLoginButtonProperties(seriesBackBtn, 100, 110, 89, 20);

		JButton backBtn = new JButton("Back");
		Properties.setLoginButtonProperties(backBtn, 100, 110, 89, 20);

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

		// Action Listeners
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panel_2, "Account Panel");
				accountButton.setBackground(new Color(23, 23, 23));
				userComics.setBackground(new Color(3, 66, 80));
				searchComics.setBackground(new Color(3, 66, 80));
				searchPublishers.setBackground(new Color(3, 66, 80));
			}
		});
		userComics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panel_2, "My Comics Panel");
				userComics.setBackground(new Color(23, 23, 23));
				accountButton.setBackground(new Color(3, 66, 80));
				searchComics.setBackground(new Color(3, 66, 80));
				searchPublishers.setBackground(new Color(3, 66, 80));
				UserCollection userCollectionPanel = new UserCollection();
				myComicsPanel.add(userCollectionPanel);

			}
		});
		searchComics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panel_2, "Search Comics Panel");
				searchComics.setBackground(new Color(23, 23, 23));
				userComics.setBackground(new Color(3, 66, 80));
				accountButton.setBackground(new Color(3, 66, 80));
				searchPublishers.setBackground(new Color(3, 66, 80));
			}
		});
		searchPublishers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panel_2, "Search Publisher Panel");
				searchPublishers.setBackground(new Color(23, 23, 23));
				accountButton.setBackground(new Color(3, 66, 80));
				searchComics.setBackground(new Color(3, 66, 80));
				userComics.setBackground(new Color(3, 66, 80));
			}
		});

		signOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});

		seriesBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchSeriesScroll2.setViewportView(null);
				searchSeriesTable.setVisible(true);
				searchSeriesScroll.setViewportView(searchSeriesTable);
				clickSeriesSearchBtn(searchComicsPanel, getSeriesName, searchSeriesScroll, searchSeriesScroll2,
						searchSeriesTable, searchSeriesTable2, seriesBackBtn);
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

			}
		});

		// on search passes value of search text field to dbconnection it assigns values
		// to table from dbconnection and sets up buttons to move to series
		publisherSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickPubSearchBtn(searchPublishersPanel, getPublisherName, scrollPane, scrollPane2, scrollPane3,
						searchTable, backBtn);

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
		int row = searchSeriesTable.rowAtPoint(e.getPoint());
		int col = searchSeriesTable.columnAtPoint(e.getPoint());
		if (row >= 0 && col == 0) {
			// Get the value of the 4th column of the selected row
			String selectedValue = (String) searchSeriesTable.getValueAt(row, 4);
			LoginInfo.setIdView(selectedValue);
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
			searchComicsPanel.add(seriesBackBtn);
			String selectedValue = (String) searchSeriesTable.getValueAt(row, 3);
			String selectedName = (String) searchSeriesTable.getValueAt(row, 2);
			LoginInfo.setPublisherID(pubID);
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
			searchPublishersPanel.add(backBtn);
			String selectedValue = (String) searchTable.getValueAt(row, 3);
			String selectedName = (String) searchTable.getValueAt(row, 2);
			LoginInfo.setPublisherName(selectedName);
			LoginInfo.setPublisherID(selectedValue);
			LoginInfo.setIdEnter(selectedValue);
			DBConnection.pullSeries(selectedValue);
			// enter starts here
			scrollPane.setVisible(false);
			scrollPane2.setVisible(true);
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
			data[i][2] = queriedSeries.get(i).get("name");
			data[i][0] = "View";
			data[i][1] = "Enter";
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
		searchComicsPanel.remove(seriesBackBtn);
		searchSeriesScroll.setViewportView(searchSeriesTable);
	}

	private void clickPubSearchBtn(JPanel publisherSearchPanel, JTextField getPublisherName, JScrollPane scrollPane,
			JScrollPane scrollPane2, JScrollPane scrollPane3, JTable searchTable, JButton backBtn) {
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
			data[i][2] = queriedPublisher.get(i).get("name");
			data[i][0] = "View";
			data[i][1] = "Enter";
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