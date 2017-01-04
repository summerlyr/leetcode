public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int rows = 0;
		int rowe = n - 1;
		int cols = 0;
		int cole = n - 1;
		int num = 1;
		while (rows <= rowe && cols <= cole) {
			for (int j = cols; j <= cole; j++) {
				result[rows][j] = num;
				num++;
			}
			rows++;
			for (int j = rows; j <= rowe; j++) {
				result[j][cole] = num;
				num++;
			}
			cole--;
			if (cols <= cole) {
				for (int j = cole; j >= cols; j--) {
					result[rowe][j] = num;
					num++;
				}
			}
			rowe--;
			if (rows <= rowe) {
				for (int j = rowe; j >= rows; j--) {
					result[j][cols] = num;
					num++;
				}
			}
			cols++;

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
