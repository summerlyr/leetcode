import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

	List<Integer> number = new LinkedList<Integer>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0)
			return null;
		Arrays.sort(candidates);
		for (int i : candidates) {
			number.add(i);
		}
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		help(result, list, target);
		return result;
	}

	public void help(List<List<Integer>> result, List<Integer> list, int target) {
		if (target == 0) {
			result.add(list);
			return;
		}
		if (target <= 0) {
			return;
		}
		for (int i : number) {
			if (list.size() > 0 && list.get(list.size() - 1) > i) {
				continue;
			}
			List<Integer> cur = new LinkedList<Integer>(list);
			cur.add(i);
			help(result, cur, target - i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum cs = new CombinationSum();
		int[] candidates = { 1, 2 };
		System.out.println(cs.combinationSum(candidates, 4));
	}

}
