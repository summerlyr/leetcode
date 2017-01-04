import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

	Map<String, List<String>> results = new HashMap<String, List<String>>();

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> words = new LinkedList<String>();
		for (int i = 1; i <= s.length(); i++) {
			if (wordDict.contains(s.substring(0, i))) {
				if (i == s.length()) {
					words.add(s.substring(0, i));
				} else {
					String remain = s.substring(i);
					List<String> remainset = new LinkedList<String>();
					if (results.containsKey(remain)) {
						remainset = results.get(remain);
					} else {
						remainset = wordBreak(remain, wordDict);
					}
					if (remainset != null) {
						for (String tmp : remainset) {
							words.add(s.substring(0, i) + " " + tmp);

						}
					}
					results.put(remain, remainset);
				}
			}
		}
		return words;
	}

	public List<String> wordBreak2(String s, Set<String> wordDict) {
		return help(s, wordDict, new HashMap<String, List<String>>());
	}

	public List<String> help(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
		if (map.containsKey(s))
			return map.get(s);
		List<String> list = new LinkedList<String>();
		if (0 == s.length()) {
			list.add("");
			return list;
		}
		for (int i = 1; i <= s.length(); i++) {
			String cs = s.substring(0, i);
			if (wordDict.contains(cs)) {
				List<String> cur = help(s.substring(i), wordDict, map);
				for (String ss : cur) {
					list.add((cs + " " + ss).trim());
				}
			}
		}
		map.put(s, list);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
