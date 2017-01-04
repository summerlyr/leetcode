import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		help(res, nums, 0);
		return res;
	}

	public void help(List<List<Integer>> res, int[] nums, int start) {
		if (start == nums.length) {
			List<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			res.add(list);
		} else {
			Set<Integer> appeared = new HashSet<Integer>();
			for (int i = start; i < nums.length; i++) {
				if (appeared.add(nums[i])) {
					swap(nums, i, start);
					help(res, nums, start + 1);
					swap(nums, i, start);
				}
			}
		}

	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
