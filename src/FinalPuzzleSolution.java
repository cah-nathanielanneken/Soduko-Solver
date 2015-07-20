
public class FinalPuzzleSolution {

	private int[][] puzzle;
	
	public FinalPuzzleSolution(int[][] puzzle) {
		this.puzzle = new int[9][9];
		for(int x=0; x<9; x++) {
			for(int y=0; y<9; y++) {
				this.puzzle[x][y] = puzzle[x][y];
			}
		}
	}
	
	public void updateBox(int x, int y, int value) {
		puzzle[x][y] = value;
	}
	
	public boolean isDone() {
		for(int x=0; x<9; x++) {
			for(int y=0; y<9; y++) {
				if(puzzle[x][y] == 0)
					return false;
			}
		}
		if(isValid())
			return true;
		else
			return false;
	}
	
	public int[][] getArray() {
		return puzzle;
	}
	public int getValue(int x, int y) {
		return puzzle[x][y];
	}
	
	private boolean rowCheck(int row) {
		for(int x=0; x<9; x++) {
			for(int y=x+1; y<9; y++) {
				if((puzzle[x][row] == puzzle[y][row]) && puzzle[x][row]!=0) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	private boolean columnCheck(int column) {
		for(int x=0; x<9; x++) {
			for(int y=x+1; y<9; y++) {
				if((puzzle[column][x] == puzzle[column][y]) && puzzle[column][x]!=0)
					return false;
			}
		}
		return true;
	}
	
	private boolean boxCheck(int boxNumber) {
		int z=0;
		int[] array = new int[9];
		if(boxNumber == 1) {
			for(int a=0; a<3; a++) {
				for(int b=0; b<3; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 2) {
			for(int a=0; a<3; a++) {
				for(int b=3; b<6; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 3) {
			for(int a=0; a<3; a++) {
				for(int b=6; b<9; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 4) {
			for(int a=3; a<6; a++) {
				for(int b=0; b<3; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 5) {
			for(int a=3; a<6; a++) {
				for(int b=3; b<6; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 6) {
			for(int a=3; a<6; a++) {
				for(int b=6; b<9; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 7) {
			for(int a=6; a<9; a++) {
				for(int b=0; b<3; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 8) {
			for(int a=6; a<9; a++) {
				for(int b=3; b<6; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		if(boxNumber == 9) {
			for(int a=6; a<9; a++) {
				for(int b=6; b<9; b++) {
					array[z] = puzzle[b][a];
					z++;
				}
			}
		}
		for(int x=0; x<9; x++) {
			for(int y=x+1; y<9; y++) {
				if((array[x] == array[y]) && array[x]!=0)
					return false;
			}
		}
		return true;
	}
	
	public boolean isValid() {
		for(int x=0; x<9; x++) {
			if(!rowCheck(x) || !columnCheck(x) || !boxCheck(x))
				return false;
		}
		return true;
	}
	
	public String toString() {
		String s ="";
		for(int x=0; x<9; x++) {
			for(int y=0; y<9; y++) {
				s += puzzle[y][x]+"|";
			}
			s += "\n------------------\n";
		}
		return s;
	}
}
