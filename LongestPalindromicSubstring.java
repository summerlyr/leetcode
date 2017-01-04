public class LongestPalindromicSubstring {

	String maxs = "";

	public String longestPalindrome(String s) {
		if (s.length() <= 1)
			return s;
		for (int i = 0; i < s.length(); i++) {
			expand(s, i, i);
			expand(s, i, i + 1);
		}
		return maxs;
	}

	public void expand(String s, int i, int j) {
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				if (j - i + 1 > maxs.length()) {
					maxs = s.substring(i, j + 1);
				}
				i--;
				j++;
			} else {
				return;
			}
		}
	}

	public String longestPalindrome2(String s) {
		String maxs = "";
		if (s.length() == 0)
			return maxs;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; (i - j) >= 0 && (i + j) < s.length(); j++) {
				if (s.charAt(i - j) != s.charAt(i + j)) {
					break;
				}
				if (2 * j + 1 > maxs.length()) {
					maxs = s.substring(i - j, i + j + 1);
				}
			}
			for (int j = 0; (i - j) >= 0 && (i + j + 1) < s.length(); j++) {
				if (s.charAt(i - j) != s.charAt(i + j + 1)) {
					break;
				}
				if (2 * j + 2 > maxs.length()) {
					maxs = s.substring(i - j, i + j + 2);
				}
			}
		}
		return maxs;
	}

	public static void main(String[] args) {
		System.out.println("abc".substring(1, 2));
	}

}
