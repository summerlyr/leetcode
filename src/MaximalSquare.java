public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		int[][] s = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				s[i][0] = 1;
				max = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == '1') {
				s[0][i] = 1;
				max = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					s[i][j] = Math.min(Math.min(s[i - 1][j], s[i - 1][j - 1]), s[i][j - 1]) + 1;
					max = Math.max(max, s[i][j]);
				}
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
