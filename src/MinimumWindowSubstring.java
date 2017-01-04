import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		// String result = "";
		if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
			return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> newmap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.containsKey(t.charAt(i)) ? map.get(t.charAt(i)) + 1 : 1);
			newmap.put(t.charAt(i), 0);
		}
		int start = 0;
		int count = 0;
		int minstart = 0;
		int minlen = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (map.containsKey(cur)) {
				newmap.put(cur, newmap.get(cur) + 1);
				if (newmap.get(cur) <= map.get(cur)) {
					count++;
				}
			}
			if (count >= t.length()) {
				while ((!map.containsKey(s.charAt(start))) || newmap.get(s.charAt(start)) > map.get(s.charAt(start))) {
					if (newmap.containsKey(s.charAt(start))) {
						newmap.put(s.charAt(start), newmap.get(s.charAt(start)) - 1);
					}
					start++;
				}
				if (i - start + 1 < minlen) {
					minlen = i - start + 1;
					minstart = start;
				}
				count--;
				newmap.put(s.charAt(start), newmap.get(s.charAt(start)) - 1);
				start++;
			}

		}
		if (minlen == Integer.MAX_VALUE)
			return "";
		return s.substring(minstart, minstart + minlen);
	}

	
	public String minWindow2(String s, String t) {
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(char c:tc) {
            map[c]++;
        }
        int start = 0;
        int end = 0;
        int count = t.length();
        int minstart = 0;
        int minlen = Integer.MAX_VALUE;
        while(end<sc.length) {
            if(map[sc[end++]]-->0) count--;
            while(count==0) {
                if(end-start<minlen) {
                    minlen = end-start;
                    minstart = start;
                }
                if(map[sc[start++]]++==0) count++;
            }
        }
        
        return minlen==Integer.MAX_VALUE?"":s.substring(minstart,minstart+minlen);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring mw = new MinimumWindowSubstring();
		System.out.println(mw.minWindow("a", "a"));
	}

}
