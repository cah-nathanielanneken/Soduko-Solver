import java.util.ArrayList;


public class Generator {

	private FinalPuzzleSolution puzzle;
	private int difficulty;
	
	public Generator(int difficulty) {
		ArrayList<FinalPuzzleSolution> array = new ArrayList<FinalPuzzleSolution>();
		puzzle = new FinalPuzzleSolution(new int[9][9]);
		this.difficulty = difficulty;
		Solver s = new Solver();
		array = s.Solve(puzzle, 1000);
		int puzzleNumber;
		puzzleNumber = (int)(Math.random()*1000);
		puzzle = array.get(puzzleNumber);
	}
	
	public void trimPuzzle() {
		int numberOfBoxes = (int)(Math.random()*100);
		for(int a =0; a<numberOfBoxes; a++) {
			int columnP = (int)(Math.random()*9);
			int rowP = (int)(Math.random()*9);
			if(puzzle.getValue(columnP, rowP)!=0)
				puzzle.updateBox(columnP, rowP, 0);
			else
				a--;
		}
	}
	
	public FinalPuzzleSolution getPuzzle() {
		return puzzle;
	}
}
