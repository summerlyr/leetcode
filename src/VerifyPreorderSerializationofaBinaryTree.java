import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {

	public boolean isValidSerialization(String preorder) {
		String[] strs = preorder.split(",");
		Stack<String> stack = new Stack<String>();
		if (strs.length == 0)
			return false;
		for (int i = 0; i < strs.length; i++) {
			String cur = strs[i];
			while (cur.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
				stack.pop();
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
			stack.push(cur);
		}
		return stack.size() == 1 && stack.peek().equals("#");
	}

	public boolean isValidSerialization2(String preorder) {
		String[] strs = preorder.split(",");
		if (strs.length == 0)
			return false;
		int diff = 1;
		for (int i = 0; i < strs.length; i++) {
			if (--diff < 0)
				return false;
			if (!strs[i].equals("#"))
				diff += 2;
		}
		return diff == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
