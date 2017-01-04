import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new LinkedList<String>();
		if (s == null)
			return res;

		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();

		queue.add(s);
		visited.add(s);
		boolean flag = false;

		while (!queue.isEmpty()) {
			String cur = queue.poll();

			if (isValid(cur)) {
				res.add(cur);
				flag = true;
			}
			if (flag)
				continue;

			for (int i = 0; i < cur.length(); i++) {
				if (cur.charAt(i) != '(' && cur.charAt(i) != ')')
					continue;
				String add = cur.substring(0, i) + cur.substring(i + 1);
				if (!visited.contains(add)) {
					queue.add(add);
					visited.add(add);
				}
			}
		}
		return res;

	}

	public boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				count++;
			else if (s.charAt(i) == ')' && count-- == 0)
				return false;
		}
		return count == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
