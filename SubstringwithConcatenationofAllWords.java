import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        List<Integer> res = new LinkedList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0||s.length()<words[0].length()) return res;
        for(String word:words) {
            map.put(word,map.containsKey(word)?map.get(word)+1:1);
        }
        int len = words[0].length();
        for(int i=0;i<=s.length()-words.length*len;i++) {
            Map<String,Integer> copy = new HashMap<String,Integer>(map);
            for(int j=0;j<words.length;j++) {
                String cur = s.substring(i+j*len,i+j*len+len);
                if(copy.containsKey(cur)) {
                    int count = copy.get(cur);
                    if(count==1) copy.remove(cur);
                    else copy.put(cur,count-1);
                    if(copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                }
                else break;
            }
        }
        return res;
    }
	
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> result = new LinkedList<Integer>();
		if (s.length() == 0 || words.length == 0 || words[0].length() > s.length())
			return result;
		int wordlen = words[0].length();
		// int len = words[0].length() * words.length;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], !map.containsKey(words[i]) ? 1 : map.get(words[i]) + 1);
		}
		for (int i = 0; i < wordlen; i++) {
			Map<String, Integer> newmap = new HashMap<String, Integer>();
			int count = 0;
			int start = i;
			for (int j = i; j + wordlen <= s.length(); j += wordlen) {
				String cur = s.substring(j, j + wordlen);
				if (map.containsKey(cur)) {
					newmap.put(cur, newmap.containsKey(cur) ? newmap.get(cur) + 1 : 1);
					if (newmap.get(cur) <= map.get(cur)) {
						count++;
					} else {
						while (newmap.get(cur) > map.get(cur)) {
							String tmp = s.substring(start, start + wordlen);
							newmap.put(tmp, newmap.get(tmp) - 1);
							if (newmap.get(tmp) < map.get(tmp)) {
								count--;
							}
							start += wordlen;
						}
					}
					if (count == words.length) {
						result.add(start);
						newmap.put(s.substring(start, start + wordlen),
								newmap.get(s.substring(start, start + wordlen)) - 1);
						count--;
						start = start + wordlen;
					}
				} else {
					newmap.clear();
					count = 0;
					start = j + wordlen;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
