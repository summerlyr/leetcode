import java.util.Arrays;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		int[] count = new int[26];
		Arrays.fill(count, 0);
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			} else if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
					&& isScramble(s1.substring(i + 1), s2.substring(0, s1.length() - i))) {
				return true;
			}
		}
		return false;
	}

	public boolean isScramble2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		else {
			boolean res = false;
			if (s1.length() == 0 && s2.length() == 0) {
				res = true;
			} else if (s1.length() == 1 && s2.length() == 1) {
				if (s1.equals(s2)) {
					res = true;
				} else {
					res = false;
				}
			} else if (s1.length() == 2 && s2.length() == 2) {
				String s2t = s2.charAt(1) + "" + s2.charAt(0);
				if (s1.equals(s2) || s1.equals(s2t)) {
					res = true;
				} else {
					res = false;
				}
			} else {
				for (int i = 0; i < s1.length(); i++) {
					boolean t1 = isScramble(s1.substring(0, i), s2.substring(0, i));
					boolean t2 = isScramble(s1.substring(i + 1), s2.substring(i + 1));
					if (t1 && t2) {
						res = true;
						break;
					}

				}
			}
			return res;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
