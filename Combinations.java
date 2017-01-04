import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		combine(result, new LinkedList<Integer>(), 1, n, k);
		return result;
	}

	public void combine(List<List<Integer>> result, LinkedList<Integer> list, int start, int n, int k) {
		if (k == 0) {
			result.add(new LinkedList<Integer>(list));
			return;
		}

		for (int i = start; i <= n; i++) {
			list.add(i);
			combine(result, list, i + 1, n, k - 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
