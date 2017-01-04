import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {

	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> resultt = new HashSet<List<Integer>>();
		for (int i = 0; i < num.length; i++) {
			int a = num[i];
			for (int j = i + 1, k = num.length - 1; j < k;) {
				int b = num[j];
				int c = num[k];
				if (b + c == -1 * a) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(a);
					list.add(b);
					list.add(c);
					resultt.add(list);
					j++;
					k--;
				} else if (b + c < -1 * a) {
					j++;
				} else {
					k--;
				}
			}
		}

		for (List<Integer> list : resultt) {
			result.add(list);
		}
		return result;
	}

	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length <= 2)
			return result;
		Arrays.sort(nums);
		if (3 * nums[0] > 0 || 3 * nums[nums.length - 1] < 0)
			return result;// important!!!
		for (int i = 0; i < nums.length - 2; i++) {
			int a = nums[i];
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				int b = nums[low];
				int c = nums[high];
				if (a + b + c == 0) {
					result.add(Arrays.asList(a, b, c));
					low++;
					high--;
					while (low < high && nums[low] == nums[low - 1])
						low++;
					while (low < high && nums[high] == nums[high + 1])
						high--;
				} else if (a + b + c < 0) {
					low++;
					while (low < high && nums[low] == nums[low - 1])
						low++;
				} else {
					high--;
					while (low < high && nums[high] == nums[high + 1])
						high--;
				}
			}
			while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Sum3 sum = new Sum3();
		int[] num = { -1, -1, -1, 2 };
		System.out.println(sum.threeSum(num));

	}

}
