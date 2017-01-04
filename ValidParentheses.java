import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<String> input = new Stack<String>();
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			String t = s.substring(i, i + 1);
			System.out.println(t);
			if (t.equals("(") || t.equals("[") || t.equals("{")) {
				input.push(t);
			} else if (!input.isEmpty() && ((t.equals(")") && input.peek().equals("("))
					|| (t.equals("]") && input.peek().equals("[")) || (t.equals("}") && input.peek().equals("{")))) {
				input.pop();
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (!input.isEmpty()) {
			flag = false;
		}

		return flag;
	}

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '{' || cur == '[') {
				stack.push(cur);
			} else if (cur == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if (cur == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else if (cur == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("]"));
	}

}
