
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

	List<Integer> number = new LinkedList<Integer>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		if (k == 0)
			return null;
		for (int i = 1; i <= 9; i++) {
			number.add(i);
		}
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		help(result, list, 0, k, n);

		return result;
	}

	public void help(List<List<Integer>> result, List<Integer> list, int start, int k, int target) {
		if (target == 0) {
			if (list.size() == k) {
				result.add(list);
			}
			return;
		}
		if (target < 0) {
			return;
		}
		for (int m = start; m < number.size(); m++) {
			int i = number.get(m);
			if (list.size() > 0 && list.get(list.size() - 1) >= i)
				continue;
			List<Integer> cur = new LinkedList<Integer>(list);
			cur.add(i);
			help(result, cur, start + 1, k, target - i);
		}
	}

	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		System.out.println(cs.combinationSum3(3, 9));
	}

}
