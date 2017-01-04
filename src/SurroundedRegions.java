import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public void solve(char[][] board) {
		int w = board.length;
		if (w <= 1)
			return;
		int l = board[0].length;
		if (l <= 1)
			return;
		for (int i = 0; i < w; i++) {
			if (board[i][0] == 'O') {
				fillBounary(board, i, 0);
			}
			if (board[i][l - 1] == 'O') {
				fillBounary(board, i, l - 1);
			}
		}
		for (int i = 0; i < l; i++) {
			if (board[0][i] == 'O') {
				fillBounary(board, 0, i);
			}
			if (board[w - 1][i] == 'O') {
				fillBounary(board, w - 1, i);
			}
		}
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < l; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == 'B') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public void fillBounary(char[][] board, int x, int y) {
		Queue<pairs> queue = new LinkedList<pairs>();
		pairs pair = new pairs(x, y);
		queue.add(pair);

		while (!queue.isEmpty()) {
			pairs cur = queue.poll();
			if (cur.x >= 0 && cur.x < board.length && cur.y >= 0 && cur.y < board[0].length
					&& board[cur.x][cur.y] == 'O') {
				board[cur.x][cur.y] = 'B';
				queue.add(new pairs(cur.x - 1, cur.y));
				queue.add(new pairs(cur.x, cur.y - 1));
				queue.add(new pairs(cur.x, cur.y + 1));
				queue.add(new pairs(cur.x + 1, cur.y));
			}
		}
	}

	class UnionSet {
		int[] father;

		UnionSet(char[][] board) {
			int m = board.length;
			int n = board[0].length;
			father = new int[m * n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
						father[i * n + j] = m * n;
					} else
						father[i * n + j] = i * n + j;
				}
			}
		}

		void union(int x, int y) {
			int i = find(x);
			int j = find(y);
			if (i != j) {
				father[x] = j;
			}
		}

		int find(int x) {
			if (father[x] == x || father[x] == father.length)
				return father[x];
			father[x] = find(father[x]);
			return father[x];
		}
	}

	public void solve2(char[][] board) {
		int m = board.length;
		if (m <= 1)
			return;
		int n = board[0].length;
		if (n <= 1)
			return;
		UnionSet uf = new UnionSet(board);
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 'O') {
					if (board[i - 1][j] == 'O') {
						uf.union(i * n + j, (i - 1) * n + j);
					}
					if (board[i][j - 1] == 'O') {
						uf.union(i * n + j, i * n + j - 1);
					}
					if (board[i + 1][j] == 'O') {
						uf.union(i * n + j, (i + 1) * n + j);
					}
					if (board[i][j + 1] == 'O') {
						uf.union(i * n + j, i * n + j + 1);
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (uf.find(i * n + j) != n * m)
					board[i][j] = 'X';
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions sr = new SurroundedRegions();
		char[][] board = { { 'O', 'O', 'O', 'O', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'O' }, { 'O', 'X', 'O', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O' },
				{ 'O', 'X', 'O', 'O', 'O', 'O' } };
		sr.solve2(board);
	}

}
