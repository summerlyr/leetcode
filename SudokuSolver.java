public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}

						}
					}
					return false;
				}

			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int i, int j, char c) {
		for (int m = 0; m < 9; m++) {
			if (board[m][j] == c) {
				return false;
			}
		}
		for (int m = 0; m < 9; m++) {
			if (board[i][m] == c) {
				return false;
			}
		}
		for (int m = (i / 3) * 3; m < (i / 3) * 3 + 3; m++) {
			for (int n = (j / 3) * 3; n < (j / 3) * 3 + 3; n++) {
				if (board[m][n] == c) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
