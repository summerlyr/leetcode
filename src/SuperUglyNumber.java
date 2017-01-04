import java.util.PriorityQueue;
import java.util.Queue;

public class SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1)
			return 1;
		int count = 1;
		Queue<Long> queue = new PriorityQueue<Long>();
		for (int i = 0; i < primes.length; i++) {
			queue.add((long) primes[i]);
		}
		long result = 0;
		while (count != n) {
			count++;
			long cur = queue.poll();
			for (int i = 0; i < primes.length; i++) {
				if (!queue.contains((long) cur * primes[i])) {
					queue.add((long) cur * primes[i]);
				}
			}
			result = cur;
		}
		return (int) result;
	}

	public int nthSuperUglyNumber2(int n, int[] primes) {
		if (n == 1)
			return 1;
		int[] indexs = new int[primes.length];
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				res[i] = Math.min(res[indexs[j]] * primes[j], res[i]);
			}
			for (int j = 0; j < primes.length; j++) {
				if (res[i] % primes[j] == 0)
					indexs[j]++;
			}

		}
		return res[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
