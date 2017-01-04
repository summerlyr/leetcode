public class Sqrtx {

	public int mySqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		int left = 1;
		int right = x;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1)) {
					return mid;
				}
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
