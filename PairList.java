import java.util.ArrayList;

public class PairList {
	private ArrayList<Pair> al;
	
	public PairList(){
		al = new ArrayList<Pair>();
	}
	
	public void add(Pair p){
		al.add(p); 
	}
	
	public Pair get(int index) {
		return al.get(index);
	}
	
	public int getSize() {
		return al.size();
	}
	
	public void remove(int index) {
		al.remove(index);
	}
	
	// Sort list with Quicksort algorithm showing data moves
	public void quickSort(int l, int r) {
		// Save the start and end points
		int s = l;
		int e = r;
		
		int pivotpos;
		Pair temp = null;

		/* Find median of three values to set pivot if list larger than
		5 items and move it to the end */
		if (e - s > 5) {
			pivotpos = setPivotPosToMedian(e, s);
			temp = al.get(e);
			al.set(e, al.get(pivotpos));
			al.set(pivotpos, temp);
			/*temp = al.get(pivotpos);
			al.remove(pivotpos);
			al.add(temp); This doesn't work for some reason */
		}
		
		// Set the pivot for Quicksort
		pivotpos = r;
		r = r - 1;
		boolean pplaced = false;
		
		/* Find and swap numbers that are disordered w.r.t. the pivot until 
		 * the left and right side indices meet */
		while (l < r) {	
			
			/* Move left side index until the value at its position is 
			 * greater than the pivot or it reaches the right side index */
			while (al.get(l).getNumber() < al.get(pivotpos).getNumber() 
					&& l < r) {
				l++;
			}
			
			/* Move right side index r while the value at its position is 
			 * greater than the pivot and it hasn't reached left side 
			 * index */
			while (al.get(r).getNumber() > al.get(pivotpos).getNumber() 
					&& l < r){
				r--;
			}
			
			/* Swap numbers at left and right side indices to correct order 
			 * w.r.t. pivot */
			if (l < r) {
				temp = al.get(l);
				al.set(l, al.get(r));
				al.set(r, temp);
				showList();
			}
		}
		
		// Place pivot
		if (al.get(l).getNumber() > al.get(e).getNumber()) {
			temp = al.get(l);
			al.set(l, al.get(e));
			al.set(e, temp);
			showList();
			pplaced = true;
		}
		
		// Recursively sort sublists if more than one element
		if (pplaced) {
			if (l - 1 > s) {
				quickSort(s, l - 1);
			}
			if (l + 1 < e) {
				quickSort(l + 1, e);
			}
		}
		else {
			if (pivotpos - 1 > s) {
				quickSort(s, pivotpos - 1);
			}	
		}
	}
	
	// Print the list and move to the next line
	public void showList() {
		for (Pair p : al) {
			System.out.print(p.getLetter());
		}
		System.out.println();
	}
	
	public int setPivotPosToMedian(int e, int s) {
		int pivotpos;
		if (al.get(s).getNumber() < al.get(e).getNumber()){
			if (al.get(s).getNumber() < al.get((s + e) / 2).getNumber()){
				if (al.get((s + e) / 2).getNumber() < 
						al.get(e).getNumber()) {
					pivotpos = (s + e) / 2;
				}
				else {
					pivotpos = e;
				}
			}
			else {
				pivotpos = s;
			}
		}
		else {
			if (al.get(s).getNumber() > al.get((s + e) / 2).getNumber()){
				if (al.get((s + e) / 2).getNumber() > 
						al.get(e).getNumber()) {
					pivotpos = (s + e) / 2;
				}
				else {
					pivotpos = e;
				}
			}
			else {
				pivotpos = s;
			}
		}
		return pivotpos;
	}
}
