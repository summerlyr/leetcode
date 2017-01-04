import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : num) {
			if (!map.containsKey(n)) {
				map.put(n, 1);
			} else {
				int i = (int) map.get(n);
				i++;
				map.put(n, i);
			}
			int value = map.get(n);
			if (value > num.length / 2) {
				return n;
			}
		}
		/*
		 * Iterator<Integer> iter = map.keySet().iterator(); int key = 0,value;
		 * while (iter.hasNext()) { key = iter.next(); value = map.get(key);
		 * if(value > num.length/2) { return key; } }
		 */
		return 0;
	}

	public int majorityElement2(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		return nums[n / 2];
	}

	public int majorityElement3(int[] nums) {
		int major = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}

		}
		return major;
	}

	public int majorityElement4(int[] nums) {
		int major = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;

			for (int j = 0; j < nums.length; j++) {

				if ((nums[j] & (1 << i)) != 0)
					count++;
				if (count > nums.length / 2) {
					major = major | (1 << i);
					break;
				}
			}

		}

		return major;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
