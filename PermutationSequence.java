public class PermutationSequence {

	public String getPermutation(int n, int k) {
		int[] res = new int[n + 1];
		boolean[] flag = new boolean[n + 1];
		String result = "";
		int[] A = { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
		for (int i = 1; i <= n; i++) {
			res[i] = i;
			flag[i] = false;
		}
		k = k - 1;
		for (int i = n - 2; i >= 0; i--) {
			int s = k / A[i] + 1;
			k = k % A[i];
			int count = 0;
			// System.out.println(s);
			for (int m = 1; m <= n; m++) {
				// System.out.println(m);
				if (!flag[m]) {
					count++;
					if (count == s) {
						result += res[m];
						flag[m] = true;
						break;
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (flag[i] == false) {
				result += res[i];
				break;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(4, 17));
	}

}
