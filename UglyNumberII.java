import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumberII {

	public int nthUglyNumber(int n) {
		if (n == 1)
			return 1;
		int count = 1;
		Queue<Long> queue = new PriorityQueue<Long>();
		queue.add((long) 2);
		queue.add((long) 3);
		queue.add((long) 5);
		long result = 0;
		while (count != n) {
			count++;
			long cur = queue.poll();
			if (!queue.contains(cur * 2)) {
				queue.add(cur * 2);
			}
			if (!queue.contains(cur * 3)) {
				queue.add(cur * 3);
			}
			if (!queue.contains(cur * 5)) {
				queue.add(cur * 5);
			}
			result = cur;
		}

		return (int) result;

	}

	public int nthUglyNumber2(int n) {
		int count = 1;
		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		long result = 1;
		queue.add(result);
		while (count <= n) {
			count++;
			result = queue.poll();
			while (!queue.isEmpty() && queue.peek() == result)
				queue.poll();
			queue.add(2 * result);
			queue.add(3 * result);
			queue.add(5 * result);
		}
		return (int) result;
	}

	public int nthUglyNumber3(int n) {
		int[] result = new int[n];
		int index2 = 0, index3 = 0, index5 = 0;
		result[0] = 1;
		for (int i = 1; i < n; i++) {
			result[i] = Math.min(result[index2] * 2, Math.min(result[index3] * 3, result[index5] * 5));
			if (result[i] == result[index2] * 2)
				index2++;
			if (result[i] == result[index3] * 3)
				index3++;
			if (result[i] == result[index5] * 5)
				index5++;
		}
		return result[n - 1];
	}

	public static void main(String[] args) {
		UglyNumberII un = new UglyNumberII();
		System.out.println(un.nthUglyNumber(1407));

	}

}
