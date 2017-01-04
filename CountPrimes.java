public class CountPrimes {

	public int countPrimes(int n) {
		boolean[] flags = sieveOfEratosthenes(n);
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				count++;
			}
		}
		return count;
	}

	public boolean[] sieveOfEratosthenes(int n) {
		boolean[] flags = new boolean[n];
		// int count = 0;
		for (int i = 2; i < flags.length; i++) {
			flags[i] = true;
		}
		int prime = 2;
		while (prime <= Math.sqrt(n)) {
			crossOff(flags, prime);

			prime = getNextPrime(flags, prime);

			if (prime >= flags.length) {
				break;
			}
		}
		return flags;

	}

	public void crossOff(boolean[] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}

	public int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;
	}

	public int countPrimes2(int n) {
		int count = 2;
		for (int i = 4; i < n; i++) {
			if (help(i))
				count++;
		}
		return count;
	}

	public boolean help(int n) {
		for (int i = 2; i <= n - 1 / 2; i++) {
			if (n % i == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(2));
	}

}
