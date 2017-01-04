import java.util.Stack;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					if (s.charAt(stack.peek()) == '(') {
						stack.pop();
					} else {
						stack.push(i);
					}
				} else {
					stack.push(i);
				}
			}
		}
		int longest = 0;
		if (stack.isEmpty()) {
			longest = n;
		} else {
			int a = n;
			int b = 0;
			while (!stack.isEmpty()) {
				b = stack.pop();
				longest = Math.max(longest, a - b - 1);
				a = b;
			}
			longest = Math.max(longest, a);
		}
		return longest;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
