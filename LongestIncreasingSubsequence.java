import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums.length <= 0)
			return 0;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					max = Math.max(dp[i], max);
				}
			}
		}
		return max;
		/*
		 * int[] dp = new int[nums.length]; int len = 0;
		 * 
		 * for(int x : nums) { int i = Arrays.binarySearch(dp, 0, len, x);if(i <
		 * 0) i = -(i + 1); dp[i] = x; if(i == len) len++; }
		 * 
		 * return len;
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
