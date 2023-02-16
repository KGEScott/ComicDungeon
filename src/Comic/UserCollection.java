package Comic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserCollection extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3958530647054231387L;

	public UserCollection() {

		ToolTipManager.sharedInstance().setEnabled(false);

		setBackground(new Color(38, 38, 38));
		setLayout(null);
		setBounds(0, 0, 897, 739);

		JPanel myCollection = new JPanel();
		myCollection.isFocusable();
		myCollection.setBounds(0, 21, 897, 718);
		myCollection.setBackground(new Color(38, 38, 38));
		add(myCollection);
		// tabbedPane.addTab("My Collection", null, myCollection, null);

		JPanel comicsPanel = new JPanel(new GridLayout(0, 4));
		comicsPanel.setBackground(new Color(128, 128, 128));
		comicsPanel.setBounds(193, 6, 698, 701);
		comicsPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		// Add the comicsPanel to a JScrollPane to enable scrolling
		JScrollPane scrollPane = new JScrollPane(comicsPanel);
		scrollPane.setBounds(193, 6, 698, 701);

		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		int scrollUnitIncrement = 20; // Set the amount of pixels to scroll for each scroll unit increment
		verticalScrollBar.setUnitIncrement(scrollUnitIncrement); // Set the scrolling unit increment

		myCollection.add(scrollPane);

		JPanel seriesPanel = new JPanel();
		seriesPanel.setLayout(new BoxLayout(seriesPanel, BoxLayout.Y_AXIS));
		seriesPanel.setBackground(new Color(128, 128, 128));
		seriesPanel.setBounds(6, 42, 180, 665);
		myCollection.add(seriesPanel);

		JButton btnRetrieveColl = new JButton("Retrieve Collection");
		Properties.setLoginButtonProperties(btnRetrieveColl, 6, 9, 180, 28);
		// btnRetrieveColl.setBounds(6, 9, 180, 28);
		btnRetrieveColl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map<String, String>> collection = DBConnection.pullCollection(LoginInfo.getUserID());
				seriesPanel.removeAll(); // Remove all components from the panel

				Set<String> seriesNames = new HashSet<>();

				// Collect series names from the collection
				for (Map<String, String> comic : collection) {
					String seriesName = comic.get("series_name");
					seriesNames.add(seriesName);
				}

				for (String seriesName : seriesNames) {
					JLabel seriesLabel = new JLabel(seriesName);
					seriesLabel.setPreferredSize(new Dimension(1, 1));
					if (seriesName.equals("1")) {
						seriesPanel.add(seriesLabel, 0); // add to top
					} else {
						seriesPanel.add(seriesLabel); // add below
					}
					seriesLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							comicsPanel.removeAll();
							// Loop through collection to find comics for selected series
							for (Map<String, String> comic : collection) {
								if (comic.get("series_name").equals(seriesName)) {
									String coverUrl = comic.get("cover");
									ImageIcon icon = null;
									if (coverUrl != null && !coverUrl.isEmpty() && !coverUrl.equals("no image")) {
										try {
											icon = new ImageIcon(new URL(coverUrl));
											BufferedImage img = new BufferedImage(icon.getIconWidth(),
													icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
											img.getGraphics().drawImage(icon.getImage(), 0, 0, null);
											Image scaledImage = img.getScaledInstance(125, 189, Image.SCALE_SMOOTH);
											icon = new ImageIcon(scaledImage);
										} catch (MalformedURLException e1) {
											e1.printStackTrace();
										}
									}
									JPanel comicPanel = new JPanel();
									comicPanel.setLayout(new BoxLayout(comicPanel, BoxLayout.Y_AXIS));
									if (icon != null) {
										JLabel coverLabel = new JLabel(icon);
										comicPanel.add(coverLabel);
										coverLabel.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent e) {
												LoginInfo.setComicsID(comic.get("comic_id"));
												LoginInfo.setSeriesName(comic.get("series_name"));
												LoginInfo.setPublisherName(comic.get("publisher_name"));
												ComicInfo.main(null);
											}
										});
									} else {
										JPanel noImagePanel = new JPanel();

										noImagePanel.setPreferredSize(new Dimension(125, 189));
										noImagePanel.setBackground(new Color(128, 128, 128));
										JLabel noImageLabel = new JLabel("No Image");
										noImageLabel.setPreferredSize(new Dimension(125, 189));
										noImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
										noImageLabel.setVerticalAlignment(SwingConstants.CENTER);
										noImagePanel.add(noImageLabel);
										noImagePanel.setAlignmentX(Component.LEFT_ALIGNMENT); // set alignment to left
										comicPanel.add(noImagePanel);
										noImagePanel.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent e) {
												LoginInfo.setComicsID(comic.get("comic_id"));
												LoginInfo.setSeriesName(comic.get("series_name"));
												LoginInfo.setPublisherName(comic.get("publisher_name"));
												ComicInfo.main(null);
											}
										});
									}
									// Add publisher name
									JLabel publisherLabel = new JLabel(
											"Publisher Name: " + comic.get("publisher_name"));
									publisherLabel.setBackground(new Color(128, 128, 128));
									publisherLabel.setOpaque(true); // make label background opaque
									comicPanel.add(publisherLabel);

									// Add series name
									JLabel seriesLabel = new JLabel(
											"<html>Series Name: <br>" + comic.get("series_name") + "</html>");
									seriesLabel.setBackground(new Color(128, 128, 128));
									seriesLabel.setOpaque(true); // make label background opaque
									comicPanel.add(seriesLabel);

									// Add issue number
									JLabel issueLabel = new JLabel(
											"<html>Issue Number: " + comic.get("number") + "<br><br></html>");
									issueLabel.setBackground(new Color(128, 128, 128));
									issueLabel.setOpaque(true); // make label background opaque
									comicPanel.add(issueLabel);

									comicPanel.setBackground(new Color(128, 128, 128)); // set panel background color
									comicsPanel.add(comicPanel);
								}
							}
							// Refresh the panel to reflect the changes
							comicsPanel.revalidate();
							comicsPanel.repaint();
						}
					});
				}

				// Refresh the panel to reflect the changes
				seriesPanel.revalidate();
				seriesPanel.repaint();
			}
		});
		myCollection.setLayout(null);
		myCollection.add(btnRetrieveColl);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(78, 78, 78));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBounds(0, 0, 897, 21);
		add(toolBar);

		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);

		JMenu export = new JMenu("Export");
		export.setOpaque(true);
		export.setFocusable(false);
		// export.setBorder(BorderFactory.createEtchedBorder());
		export.setBackground(new Color(150, 150, 150));
		export.setForeground(Color.BLACK);
		menuBar.add(export);

		JMenuItem exportMyCollection = new JMenuItem("Export My Collection to CSV");
		export.add(exportMyCollection);

		exportMyCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Export Collection");

				// Set default file name and extension
				String fileName = "my_collection.csv";
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files (*.csv)", "csv");
				fileChooser.setFileFilter(filter);
				fileChooser.setSelectedFile(new File(fileName));

				int userSelection = fileChooser.showSaveDialog(UserCollection.this);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();

					try {
						FileWriter writer = new FileWriter(fileToSave);
						// Write CSV header
						writer.append("Publisher Name , Series Name, Issue Number\n");

						// Retrieve data to write to CSV
						List<Map<String, String>> collection = DBConnection.pullCollection(LoginInfo.getUserID());

						// Write CSV data
						for (Map<String, String> comic : collection) {
							writer.append(comic.get("publisher_name"));
							writer.append(",");
							writer.append(comic.get("series_name"));
							writer.append(",");
							writer.append(comic.get("number"));
							writer.append("\n");
						}

						writer.flush();
						writer.close();

						// Show a message to the user
						JOptionPane.showMessageDialog(UserCollection.this,
								"Collection exported to " + fileToSave.getAbsolutePath(), "Export Successful",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

//		exportNeededCollection.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fileChooser = new JFileChooser();
//				int returnVal = fileChooser.showSaveDialog(UserCollection.this);
//				if (returnVal == JFileChooser.APPROVE_OPTION) {
//					File file = fileChooser.getSelectedFile();
//					// Perform the export to CSV operation here and save the file to the selected
//					// location
//				}
//			}
//		});
	}
}