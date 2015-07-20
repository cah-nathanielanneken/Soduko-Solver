import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GeneratorGUI extends JPanel {

	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private JLabel title;
	private JTextField[][] inputs;
	private JButton checkAnswer, clear, back;
	private SolveButtonHandler sHandler;
	private clearButtonHandler cHandler;
	private JPanel frame;

	public GeneratorGUI() {
		title = new JLabel("Soduko Puzzle");
		Font f = new Font("Veranda", Font.BOLD, 40);
		title.setFont(f);
		inputs = new JTextField[9][9];
		Font f3 = new Font("Veranda", Font.BOLD, 15);
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				inputs[x][y] = new JTextField(1);
				inputs[x][y].setHorizontalAlignment(JTextField.CENTER);
				inputs[x][y].setFont(f3);
			}
		}
		setGrid();

		Font f2 = new Font("Veranda", Font.BOLD, 15);
		checkAnswer = new JButton("Check Answer");
		checkAnswer.setFont(f2);
		sHandler = new SolveButtonHandler();
		checkAnswer.addActionListener(sHandler);
		clear = new JButton("New Puzzle");
		clear.setFont(f2);
		cHandler = new clearButtonHandler();
		clear.addActionListener(cHandler);
		back = new JButton("Back");
		back.setFont(f2);

		frame = new JPanel();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(new BorderLayout());
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0, 9));
		center.setBackground(Color.black);
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		top.setBackground(Color.LIGHT_GRAY);
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 0));

		top.add(title, SwingConstants.CENTER);
		bottom.add(checkAnswer);
		bottom.add(clear);
		bottom.add(back);
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				center.add(inputs[y][x]);
			}
		}
		frame.add(top, BorderLayout.NORTH);
		frame.add(center, BorderLayout.CENTER);
		frame.add(bottom, BorderLayout.SOUTH);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	public JPanel getFrame() {
		return frame;
	}
	
	public JButton getBack() {
		return back;
	}
	

	public class SolveButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Generator g = new Generator(1);
			int[][] a = new int[9][9];
			
		}
	}

	public class clearButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
				
		}
	}
	
	private void setGrid() {
		Generator g = new Generator(1);
		int[][] a = new int[9][9];
		g.trimPuzzle();
		FinalPuzzleSolution f = g.getPuzzle();
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if(f.getValue(y, x) == 0) {
					inputs[y][x].setText("");
				}
				else {
					inputs[y][x].setText(""+f.getValue(y,x));
				}
			}
		}
		
	}

}

