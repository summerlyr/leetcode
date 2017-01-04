import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] ca = strs[i].toCharArray();
			Arrays.sort(ca);
			String s = "";
			for (char c : ca) {
				s += c;
			}
			if (map.containsKey(s)) {
				map.get(s).add(strs[i]);
			} else {
				LinkedList<String> cur = new LinkedList<String>();
				cur.add(strs[i]);
				map.put(s, cur);
			}
		}
		List<List<String>> result = new LinkedList<List<String>>();
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			result.add(map.get(iter.next()));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagrams ga = new GroupAnagrams();
		System.out.println(ga.groupAnagrams(strs));
	}

}
