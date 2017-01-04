import java.util.Arrays;

public class DistinctSubsequences {

	public int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();
		if (m < n)
			return 0;
		int[] path = new int[n + 1];
		Arrays.fill(path, 0);
		path[0] = 1;
		for (int j = 1; j <= m; j++) {
			for (int i = n; i >= 1; i--) {
				path[i] = path[i] + (s.charAt(j - 1) == t.charAt(i - 1) ? path[i - 1] : 0);
			}
		}
		return path[m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
