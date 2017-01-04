import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<Integer>();
		if (matrix.length == 0)
			return result;
		int rows = 0;
		int rowe = matrix.length - 1;
		int cols = 0;
		int cole = matrix[0].length - 1;

		while (rows <= rowe && cols <= cole) {
			for (int j = cols; j <= cole; j++) {
				result.add(matrix[rows][j]);
			}
			rows++;
			for (int j = rows; j <= rowe; j++) {
				result.add(matrix[j][cole]);
			}
			cole--;
			if (rows <= rowe) {
				for (int j = cole; j >= cols; j--) {
					result.add(matrix[rowe][j]);
				}
			}
			rowe--;
			if (cols <= cole) {
				for (int j = rowe; j >= rows; j--) {
					result.add(matrix[j][cols]);
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
