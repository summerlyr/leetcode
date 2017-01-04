import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<String>();
		if (digits.length() == 0)
			return result;
		String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");

		for (int i = 0; i < digits.length(); i++) {
			int num = Integer.parseInt(digits.substring(i, i + 1));
			while (result.peek().length() == i) {
				String t = result.remove();
				for (char s : map[num].toCharArray()) {
					result.add(t + s);
				}
			}
		}
		return result;
	}

	Map<Integer, String> map = new HashMap<Integer, String>();

	public List<String> letterCombinations2(String digits) {
		map.put(0, " ");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		List<String> result = new LinkedList<String>();
		if (digits.length() == 0)
			return result;
		help(result, "", digits, 0);
		return result;
	}

	public void help(List<String> result, String cur, String digits, int pos) {
		if (pos == digits.length()) {
			result.add(cur);
			return;
		}
		String s = map.get(digits.charAt(pos) - '0');
		for (int i = 0; i < s.length(); i++) {
			help(result, cur + s.charAt(i), digits, pos + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
