import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new LinkedList<String>();
		if (nums.length == 0)
			return result;
		int start = 0;
		int end = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] != nums[i] + 1) {
				end = i;
				if (start == end) {
					result.add(nums[start] + "");
				} else {
					result.add(nums[start] + "->" + nums[end]);
				}
				start = i + 1;
			} else {
				end = i + 1;
			}
		}
		if (start == nums.length - 1) {
			result.add(nums[start] + "");
		} else {
			result.add(nums[start] + "->" + nums[nums.length - 1]);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummaryRanges sr = new SummaryRanges();
		int[] nums = { 0, 1, 2, 4, 5, 6 };
		System.out.println(sr.summaryRanges(nums));
	}

}
