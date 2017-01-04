public class Searcha2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m * n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (matrix[mid / n][mid % n] == target) {
				return true;
			} else if (matrix[mid / n][mid % n] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
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
		Searcha2DMatrix sm = new Searcha2DMatrix();
		int[][] matrix = { { 1, 3 } };
		System.out.println(sm.searchMatrix(matrix, 3));

	}

}
