public class NQueensII {

	int sum = 0;

	public int totalNQueens(int n) {
		if (n == 0)
			return 0;
		int[] x = new int[n + 1];
		queen(1, n, x);
		return sum;
	}

	public void queen(int t, int n, int[] x) {
		if (t > n && n > 0) {
			sum++;
		} else {
			for (int i = 1; i <= n; i++) {
				x[t] = i;
				if (place(t, x)) {
					queen(t + 1, n, x);
				}
			}
		}
	}

	public boolean place(int k, int[] x) {
		for (int i = 1; i < k; i++) {
			if (Math.abs(k - i) == Math.abs(x[k] - x[i]) || x[k] == x[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(4));
	}

}
