public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int cursum = 0;
		int total = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			cursum += gas[i] - cost[i];
			if (cursum < 0) {
				total += cursum;
				cursum = 0;
				start = i + 1;
			}
		}
		total += cursum;
		return total < 0 ? -1 : start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
