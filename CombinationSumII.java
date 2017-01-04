import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		// List<Integer> list = new LinkedList<Integer>();
		help(result, new LinkedList<Integer>(), 0, target, candidates);

		return result;
	}

	public void help(List<List<Integer>> result, List<Integer> list, int start, int target, int[] candidates) {

		if (target > 0) {
			for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
				if (i == start || candidates[i] != candidates[i - 1]) // ?
				{
					list.add(candidates[i]);
					help(result, list, i + 1, target - candidates[i], candidates);
					list.remove(list.size() - 1);
				}
			}
		} else if (target == 0) {
			result.add(new LinkedList<Integer>(list));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII cs = new CombinationSumII();
		int[] candidates = { 1, 1, 2 };
		System.out.println(cs.combinationSum2(candidates, 2));
	}

}
