
public class EditDistance {

	public int minDistance(String word1, String word2) {
		if (word1.length() == 0 && word2.length() == 0)
			return 0;
		else if (word1.length() == 0)
			return word2.length();
		else if (word2.length() == 0)
			return word1.length();
		else {

			int[][] edit = new int[word1.length() + 1][word2.length() + 1];
			edit[0][0] = 0;
			for (int i = 0; i < edit.length; i++) {
				edit[i][0] = i;
			}
			for (int i = 0; i < edit[0].length; i++) {
				edit[0][i] = i;
			}
			for (int i = 1; i <= word1.length(); i++) {
				for (int j = 1; j <= word2.length(); j++) {
					int f = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1;
					edit[i][j] = Math.min(Math.min(edit[i - 1][j] + 1, edit[i][j - 1] + 1), edit[i - 1][j - 1] + f);
				}
			}
			return edit[word1.length()][word2.length()];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
