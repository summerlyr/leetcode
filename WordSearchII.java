import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	Set<String> result = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				DFS(board, visited, "", i, j, trie);
			}
		}

		return new LinkedList<String>(result);
	}

	private void DFS(char[][] board, boolean[][] visited, String string, int i, int j, Trie trie) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}
		if (visited[i][j])
			return;

		string += board[i][j];

		if (!trie.startsWith(string))
			return;
		if (trie.search(string))
			result.add(string);

		visited[i][j] = true;
		DFS(board, visited, string, i + 1, j, trie);
		DFS(board, visited, string, i, j + 1, trie);
		DFS(board, visited, string, i - 1, j, trie);
		DFS(board, visited, string, i, j - 1, trie);
		visited[i][j] = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearchII ws = new WordSearchII();
		char[][] board = { { 'a', 'a' } };
		String[] words = { "a" };
		System.out.println(ws.findWords(board, words));
	}

}
