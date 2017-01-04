public class HouseRobber {

	public int rob(int[] num) {
		/*
		 * int preNo = 0; int preYes = 0; for(int i=0;i<num.length;i++) { int
		 * temp = preNo; preNo = Math.max(preNo, preYes); preYes = temp +
		 * num[i]; } return Math.max(preNo, preYes);
		 */

		int a = 0;
		int b = 0;
		for (int i = 0; i < num.length; i++) {
			if (i % 2 == 0) {
				a = Math.max(a + num[i], b);
			} else {
				b = Math.max(a, b + num[i]);
			}
		}
		return Math.max(a, b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
