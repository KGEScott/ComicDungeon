package Comic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.ToolTipManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserCollection extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3958530647054231387L;

	public UserCollection() {

		ToolTipManager.sharedInstance().setEnabled(false);

		setBackground(new Color(38, 38, 38));

		JPanel myCollection = new JPanel(new BorderLayout());
		myCollection.isFocusable();
		setLayout(new BorderLayout(0, 0));
		myCollection.setBackground(new Color(38, 38, 38));
		add(myCollection);

		JPanel seriesBackPanel = new JPanel(new BorderLayout());
		myCollection.add(seriesBackPanel, BorderLayout.WEST);

		JPanel toolBarPanel = new JPanel();
		toolBarPanel.setBorder(new LineBorder(new Color(38, 38, 38), 2, true));
		toolBarPanel.setBackground(new Color(128, 128, 128));
		myCollection.add(toolBarPanel, BorderLayout.NORTH);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(78, 78, 78));
		toolBar.setForeground(Color.WHITE);
		toolBarPanel.add(toolBar, BorderLayout.NORTH);

		Box toolBarBox = Box.createHorizontalBox();
		toolBar.add(toolBarBox);

		JMenuItem exportMyCollection = new JMenuItem("Export My Collection to CSV");
		exportMyCollection.setAlignmentX(Component.LEFT_ALIGNMENT);
		exportMyCollection.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		exportMyCollection.setOpaque(true);
		exportMyCollection.setFocusable(false);
		exportMyCollection.setBackground(new Color(150, 150, 150));
		exportMyCollection.setForeground(Color.BLACK);
		toolBarBox.add(exportMyCollection);

		toolBarBox.add(Box.createHorizontalGlue());

		JPanel comicsPanel = new JPanel(new GridLayout(0, 4));
		comicsPanel.setBackground(new Color(128, 128, 128));
		comicsPanel.setBounds(193, 6, 698, 701);
		comicsPanel.setAlignmentY(Component.TOP_ALIGNMENT);

		// Add the comicsPanel to a JScrollPane to enable scrolling
		JScrollPane scrollPane = new JScrollPane(comicsPanel);
		scrollPane.setBorder(new LineBorder(new Color(38, 38, 38), 2));
		scrollPane.setPreferredSize(new Dimension(1430, 740)); // Set preferred size of scrollPane to 700 x 500 pixels

		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		int scrollUnitIncrement = 20; // Set the amount of pixels to scroll for each scroll unit increment
		verticalScrollBar.setUnitIncrement(scrollUnitIncrement); // Set the scrolling unit increment
		myCollection.add(scrollPane, BorderLayout.CENTER);

		JPanel seriesPanel = new JPanel();
		seriesPanel.setLayout(new BoxLayout(seriesPanel, BoxLayout.Y_AXIS));
		seriesPanel.setBackground(new Color(128, 128, 128));

		// Add the comicsPanel to a JScrollPane to enable scrolling
		JScrollPane seriesScrollPane = new JScrollPane(seriesPanel);
		seriesScrollPane.setBorder(new LineBorder(new Color(38, 38, 38), 3, true));
		seriesScrollPane.setPreferredSize(new Dimension(300, 740)); // Set preferred size of scrollPane to 700 x 500
																	// pixels
		seriesBackPanel.add(seriesScrollPane, BorderLayout.CENTER);

		JButton btnRetrieveColl = new JButton("Retrieve Collection");
		Properties.setLoginButtonProperties(btnRetrieveColl, 6, 9, 180, 28);
		// btnRetrieveColl.setBounds(6, 9, 180, 28);
		seriesBackPanel.add(btnRetrieveColl, BorderLayout.NORTH);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Calculate number of columns based on width of UserCollection panel
				int width = UserCollection.this.getWidth();
				int numColumns = width / 400; // Change 200 to the width of a single comic panel

				// Set number of columns in GridLayout of comicsPanel
				GridLayout layout = (GridLayout) comicsPanel.getLayout();
				layout.setColumns(numColumns);

				// Repaint and revalidate the comicsPanel
				comicsPanel.revalidate();
				comicsPanel.repaint();
				scrollPane.revalidate();
				scrollPane.repaint();
			}
		});

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

		btnRetrieveColl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map<String, String>> collection = DBConnection.pullCollection(LoginInfo.getUserID());
				seriesPanel.removeAll(); // Remove all components from the panel

				Map<String, List<Map<String, String>>> comicsBySeriesId = new HashMap<>();

				// Group comics by series ID
				for (Map<String, String> comic : collection) {
					String seriesId = comic.get("series_id");
					List<Map<String, String>> comics = comicsBySeriesId.getOrDefault(seriesId, new ArrayList<>());
					comics.add(comic);
					comicsBySeriesId.put(seriesId, comics);
				}

				// Sort series names alphabetically
				List<String> seriesNames = new ArrayList<>(comicsBySeriesId.keySet());
				Collections.sort(seriesNames);

				// Display comics under the appropriate series name
				for (String seriesId : seriesNames) {
					List<Map<String, String>> comics = comicsBySeriesId.get(seriesId);

					String seriesName = comics.get(0).get("series_name");
					JLabel seriesLabel = new JLabel(seriesName);
					seriesLabel.setPreferredSize(new Dimension(1, 1));
					if (seriesId.equals("1")) {
						seriesPanel.add(seriesLabel, 0); // add to top
					} else {
						seriesPanel.add(seriesLabel); // add below
					}
					seriesLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
							comicsPanel.removeAll();
							// Loop through collection to find comics for selected series
							Collections.sort(comics, new Comparator<Map<String, String>>() {
								public int compare(Map<String, String> c1, Map<String, String> c2) {
									int issueNum1 = Integer.parseInt(c1.get("number").replaceAll("\\D+", ""));
									int issueNum2 = Integer.parseInt(c2.get("number").replaceAll("\\D+", ""));
									return Integer.compare(issueNum1, issueNum2);
								}
							});
							for (Map<String, String> comic : comics) {
								String coverUrl = comic.get("cover");
								ImageIcon icon = null;
								if (coverUrl != null && !coverUrl.isEmpty() && !coverUrl.equals("no image")) {
									try {
										icon = new ImageIcon(new URL(coverUrl));
										BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
												BufferedImage.TYPE_INT_RGB);
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
									coverLabel.setBorder(new LineBorder(new Color(38, 38, 38), 2, true));
									comicPanel.add(coverLabel);
									coverLabel.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

											SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
												@Override
												protected Void doInBackground() throws Exception {
													// Execute the ComicInfo window on a separate thread
													LoginInfo.setComicsID(comic.get("comic_id"));
													LoginInfo.setSeriesName(comic.get("series_name"));
													LoginInfo.setPublisherName(comic.get("publisher_name"));
													ComicInfo.main(null);
													return null;
												}

												@Override
												protected void done() {
													// Set the cursor back to the default cursor after the ComicInfo
													// window is loaded
													setCursor(Cursor.getDefaultCursor());
												}
											};
											worker.execute();
										}
									});
								} else {
									JPanel noImagePanel = new JPanel();
									Dimension preferredSize = new Dimension(125, 189);
									noImagePanel.setPreferredSize(preferredSize);
									noImagePanel.setMaximumSize(preferredSize);

									noImagePanel.setBackground(new Color(128, 128, 128));
									JLabel noImageLabel = new JLabel("No Image");
									noImageLabel.setPreferredSize(preferredSize);
									noImageLabel.setBorder(new LineBorder(new Color(38, 38, 38), 2, true));
									noImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
									noImageLabel.setVerticalAlignment(SwingConstants.CENTER);
									noImagePanel.add(noImageLabel);
									noImagePanel.setAlignmentX(Component.LEFT_ALIGNMENT); // set alignment to left
									comicPanel.add(noImagePanel);
									noImagePanel.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

											SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
												@Override
												protected Void doInBackground() throws Exception {
													// Execute the ComicInfo window on a separate thread
													LoginInfo.setComicsID(comic.get("comic_id"));
													LoginInfo.setSeriesName(comic.get("series_name"));
													LoginInfo.setPublisherName(comic.get("publisher_name"));
													ComicInfo.main(null);
													return null;
												}

												@Override
												protected void done() {
													// Set the cursor back to the default cursor after the ComicInfo
													// window is loaded
													setCursor(Cursor.getDefaultCursor());
												}
											};
											worker.execute();
										}
									});
								}
								// Add publisher name
								JLabel publisherLabel = new JLabel("Publisher Name: " + comic.get("publisher_name"));
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
							setCursor(Cursor.getDefaultCursor());
							// Refresh the panel to reflect the changes
							myCollection.revalidate();
							myCollection.repaint();
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
	}
}