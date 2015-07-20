import java.util.ArrayList;


public class Tester {

	public static void main(String [] args) {
		int[][] a = new int[9][9];
		ArrayList<FinalPuzzleSolution> b = new ArrayList<FinalPuzzleSolution>();
		for(int x=0; x<9; x++) {
			for(int y=0; y<9; y++) {
				a[y][x] = 0;
			}
		}
		a[2][0] = 5;
		a[3][0] = 3;
		a[4][0] = 2;
		a[1][1] = 2;
		a[3][1] = 8;
		a[5][1] = 1;
		a[0][2] = 6;
		a[4][2] = 9;
		a[2][3] = 9;
		a[7][3] = 5;
		a[1][4] = 5;
		a[6][4] = 7;
		a[8][4] = 6;
		a[0][5] = 3;
		a[7][5] = 9;
		a[8][5] = 4;
		a[0][6] = 2;
		a[4][6] = 1;
		a[5][6] = 7;
		a[6][6] = 4;
		a[3][7] = 4;
		a[8][7] = 7;
		a[2][8] = 1;
		a[5][8] = 5;
		a[6][8] = 3;
		a[7][8] = 6;




		
		FinalPuzzleSolution f = new FinalPuzzleSolution(a);
		Solver s = new Solver();
		b = s.Solve(f,1);
		System.out.println(b.get(0).toString());
	}
}
