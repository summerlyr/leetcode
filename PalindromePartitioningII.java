
public class PalindromePartitioningII {

	public int minCut(String s) {
		int[] cut = new int[s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			cut[i] = i - 1;
		}
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) {
				cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);
			}
			for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
				cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
			}
		}

		return cut[n];
	}

	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		System.out.println(pp.minCut("aabc"));

	}

}
