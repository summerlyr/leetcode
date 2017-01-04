
public class Searcha2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		if (n == 0)
			return false;
		return help(matrix, target, 0, m - 1, 0, n - 1);
	}

	public boolean help(int[][] matrix, int target, int rs, int re, int cs, int ce) {
		int rm = (rs + re) / 2;
		int cm = (cs + ce) / 2;
		if (rs > re || cs > ce)
			return false;
		if (matrix[rm][cm] == target) {
			return true;
		} else if (matrix[rm][cm] > target) {
			return help(matrix, target, rs, rm - 1, cs, ce) || help(matrix, target, rs, re, cs, cm - 1);
		} else if (matrix[rm][cm] < target) {
			return help(matrix, target, rm + 1, re, cs, ce) || help(matrix, target, rs, re, cm + 1, ce);
		}
		return true;
	}

	public boolean searchMatrix2(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int row = 0;
		int col = n - 1;
		while (row < m && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
