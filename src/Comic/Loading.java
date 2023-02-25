package Comic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loading extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1807958079856758636L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		setBounds(0, 0, 75, 75);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		setBackground(new Color(0, 0, 0, 0)); // This sets the background color of the JInternalFrame to transparent

		JLabel loadImage = new JLabel();
		loadImage.setFocusable(false);
		loadImage.setOpaque(false);
		contentPane.add(loadImage);
		URL url = getClass().getResource("/Comic/Icons/load.gif");
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		loadImage.setIcon(new ImageIcon(img));
	}

	// Close the loading internal frame
	public void closeLoading() {
		dispose();
	}
}
