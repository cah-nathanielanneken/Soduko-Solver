import java.util.ArrayList;


public class Solver {

	private ArrayList<FinalPuzzleSolution> arrayPuzzle;
	
	public Solver() {
		arrayPuzzle = new ArrayList<FinalPuzzleSolution>();
	}
	
	public void solution(FinalPuzzleSolution p, int numberOfSolutions) {
		FinalPuzzleSolution a = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution b = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution c = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution d = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution e = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution f = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution g = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution h = new FinalPuzzleSolution(p.getArray());
		FinalPuzzleSolution i = new FinalPuzzleSolution(p.getArray());

		if(arrayPuzzle.size()==numberOfSolutions)
			return;
		
		OuterLoop: for(int x=0; x<9; x++) {
			for(int y=0; y<9; y++) {
				if(a.getValue(y, x) == 0) {
					a.updateBox(y, x, 1);
					b.updateBox(y, x, 2);
					c.updateBox(y, x, 3);
					d.updateBox(y, x, 4);
					e.updateBox(y, x, 5);
					f.updateBox(y, x, 6);
					g.updateBox(y, x, 7);
					h.updateBox(y, x, 8);
					i.updateBox(y, x, 9);
					break OuterLoop;
				}
			}
		}
		
		if(a.isDone()) {
			this.arrayPuzzle.add(a);
		}
		else if(a.isValid())
			solution(a,numberOfSolutions);
		if(b.isDone())
			this.arrayPuzzle.add(b);
		else if(b.isValid()) 
			solution(b,numberOfSolutions);
		if(c.isDone())
			this.arrayPuzzle.add(c);
		else if(c.isValid())
			solution(c,numberOfSolutions);
		if(d.isDone())
			this.arrayPuzzle.add(d);
		else if(d.isValid())
			solution(d,numberOfSolutions);
		if(e.isDone())
			this.arrayPuzzle.add(e);
		else if(e.isValid())
			solution(e,numberOfSolutions);
		if(f.isDone())
			this.arrayPuzzle.add(f);
		else if(f.isValid())
			solution(f,numberOfSolutions);
		if(g.isDone())
			this.arrayPuzzle.add(g);
		else if(g.isValid())
			solution(g,numberOfSolutions);
		if(h.isDone())
			this.arrayPuzzle.add(h);
		else if(h.isValid())
			solution(h,numberOfSolutions);
		if(i.isDone())
			this.arrayPuzzle.add(i);
		else if(i.isValid())
			solution(i,numberOfSolutions);	
		
	}
	
	public ArrayList<FinalPuzzleSolution> Solve(FinalPuzzleSolution f, int numberOfSolutions) {
		solution(f, numberOfSolutions);
		return arrayPuzzle;
	}
}
