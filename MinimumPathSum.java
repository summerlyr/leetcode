import java.util.LinkedList;
import java.util.Queue;

public class MinimumPathSum {

	class pair {
		int x, y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int minPathSum(int[][] grid) {
		int[][] offset = { { 1, 0 }, { 0, 1 } };
		int m = grid.length;
		int n = grid[0].length;
		int[][] dist = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = grid[0][0];
		Queue<pair> queue = new LinkedList<pair>();
		queue.add(new pair(0, 0));
		while (!queue.isEmpty()) {
			pair cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			for (int i = 0; i < offset.length; i++) {
				int newx = x + offset[i][0];
				int newy = y + offset[i][1];
				if (newx < m && newy < n && dist[x][y] + grid[newx][newy] < dist[newx][newy]) {
					dist[newx][newy] = dist[x][y] + grid[newx][newy];
					queue.add(new pair(newx, newy));
				}
			}
		}

		return dist[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
