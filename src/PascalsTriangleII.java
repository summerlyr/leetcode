import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public List<Integer> getRow(int rowIndex) {
		/*
		 * ArrayList<ArrayList<Integer>> res = new ArrayList();
		 * ArrayList<Integer> list = new ArrayList(); int numRows = rowIndex+1;
		 * list.add(1); res.add(list); while(--numRows>0) { ArrayList<Integer>
		 * newlist = new ArrayList(); newlist.add(1); for(int
		 * i=1;i<list.size();i++) newlist.add(list.get(i)+list.get(i-1));
		 * newlist.add(1); res.add(newlist); list = newlist; } return
		 * res.get(rowIndex);
		 */

		/*
		 * ArrayList<Integer> list = new ArrayList();
		 * for(int i=1;i<rowIndex+1;i++) { double l = list.get(i-1); double ll =
		 * i-1;
		 * 
		 * double res = l*(rowIndex-ll)/(ll+1);
		 * 
		 * list.add((int)res);
		 * 
		 * }
		 * 
		 * return list;
		 */

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;

	}

	public static void main(String[] args) {
	}

}
