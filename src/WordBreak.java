import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		boolean[] breakable = new boolean[s.length() + 1];
		Arrays.fill(breakable, false);
		breakable[0] = true;

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (breakable[j] && dict.contains(s.substring(j, i))) {
					breakable[i] = true;
					break;
				}
			}
		}
		return breakable[s.length()];
	}

	public boolean wordBreak2(String s, Set<String> wordDict) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(0);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = cur + 1; i <= s.length(); i++) {
				if (visited.contains(i))
					continue;
				if (wordDict.contains(s.substring(cur, i))) {
					if (i == s.length())
						return true;
					queue.offer(i);
					visited.add(i);
				}
			}
		}
		return false;
	}

	public boolean wordBreak3(String s, Set<String> wordDict) {
		Set<Integer> set = new HashSet<Integer>();
		return DFS(s, wordDict, 0, set);
	}

	public boolean DFS(String s, Set<String> wordDict, int start, Set<Integer> set) {
		if (start == s.length())
			return true;
		if (set.contains(start))
			return false;
		for (int i = start + 1; i <= s.length(); i++) {
			String cur = s.substring(start, i);
			if (wordDict.contains(cur)) {
				if (DFS(s, wordDict, i, set))
					return true;
				else
					set.add(i);
			}
		}
		set.add(start);
		return false;
	}

	public static void main(String[] args) {

	}

}
