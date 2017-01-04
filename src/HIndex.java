import java.util.Arrays;

public class HIndex {

	public int hIndex(int[] citations) {
		int result = 0;
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length - i) {
				result = citations.length - i;
				break;
			}
		}
		return result;
	}

	public int hIndex2(int[] citations) {
		int num = 0;
		int[] count = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] > citations.length)
				count[citations.length]++;
			else {
				count[citations[i]]++;
			}
		}
		for (int i = citations.length; i >= 0; i--) {
			num += count[i];
			if (num >= i) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
