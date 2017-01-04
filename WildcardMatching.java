
public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] res = new boolean[m + 1][n + 1];

		res[0][0] = true;
		for (int i = 1; i <= m; i++) {
			res[i][0] = false;
		}
		for (int i = 1; i <= n; i++) {
			res[0][i] = res[0][i - 1] && (p.charAt(i - 1) == '*');
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) != '*') {
					res[i][j] = res[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?');
				} else {
					res[i][j] = res[i - 1][j] || res[i][j - 1];
				}
			}
		}
		return res[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching wm = new WildcardMatching();
		String s = "aa";
		String p = "a*";
		System.out.println(wm.isMatch(s, p));
	}

}
