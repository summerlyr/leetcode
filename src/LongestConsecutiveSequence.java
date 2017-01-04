import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		int maxLength = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : num) {
			set.add(i);
		}
		for (int n : num) {
			if (set.contains(n)) {
				int length = 1;
				int next = n - 1;
				while (set.contains(next)) {
					length++;
					set.remove(next);
					next--;
				}
				next = n + 1;
				while (set.contains(next)) {
					length++;
					set.remove(next);
					next++;
				}
				if (length > maxLength) {
					maxLength = length;
				}
			}

		}
		return maxLength;
	}

	public int longestConsecutive2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		for (int n : nums) {
			if (!map.containsKey(n)) {
				int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
				int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
				int sum = left + right + 1;
				res = Math.max(res, sum);
				map.put(n, sum);
				map.put(n - left, sum);
				map.put(n + right, sum);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
