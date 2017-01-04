public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		int p = x;
		if (x < 0) {
			return false;
		}
		long res = 0;
		do {
			int m = x % 10;
			res = res * 10 + m;
			x = x / 10;
		} while (x / 10 != 0);
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
			return false;
		}
		if (p == (int) res) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPalindrome2(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int newnum = 0;
		while (newnum < x) {
			newnum = newnum * 10 + x % 10;
			x = x / 10;
		}
		return (newnum == x || newnum / 10 == x);
	}

	public boolean isPalindrome3(int x) {
		if (x < 0)
			return false;
		int p = x;
		int newnum = 0;
		while (p != 0) {
			int remain = p % 10;
			p = p / 10;
			newnum = newnum * 10 + remain;
		}
		if (newnum != x)
			return false;
		return true;
	}

	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		boolean f = pn.isPalindrome(-2147447412);
		System.out.println(f);
	}

}
