
public class ReverseWordsinaString {

	public String reverseWords(String s) {
		String[] words = s.trim().split("\\s+");
		String result = "";
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].length() > 0) {
				result += words[i] + " ";
			}
		}
		return result.trim();
	}

	public static void main(String[] args) {
	}

}
