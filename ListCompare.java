import java.util.Comparator;
import java.util.List;

public class ListCompare implements Comparator<Object> {

	@SuppressWarnings("unchecked")
	public int compare(Object o1, Object o2) {

		List<Integer> list1 = (List<Integer>) o1;
		List<Integer> list2 = (List<Integer>) o2;
		int i = 0;
		while (list1.get(i) == list2.get(i)) {
			i++;
		}

		return list1.get(i) <= list2.get(i) ? 0 : 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
