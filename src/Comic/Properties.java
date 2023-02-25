package Comic;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Properties extends Login {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5632890641758781353L;
	private static Border emptyBorder;

	static void setTableProperties(JTable table) {
		UIManager.put("Table.select", new Color(21, 56, 70));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(56, 56, 56));
		table.getTableHeader().setForeground(new Color(192, 192, 192));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.setSelectionBackground(new Color(23, 23, 23));
		table.setSelectionForeground(Color.WHITE);
		table.setBorder(new LineBorder(new Color(78, 78, 78), 2));
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		table.setBackground(new Color(56, 56, 56));
		table.setForeground(new Color(192, 192, 192));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBounds(0, 0, 800, 900);
	}

	static void setPanelProperties(JScrollPane scrollPane) {
		emptyBorder = BorderFactory.createEmptyBorder();
		scrollPane.setBorder(emptyBorder);
		scrollPane.setVisible(false);
		scrollPane.setBackground(new Color(56, 56, 56));
		scrollPane.setBounds(0, 0, 900, 800);
	}

	static void setMainButtonProperties(JButton button) {
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button.setFocusable(false);
		button.setBorder(emptyBorder);
		button.setForeground(new Color(192, 192, 192));
	}

	static void setLoginButtonProperties(JButton button, int x, int y, int w, int h) {
		UIManager.put("Button.select", new Color(21, 56, 70));
		button.setBorder(emptyBorder);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setFocusable(false);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setBackground(new Color(85, 85, 85));
		button.setBounds(x, y, w, h);
	}

	static void setLoginTextProperties(JTextArea textArea, String string) {
		textArea.setText(string);
		textArea.setBorder(emptyBorder);
		textArea.setForeground(new Color(108, 108, 108));
		textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		textArea.setFocusable(false);
		textArea.setColumns(15);
		textArea.setBackground(new Color(3, 66, 80));
	}

	static void setLoginTextFieldProperties(JTextField textField) {
		textField.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		textField.setBorder(emptyBorder);
		textField.setForeground(Color.WHITE);
		textField.setColumns(17);
		textField.setBackground(new Color(73, 73, 73));
	}
}
