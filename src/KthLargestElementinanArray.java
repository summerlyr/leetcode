import java.util.PriorityQueue;

public class KthLargestElementinanArray {

	public int findKthLargest(int[] nums, int k) {
		return help(nums, k, 0, nums.length - 1);
	}

	public int help(int[] nums, int k, int l, int r) {

		int s = 0;
		int start = 0, end = nums.length - 1;
		int tar = nums.length - k;
		while ((s = partition(nums, start, end)) != tar) {
			if (s < tar) {
				start = s + 1;
			} else if (s > tar) {
				end = s - 1;
			}
		}
		return nums[s];

	}

	public int partition(int[] nums, int p, int r) {
		int x = nums[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (nums[j] <= x) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		int tmp = nums[i + 1];
		nums[i + 1] = nums[r];
		nums[r] = tmp;
		return i + 1;
	}

	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			queue.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}
		return queue.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementinanArray ke = new KthLargestElementinanArray();
		int[] nums = { -1, -1 };
		System.out.println(ke.findKthLargest(nums, 2));

	}

}
