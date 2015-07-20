import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InfoGUI extends JPanel {

	private JButton back;
	
	public InfoGUI() {
		back = new JButton("Back");
		setLayout(new GridLayout(0,10));
		add(new JTextField("Created By Nathan Anneken"));
		add(new JTextField("Version Number 1.0"));
		add(new JTextField("A Word Still In Progress"));
		add(back);
	}
	
	public JButton getButton() {
		return back;
	}
}
