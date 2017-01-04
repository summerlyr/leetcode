public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.childNodes[c - 'a'] == null) {
				curr.childNodes[c - 'a'] = new TrieNode();
			}
			curr = curr.childNodes[c - 'a'];
		}
		curr.item = word;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.childNodes[c - 'a'] == null)
				return false;
			curr = curr.childNodes[c - 'a'];
		}
		return curr.item.equals(word);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (char c : prefix.toCharArray()) {
			if (curr.childNodes[c - 'a'] == null)
				return false;
			curr = curr.childNodes[c - 'a'];
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
