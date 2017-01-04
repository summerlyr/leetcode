import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		help(nums, res, 0);
		return res;
	}

	public void help(int[] nums, List<List<Integer>> res, int start) {
		if (start == nums.length) {
			List<Integer> cur = new LinkedList<Integer>();
			for (int n : nums) {
				cur.add(n);
			}
			res.add(cur);
		} else {
			for (int i = start; i < nums.length; i++) {
				swap(nums, start, i);
				help(nums, res, start + 1);
				swap(nums, start, i);
			}
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if (nums.length == 0)
			return res;
		LinkedList<Integer> f = new LinkedList<Integer>();
		f.add(nums[0]);
		res.add(f);
		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> newres = new LinkedList<List<Integer>>();
			for (int j = 0; j <= i; j++) {
				for (List<Integer> l : res) {
					List<Integer> list = new LinkedList<Integer>(l);
					list.add(j, nums[i]);
					newres.add(list);
				}
			}
			res = newres;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations pt = new Permutations();
		int[] num = { 3, 3, 0, 0, 2, 3, 2 };
		System.out.println(pt.permute(num));
	}
}
