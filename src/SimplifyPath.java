import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		String[] tokens = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < tokens.length; i++) {
			// System.out.println(tokens[i]);
			if (tokens[i].isEmpty()) {
				continue;
			}
			if (tokens[i].equals(".")) {
				continue;
			}
			if (tokens[i].equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!tokens[i].equals("..")) {
				stack.push(tokens[i]);
			}
		}
		String result = "";
		if (stack.isEmpty()) {
			result = "/";
		}
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}

		return result;
	}

	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/home//foo/"));

	}

}
