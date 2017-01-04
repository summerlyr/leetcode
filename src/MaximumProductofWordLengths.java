
public class MaximumProductofWordLengths {

	public int maxProduct(String[] words) {
		int[] value = new int[words.length];
		if (words.length == 0)
			return 0;
		for (int i = 0; i < words.length; i++) {
			String cur = words[i];
			for (int j = 0; j < cur.length(); j++) {
				value[i] |= 1 << (cur.charAt(j) - 'a');
			}
		}
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if ((value[i] & value[j]) == 0) {
					max = Math.max(words[i].length() * words[j].length(), max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
