import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length <= 1)
			return false;
		if (k == 0)
			return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		if (nums.length <= 1)
			return false;
		if (k == 0)
			return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				set.remove(nums[i - k - 1]);
			if (!set.add(nums[i]))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
