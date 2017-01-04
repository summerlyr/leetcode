
public class GameofLife {

	int[] test = { 1, 2, 3 };
	int[][] directions = { { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		if (m == 0)
			return;
		int[][] newstate = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = countlive(board, i, j);

				if (board[i][j] == 1) {
					if (count < 2)
						newstate[i][j] = 0;
					else if (count == 2 || count == 3)
						newstate[i][j] = 1;
					else if (count > 3)
						newstate[i][j] = 0;
				} else {
					if (count == 3)
						newstate[i][j] = 1;
					else
						newstate[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = newstate[i][j];
			}
		}
	}

	public int countlive(int[][] board, int i, int j) {
		int count = 0;
		for (int q = 0; q < directions.length; q++) {
			int currow = i + directions[q][0];
			int curcol = j + directions[q][1];
			if (currow >= 0 && currow < board.length && curcol >= 0 && curcol < board[0].length) {
				if (board[currow][curcol] == 1) {
					count++;
				}
			}
		}
		return count;
	}

	public void gameOfLife2(int[][] board) {
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		if (n == 0)
			return;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int ii = Math.max(i - 1, 0); ii < Math.min(i + 2, m); ii++) {
					for (int jj = Math.max(j - 1, 0); jj < Math.min(j + 2, n); jj++) {
						if (!(ii == i && jj == j)) {
							count += board[ii][jj] & 1;
						}
					}
				}
				if (count == 3 && board[i][j] == 0)
					board[i][j] |= 2;
				if ((count == 2 || count == 3) && board[i][j] == 1)
					board[i][j] |= 2;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] >>= 1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameofLife gl = new GameofLife();
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		gl.gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
