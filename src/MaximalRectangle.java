import java.util.Arrays;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		// height counts the number of successive '1's above (plus the current
		// one). The value of left & right means the boundaries of the rectangle
		// which contains the current point with a height of value height.
		if (matrix == null)
			return 0;
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		int max = 0;

		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(height, 0);
		Arrays.fill(right, n);
		Arrays.fill(left, 0);
		for (int i = 0; i < m; i++) {
			int curleft = 0;
			int curright = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j] = height[j] + 1;
				} else {
					height[j] = 0;
				}
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], curleft);
				} else {
					left[j] = 0;
					curleft = j + 1;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], curright);
				} else {
					right[j] = n;
					curright = j;
				}
			}
			for (int j = 0; j < n; j++) {
				max = Math.max(max, (right[j] - left[j]) * height[j]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalRectangle mr = new MaximalRectangle();
		char[][] matrix = { { '0', '0', '0' }, { '0', '0', '0' }, { '1', '1', '1' } };
		System.out.println(mr.maximalRectangle(matrix));
	}

}
