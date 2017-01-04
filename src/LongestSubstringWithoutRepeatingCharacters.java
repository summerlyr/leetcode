import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public int lengthOfLongestSubstring2(String s) {
		int i = 0;
		int j = 0;
		int max = 0;
		Set<Character> set = new HashSet<Character>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}

	public int lengthOfLongestSubstring3(String s) {
		int max = 0;
		int start = 0;
		int curlen = 0;
		int[] indics = new int[256];
		Arrays.fill(indics, -1);
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (indics[curr] < start) {
				curlen++;
			} else {
				start = indics[curr] + 1;
				curlen = i - start + 1;
			}
			indics[curr] = i;
			max = Math.max(max, curlen);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
	}

}
