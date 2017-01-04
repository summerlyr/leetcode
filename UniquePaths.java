public class UniquePaths {

	public int uniquePaths(int m, int n) {
		int s = m + n - 2;
		int t = n - 1;
		double res = 1;
		for (int i = 1; i <= t; i++) {
			res = res * (s - t + i) / i;
		}
		return (int) res;
	}

	public int uniquePaths2(int m, int n) {
		int[][] map = new int[m][n];
		for (int i = 0; i < n; i++) {
			map[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			map[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(4, 4));
	}

}
