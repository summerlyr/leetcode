import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new LinkedList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Integer> tmp = new HashSet<Integer>();
		int l = nums.length / 3;
		for (int n : nums) {
			if (map.containsKey(n)) {
				int s = map.get(n);
				s++;
				if (s > l && !tmp.contains(n)) {
					tmp.add(n);
				}
				map.put(n, s);
			} else {
				map.put(n, 1);
				if (1 > l && !tmp.contains(n)) {
					tmp.add(n);
				}
			}
		}
		for (int n : tmp) {
			result.add(n);
		}
		return result;
	}

	public List<Integer> majorityElement2(int[] nums) {
		List<Integer> result = new LinkedList<Integer>();
		int y = 0, z = 1, cy = 0, cz = 0;
		for (int x : nums) {
			if (x == y) {
				cy++;
			} else if (x == z) {
				cz++;
			} else if (cy == 0) {
				y = x;
				cy++;
			} else if (cz == 0) {
				z = x;
				cz++;
			} else {
				cy--;
				cz--;
			}
		}
		cy = 0;
		cz = 0;
		for (int x : nums) {
			if (x == y)
				cy++;
			if (x == z)
				cz++;
		}
		if (cy > nums.length / 3)
			result.add(y);
		if (cz > nums.length / 3&& y!=z)
			result.add(z);

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
