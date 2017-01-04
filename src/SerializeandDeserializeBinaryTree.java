import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SerializeandDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	public void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("X").append(",");
		} else {
			sb.append(root.val).append(",");
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodel = data.split(",");
		Deque<String> nodes = new LinkedList<String>();
		for (int i = 0; i < nodel.length; i++) {
			nodes.add(nodel[i]);
		}
		return buildTree(nodes);
	}

	private TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals("X")) {
			return null;
		} else {
			TreeNode node = new TreeNode(Integer.parseInt(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}

	public List<String> addOperators(String num, int target) {
		if (num.length() == 0)
			return new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		ArrayList<String> ops = new ArrayList<String>();
		ops.add("+");
		ops.add("-");
		ops.add("*");
		ops.add("");
		gen(num, 0, "", res, ops, target, num.charAt(0) == '0');
		return res;
	}

	// the last digit in num is treated separately,beacase we can not add
	// operator after the last digit
	public void gen(String num, int index, String cur, List<String> res, ArrayList<String> operators, int target,
			boolean flag) {
		if (index == num.length() - 1) {
			String tmp = new String(cur + num.charAt(index));
			// when the situation is 10+01 this is not valid, and 100+1 is
			// valid, special case.
			if ((cur.length() == 0 || (!flag && Character.isDigit(cur.charAt(cur.length() - 1)))
					|| !Character.isDigit(cur.charAt(cur.length() - 1))) && calculate(tmp) == target) {
				res.add(tmp);
			}
		} else {
			for (int j = 0; j < operators.size(); j++) {
				// the last element in operators is "" .If the situation is
				// 123+03
				// this is not valid , but 123+10003 is valid, if the index
				// point to last '0'
				// flag is used to determine whether we can use concat operator
				if (flag && j == operators.size() - 1)
					continue;
				// set the flag if we use "+","-","*" operator
				gen(num, index + 1, cur + num.charAt(index) + operators.get(j), res, operators, target,
						j == operators.size() - 1 ? flag : num.charAt(index + 1) == '0');
			}
		}
	}

	// use long to pass the special case
	public int calculate(String s) {
		s = s + "+";
		long res = 0;
		long val = 0;
		char sign = '+';
		Stack<Long> st = new Stack<Long>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				val = val * 10 + s.charAt(i) - '0';
			} else if (s.charAt(i) != ' ') {
				switch (sign) {
				case '+':
					st.push(val);
					break;
				case '-':
					st.push(-val);
					break;
				case '*':
					st.push(st.pop() * val);
					break;
				case '/':
					st.push(st.pop() / val);
					break;
				}
				val = 0;
				sign = s.charAt(i);
			}
		}
		for (long x : st)
			res += x;
		return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
