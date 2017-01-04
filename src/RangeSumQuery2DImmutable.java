
public class RangeSumQuery2DImmutable {

	int[][] res;

	public RangeSumQuery2DImmutable(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			res = new int[1][1];
		else {
			int m = matrix.length;
			int n = matrix[0].length;
			res = new int[m + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + matrix[i - 1][j - 1];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return res[row2 + 1][col2 + 1] + res[row1][col1] - res[row1][col2 + 1] - res[row2 + 1][col1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
