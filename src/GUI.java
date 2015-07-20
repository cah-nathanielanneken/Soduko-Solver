import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JPanel {

	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private JLabel title;
	private JTextField[][] inputs;
	private JButton solve, clear, back;
	private SolveButtonHandler sHandler;
	private clearButtonHandler cHandler;
	private JPanel frame;

	public GUI() {
		title = new JLabel("Soduko Solver");
		Font f = new Font("Veranda", Font.BOLD, 40);
		Font f3 = new Font("Veranda", Font.BOLD, 15);
		title.setFont(f);
		inputs = new JTextField[9][9];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				inputs[x][y] = new JTextField(1);
				inputs[x][y].setHorizontalAlignment(JTextField.CENTER);
				inputs[x][y].setFont(f3);
			}
		}

		Font f2 = new Font("Veranda", Font.BOLD, 15);
		solve = new JButton("Solve");
		solve.setFont(f2);
		sHandler = new SolveButtonHandler();
		solve.addActionListener(sHandler);
		clear = new JButton("Clear");
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
		bottom.add(solve);
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
			ArrayList<FinalPuzzleSolution> arrayPuzzle = new ArrayList<FinalPuzzleSolution>();
			int[][] a = new int[9][9];
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					if (inputs[y][x].getText().equals(""))
						a[y][x] = 0;
					else
						a[y][x] = Integer.parseInt(inputs[y][x].getText());
				}
			}
			FinalPuzzleSolution f = new FinalPuzzleSolution(a);
			Solver s = new Solver();
			arrayPuzzle = s.Solve(f,1);
			if (arrayPuzzle.size() == 0) {
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
						inputs[y][x].setText("");
					}
				}
				JOptionPane.showMessageDialog(null, "Puzzle has no Solution!",
						"WARNING", JOptionPane.WARNING_MESSAGE);
			} else {
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
						inputs[y][x].setText(""
								+ arrayPuzzle.get(0).getArray()[y][x]);
					}
				}
			}
		}
	}

	public class clearButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					inputs[y][x].setText("");
				}
			}
		}
	}

//	public static void main(String[] args) {
//		new GUI();
//	}
}