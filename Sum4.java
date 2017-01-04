import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return result;
		if (4 * nums[0] > 0 || 4 * nums[nums.length - 1] < 0)
			return result;
		if (nums.length < 4) {
			return result;
		}
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int b = nums[j];
				int front = j + 1;
				int back = nums.length - 1;
				while (front < back) {
					int c = nums[front];
					int d = nums[back];
					if (a + b + c + d < target) {
						front++;
					} else if (a + b + c + d > target) {
						back--;
					} else {
						List<Integer> list = new ArrayList<Integer>();
						list.add(a);
						list.add(b);
						list.add(c);
						list.add(d);
						result.add(list);
						front++;
						back--;
						while (front < back && nums[front] == nums[front - 1]) {
							front++;
						}
						while (front < back && nums[back] == nums[back + 1]) {
							back--;
						}
					}

				}
				while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
					j++;
				}
			}
			while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum4 s = new Sum4();
		int[] num = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		System.out.print(s.fourSum(num, target));
	}

}
