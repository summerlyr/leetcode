import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < s.length(); i++) {
			String sub1 = s.substring(i, i + 1);
			String sub2 = t.substring(i, i + 1);
			if (map.containsKey(sub1)) {
				if (!map.get(sub1).equals(sub2)) {
					return false;
				}
			} else {
				if (map.containsValue(sub2)) {
					return false;
				} else {
					map.put(sub1, sub2);
				}
			}
		}
		return true;

		/*
		 * int[] m1 = new int[256]; int[] m2 = new int[256]; for(int
		 * i=0;i<s.length();i++) { if(m1[s.charAt(i)] != m2[t.charAt(i)]) return
		 * false; m1[s.charAt(i)] = i+1; m2[t.charAt(i)] = i+1; } return true;
		 */

	}

	public boolean isIsomorphic2(String s, String t) {
		Map<Character, Integer> maps = new HashMap<Character, Integer>();
		Map<Character, Integer> mapt = new HashMap<Character, Integer>();
		if (s.length() != t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char st = t.charAt(i);
			if (!maps.containsKey(sc) && !mapt.containsKey(st)) {
				maps.put(sc, i);
				mapt.put(st, i);
			} else if ((maps.containsKey(sc) ^ mapt.containsKey(st)) || maps.get(sc) != mapt.get(st)) {
				return false;
			}
		}
		return true;
	}

	public boolean isIsomorphic3(String s, String t) {
		int[] nums = new int[256];
		int[] numt = new int[256];
		if (s.length() != t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char st = t.charAt(i);
			if (nums[sc] != numt[st])
				return false;
			nums[sc] = i + 1;
			numt[st] = i + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicStrings is = new IsomorphicStrings();
		System.out.println(is.isIsomorphic("ab", "aa"));
	}

}
