import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		int num = nums.length;
		int max = (int) Math.pow(2, num);
		for (int i = 0; i < max; i++) {
			List<Integer> current = new LinkedList<Integer>();
			int n = i;
			for (int j = 0; j < num; j++) {
				int m = (n >> j) & 1;
				if (m == 1) {
					current.add(nums[j]);
				}
			}
			result.add(current);
		}

		return result;
	}

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int n = result.size();
			for (int j = 0; j < n; j++) {
				List<Integer> cur = new ArrayList<Integer>(result.get(j));
				cur.add(nums[i]);
				result.add(cur);
			}
		}
		return result;
	}

	public List<List<Integer>> subsets3(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		Arrays.sort(nums);
		help(nums, 0, result, cur);
		return result;
	}

	public void help(int[] nums, int start, List<List<Integer>> result, List<Integer> cur) {
		result.add(new ArrayList<Integer>(cur));
		for (int i = start; i < nums.length; i++) {
			cur.add(nums[i]);
			help(nums, i + 1, result, cur);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = { 1, 2, 3 };
		System.out.println(s.subsets(nums));

	}

}
