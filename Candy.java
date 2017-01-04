public class Candy {

	public int candy(int[] ratings) {
		int count = 0;
		int len = 0;
		int pre = 1;
		int max = pre;
		if (ratings.length == 0)
			return 0;
		if (ratings.length == 1)
			return 1;
		count++;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] < ratings[i - 1]) {
				len++;
				if (max == len) {
					len++;
				}
				count += len;
				pre = 1;
			} else {
				if (ratings[i] > ratings[i - 1]) {
					pre++;
				} else {
					pre = 1;
				}
				count += pre;
				len = 0;
				max = pre;
			}

		}
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
