package Comic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public class UserCollection extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3958530647054231387L;

	public UserCollection() {

		setBackground(new Color(38, 38, 38));
		setLayout(null);
		setBounds(0, 0, 897, 739);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 21, 897, 718);
		add(tabbedPane);

		tabbedPane.setBounds(0, 21, 897, 718);
		add(tabbedPane);

		JPanel myCollection = new JPanel();
		myCollection.isFocusable();
		myCollection.setBackground(new Color(38, 38, 38));
		tabbedPane.addTab("My Collection", null, myCollection, null);

		JPanel neededCollection = new JPanel();
		neededCollection.isFocusable();
		neededCollection.setBackground(new Color(38, 38, 38));
		tabbedPane.addTab("Needed Collection", null, neededCollection, null);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(78, 78, 78));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBounds(0, 0, 897, 21);
		add(toolBar);

		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);

		JMenu export = new JMenu("Export");
		menuBar.add(export);

		JMenuItem exportMyCollection = new JMenuItem("Export My Collection to CSV");
		export.add(exportMyCollection);

		JMenuItem exportNeededCollection = new JMenuItem("Export Needed Collection to CSV");
		export.add(exportNeededCollection);

		exportMyCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showSaveDialog(UserCollection.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// Perform the export to CSV operation here and save the file to the selected
					// location
				}
			}
		});

		exportNeededCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showSaveDialog(UserCollection.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// Perform the export to CSV operation here and save the file to the selected
					// location
				}
			}
		});
	}

}