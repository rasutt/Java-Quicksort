import java.util.ArrayList;
import java.util.Random;

// Sorting example for facebook group
public class JavaQuicksort {

	public static void main(String[] args) {
		String message = "Who else is doing CS220 and CS230?  This is an"
				+ "example of a java implementation of Quicksort, using"
				+ " composite classes";
		PairList pl = new PairList();
		PairList randList = new PairList();
		Random ran = new Random();
		int index;
		
		//make a list of letter-number pairs
		for (int i = 0; i < message.length(); i++) {
			pl.add(new Pair(message.charAt(i), i)); 
		}
		
		//make a new list in random order
		while (pl.getSize() != 0) {
			index = ran.nextInt(pl.getSize());
			randList.add(pl.get(index));
			pl.remove(index);
		}
		int l = 0;
		int r = randList.getSize() - 1;
		if (r > 1) {
			//System.out.println("right = " + right);
			randList.showList();
			randList.quickSort(l, r);
		}
		else {
			randList.showList();
		}
	}

}
