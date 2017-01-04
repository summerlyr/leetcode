public class AddandSearchWord {
	// testtest
	public class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String item = "";
	}

	TrieNode root = new TrieNode();

	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.item = word;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	public boolean match(char[] charArray, int start, TrieNode root) {
		if (start == charArray.length) {
			return !root.item.equals("");
		}
		if (charArray[start] != '.') {
			return root.children[charArray[start] - 'a'] != null
					&& match(charArray, start + 1, root.children[charArray[start] - 'a']);
		} else {
			for (int i = 0; i < 26; i++) {
				if (root.children[i] != null) {
					if (match(charArray, start + 1, root.children[i])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
	 * public void addWord(String word) { int len = word.length();
	 * if(map.containsKey(len)) { map.get(len).add(word); } else { List<String>
	 * cur = new LinkedList<String>(); cur.add(word); map.put(len,cur); } }
	 * public boolean search(String word) { if(!map.containsKey(word.length()))
	 * return false; List<String> cur = map.get(word.length()); if(isWord(word))
	 * return cur.contains(word); for(String s:cur) { if(isSame(word,s)) return
	 * true; } return false; } public boolean isWord(String word) { for(char
	 * c:word.toCharArray()) { if(c=='.') return false; } return true; } public
	 * boolean isSame(String search,String word) {
	 * if(search.length()!=word.length()) return false; for(int
	 * i=0;i<word.length();i++) {
	 * if(search.charAt(i)!='.'&&search.charAt(i)!=word.charAt(i)) return false;
	 * } return true; }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
