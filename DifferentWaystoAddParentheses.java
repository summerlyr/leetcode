import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DifferentWaystoAddParentheses {

	public List<Integer> diffWaysToCompute(String input) {
		return help(0, input.length() - 1, input);
	}

	public List<Integer> help(int start, int end, String input) {
		List<Integer> result = new ArrayList<Integer>();
		if (start > end) {
			result.add(null);
			return result;
		} else if (isNumber(input)) {
			result.add(Integer.parseInt(input));
			return result;
		}
		List<Integer> left, right;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				left = help(0, i, input.substring(0, i));
				right = help(i + 1, input.length(), input.substring(i + 1));
				for (int leftd : left) {
					for (int rightd : right) {
						if (input.charAt(i) == '+') {
							result.add(leftd + rightd);
						}
						if (input.charAt(i) == '-') {
							result.add(leftd - rightd);
						}
						if (input.charAt(i) == '*') {
							result.add(leftd * rightd);
						}
					}
				}
			}
		}
		return result;
	}

	public boolean isNumber(String s) {
		if (s.length() > 10) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
				return false;
			}
		}
		return true;
	}

	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

	public List<Integer> diffWaysToCompute2(String input) {
		List<Integer> result = new LinkedList<Integer>();
		List<Integer> left, right;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				if (map.containsKey(input.substring(0, i))) {
					left = map.get(input.substring(0, i));
				} else {
					left = diffWaysToCompute(input.substring(0, i));
				}
				if (map.containsKey(input.substring(i + 1))) {
					right = map.get(input.substring(i + 1));
				} else {
					right = diffWaysToCompute(input.substring(i + 1));
				}
				for (int l : left) {
					for (int r : right) {
						if (input.charAt(i) == '+') {
							result.add(l + r);
						} else if (input.charAt(i) == '-') {
							result.add(l - r);
						} else if (input.charAt(i) == '*') {
							result.add(l * r);
						}
					}
				}
			}
		}
		if (result.size() == 0)
			result.add(Integer.parseInt(input));
		map.put(input, result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
