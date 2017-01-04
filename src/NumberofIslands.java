import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {
	static class pairs {
		int x, y;

		pairs(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int numIslands(char[][] grid) {
		// return BFS(grid, 0, 0);
		int count = 0;

		int w = grid.length;
		if (w == 0)
			return 0;
		int l = grid[0].length;
		if (l == 0)
			return 0;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < l; j++) {
				if (grid[i][j] == '1') {
					BFS(grid, i, j);
					count++;
				}
			}
		}

		return count;
	}

	public void BFS(char[][] grid, int i, int j) {
		Queue<pairs> queue = new LinkedList<pairs>();
		pairs pair = new pairs(i, j);
		queue.add(pair);

		while (!queue.isEmpty()) {
			pairs cur = queue.poll();

			if (cur.x >= 0 && cur.x < grid.length && cur.y >= 0 && cur.y < grid[0].length
					&& grid[cur.x][cur.y] == '1') {
				grid[cur.x][cur.y] = '2';
				queue.add(new pairs(cur.x - 1, cur.y));
				queue.add(new pairs(cur.x, cur.y - 1));
				queue.add(new pairs(cur.x, cur.y + 1));
				queue.add(new pairs(cur.x + 1, cur.y));
			}
		}

	}

	public int numIslands2(char[][] grid) {
		int count = 0;
		if (grid.length == 0 || grid[0].length == 0)
			return count;
		int m = grid.length;
		int n = grid[0].length;
		int[][] distance = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		UnionFind uf = new UnionFind(grid);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					for (int p = 0; p < 4; p++) {
						int x = i + distance[p][0];
						int y = j + distance[p][1];
						if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
							int id1 = i * n + j;
							int id2 = x * n + y;
							uf.union(id1, id2);
						}
					}
				}
			}
		}
		return uf.count;
	}

	public int numIslands3(char[][] grid) {
		int count = 0;
		if (grid.length == 0 || grid[0].length == 0)
			return count;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					DFS(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public void DFS(char[][] grid, int x, int y) {
		if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
			grid[x][y] = '0';
			DFS(grid, x - 1, y);
			DFS(grid, x, y - 1);
			DFS(grid, x + 1, y);
			DFS(grid, x, y + 1);
		} else
			return;
	}

	public static void main(String[] args) {

	}

}
