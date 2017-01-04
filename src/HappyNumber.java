import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		if (n == 1)
			return true;
		set.add(n);
		int number = n;
		while (number != 1) {
			System.out.println(number);
			number = compute(number);
			if (set.contains(number)) {
				return false;
			}

			set.add(number);
		}
		return true;
	}

	public boolean isHappy2(int n) {
		if (n == 1)
			return true;
		int slow = n;
		int fast = n;
		do {
			slow = compute(slow);
			fast = compute(compute(fast));
		} while (slow != fast);
		if (slow == 1)
			return true;
		return false;
	}

	public int compute(int n) {
		int result = 0;
		while (n != 0) {
			int remain = n % 10;
			n = n / 10;
			result += Math.pow(remain, 2);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy2(19));
	}

}
