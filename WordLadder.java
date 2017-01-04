import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		if (wordDict.size() == 0) {
			return 0;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		wordDict.remove(beginWord);
		int length = 1;
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				String currentstr = queue.poll();
				for (int j = 0; j < currentstr.length(); j++) {
					for (char c = 'a'; c <= 'z'; c++) {
						if (currentstr.charAt(j) == c)
							continue;
						String newstr = replace(currentstr, j, c);
						if (newstr.equals(endWord)) {
							return ++length;
						}
						if (wordDict.contains(newstr)) {
							queue.offer(newstr);
							wordDict.remove(newstr);
						}
					}
				}
			}
			length++;
		}
		return 0;

	}

	public String replace(String s, int j, char c) {
		char[] array = s.toCharArray();
		array[j] = c;
		return new String(array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder wl = new WordLadder();
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(wl.ladderLength("a", "c", set));
	}

}
