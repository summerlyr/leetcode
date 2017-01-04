import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			result.add("");
			return result;
		}
		for (int i = 0; i < n; i++) {
			List<String> head = generateParenthesis(n - i - 1);
			List<String> end = generateParenthesis(i);

			for (String headl : head) {
				for (String endl : end) {
					result.add("(" + headl + ")" + endl);
				}
			}
		}
		return result;
	}

	public List<String> generateParenthesis2(int n) {
		List<String> result = new LinkedList<String>();
		help(result, "", n, n);
		return result;
	}

	public void help(List<String> result, String cur, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(cur);
			return;
		}
		if (left > right) {
			return;
		}
		if (left > 0) {
			help(result, cur + "(", left - 1, right);
		}
		if (right > 0) {
			help(result, cur + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
