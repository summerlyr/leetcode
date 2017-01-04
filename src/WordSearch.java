public class WordSearch {

	boolean[][] used;

	public boolean DFS(char[][] board, int i, int j, int n, String word) {
		if (n == word.length())
			return true;
		if (i >= 0 && j >= 0 && i <= board.length - 1 && j <= board[0].length - 1) {
			if (!used[i][j] && board[i][j] == word.charAt(n)) {
				used[i][j] = true;
				if (DFS(board, i, j + 1, n + 1, word) || DFS(board, i + 1, j, n + 1, word)
						|| DFS(board, i - 1, j, n + 1, word) || DFS(board, i, j - 1, n + 1, word))
					return true;

				used[i][j] = false;
			}
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;
		used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				used[i][j] = false;
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (DFS(board, i, j, 0, word))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch ws = new WordSearch();
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		System.out.println(ws.exist(board, "eat"));
	}

}
