public class UnionFind {
	int count;
	int[] father;
	int m, n;

	UnionFind(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		count = 0;
		father = new int[m * n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					int id = i * n + j;
					father[id] = id;
					count++;
				}
			}
		}
	}

	void union(int i, int j) {
		int x = find(i);
		int y = find(j);
		if (x != y) {
			father[x] = y;
			count--;
		}
	}

	int find(int i) {
		if (father[i] == i)
			return i;
		father[i] = find(father[i]);
		return father[i];
	}
}