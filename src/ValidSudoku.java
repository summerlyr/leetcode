public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		int[][] used1 = new int[9][9];
		int[][] used2 = new int[9][9];
		int[][] used3 = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0' - 1;
					int k = (i / 3) * 3 + (j / 3);
					if (used1[i][num] == 1 || used2[j][num] == 1 || used3[k][num] == 1) {
						System.out.println();
						return false;
					}
					used1[i][num] = 1;
					used2[j][num] = 1;
					used3[k][num] = 1;
				}
			}
		}
		return true;
	}

	public boolean isValidSudoku2(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!help(board, i, i, 0, 8))
				return false;
			if (!help(board, 0, 8, i, i))
				return false;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!help(board, i * 3, i * 3 + 2, j * 3, j * 3 + 2))
					return false;
			}
		}
		return true;
	}

	public boolean help(char[][] board, int x1, int x2, int y1, int y2) {
		int[] set = new int[9];
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (board[i][j] != '.') {
					if (set[board[i][j] - '0' - 1] == 1)
						return false;
					set[board[i][j] - '0' - 1] = 1;
				}
			}
		}
		return true;
	}

	public boolean isValidSudoku3(char[][] board) {
		int[] row = new int[9];
		int[] col = new int[9];
		int[] table = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = 1 << (board[i][j] - '0');
					int k = (i / 3) * 3 + (j / 3);

					if ((row[i] & num) != 0 || (col[j] & num) != 0 || (table[k] & num) != 0)
						return false;
					row[i] |= num;
					col[j] |= num;
					table[k] |= num;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = { { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
				{ '2', '.', '.', '.', '.', '.', '.', '.', '.' }, { '3', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '4', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '6', '.', '.', '.', '.', '.', '.', '.', '.' }, { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '8', '.', '.', '.', '.', '.', '.', '.', '.' }, { '9', '.', '.', '.', '.', '.', '.', '.', '.' } };
		ValidSudoku vs = new ValidSudoku();
		System.out.println(vs.isValidSudoku(board));

	}

}
