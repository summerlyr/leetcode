
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len3 != len1 + len2)
			return false;
		boolean[][] res = new boolean[len2 + 1][len1 + 1];
		res[0][0] = true;
		for (int i = 1; i <= len1; i++) {
			res[0][i] = res[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i <= len2; i++) {
			res[i][0] = res[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i <= len2; i++) {
			for (int j = 1; j <= len1; j++) {
				res[i][j] = (res[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1))
						|| (res[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		}
		return res[len2][len1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
