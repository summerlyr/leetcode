public class HIndexII {

	public int hIndex(int[] citations) {
		int result = 0;
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length - i) {
				result = citations.length - i;
				break;
			}
		}
		return result;
	}

	public int hIndex2(int[] citations) {
		if (citations.length == 0)
			return 0;
		int length = citations.length;
		int start = 0;
		int end = citations.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (citations[mid] == length - mid) {
				return length - mid;
			} else if (citations[mid] < length - mid) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return length - start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
