import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// List<List<Integer>> result = new LinkedList<List<Integer>>();
		// //List<List<Integer>> last = new LinkedList<List<Integer>>();
		// Arrays.sort(nums);
		// int num = nums.length;
		// int max = (int) Math.pow(2, num);
		// for(int i=0;i<max;i++)
		// {
		// List<Integer> current = new LinkedList<Integer>();
		// int n = i;
		// for(int j=0;j<num;j++)
		// {
		// int m = (n>>j)&1;
		// if(m == 1)
		// {
		// current.add(nums[j]);
		// }
		// }
		// if(!result.contains(current))
		// {
		// result.add(current);
		// }
		//
		// }
		// return result;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> empty = new ArrayList<Integer>();
		result.add(empty);
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int dupCount = 0;
			while (((i + 1) < nums.length) && nums[i + 1] == nums[i]) {
				dupCount++;
				i++;
			}
			int prevNum = result.size();
			for (int j = 0; j < prevNum; j++) {
				List<Integer> element = new ArrayList<Integer>(result.get(j));
				for (int t = 0; t <= dupCount; t++) {
					element.add(nums[i]);
					result.add(new ArrayList<Integer>(element));
				}
			}
		}
		return result;
	}

	public List<List<Integer>> subsetsWithDup2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		Arrays.sort(nums);
		help(nums, 0, result, cur);
		return result;
	}

	public void help(int[] nums, int start, List<List<Integer>> result, List<Integer> cur) {
		result.add(new ArrayList<Integer>(cur));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			cur.add(nums[i]);
			help(nums, i + 1, result, cur);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] nums = { 1, 2, 2 };
		System.out.println(s.subsetsWithDup(nums));

	}

}
