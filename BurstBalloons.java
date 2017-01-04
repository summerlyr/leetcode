
public class BurstBalloons {

	public int maxCoins(int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = 1;
		int[] newnums = new int[nums.length + 2];
		for (int num : nums)
			newnums[n++] = num;
		newnums[0] = newnums[n++] = 1;

		int[][] tmp = new int[n][n];
		return burst(tmp, newnums, 0, n - 1);
	}

	public int burst(int[][] tmp, int[] newnums, int left, int right) {
		if (left + 1 == right)
			return 0;
		if (tmp[left][right] > 0)
			return tmp[left][right];
		int ans = 0;

		for (int i = left + 1; i < right; i++) {
			ans = Math.max(ans, newnums[i] * newnums[left] * newnums[right] + burst(tmp, newnums, left, i)
					+ burst(tmp, newnums, i, right));
		}
		tmp[left][right] = ans;
		return ans;
	}

	public int maxCoins2(int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = 1;
		int[] newnums = new int[nums.length + 2];
		for (int num : nums)
			newnums[n++] = num;
		newnums[0] = newnums[n++] = 1;

		int[][] tmp = new int[n][n];

		for (int k = 2; k < n; k++) {
			for (int left = 0; left < n - k; left++) {
				int right = left + k;
				for (int i = left + 1; i < right; i++) {
					tmp[left][right] = Math.max(tmp[left][right],
							newnums[left] * newnums[i] * newnums[right] + tmp[left][i] + tmp[i][right]);
				}
			}
		}

		return tmp[0][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
