
import java.util.TreeSet;

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length <= 1)
			return false;
		if (k == 0)
			return false;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer floor = set.floor(nums[i] + t);
			Integer ceil = set.ceiling(nums[i] - t);
			if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
				return true;
			}
			set.add(nums[i]);
			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
