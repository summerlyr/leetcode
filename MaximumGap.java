import java.util.Arrays;

public class MaximumGap {

	public int maximumGap(int[] num) {
		if (num.length < 2)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i : num)// ��������Сֵ
		{
			max = Math.max(i, max);
			min = Math.min(i, min);
		}
		int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));// ���ز�С�ڲ���ֵ����С����������ᳬ�����ֵ
		int[] bucketMax = new int[num.length - 1];// ֻ��¼ÿ��Ͱ�е�������Сֵ����ΪͰ�е�����֮��Ĳ�һ����������
		int[] bucketMin = new int[num.length - 1];// ��n-1��Ͱ
		Arrays.fill(bucketMax, Integer.MIN_VALUE);// ��Ͱ���г�ʼ��
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		for (int i : num)// װͰ
		{
			if (i == min || i == max) {
				continue;
			}
			int index = (i - min) / gap;
			bucketMax[index] = Math.max(i, bucketMax[index]);
			bucketMin[index] = Math.min(i, bucketMin[index]);
		}
		int maxGap = Integer.MIN_VALUE;
		int pre = min;
		for (int i = 0; i < num.length - 1; i++)// ���㣬ֻ�㵱ǰͰ����Сֵ��ǰһ��Ͱ֮������ֵ�Ĳ�
		{
			if (bucketMax[i] == Integer.MIN_VALUE) {
				continue;
			}
			maxGap = Math.max(maxGap, bucketMin[i] - pre);
			pre = bucketMax[i];
		}
		maxGap = Math.max(maxGap, max - pre);// ��Ҫ�������һ��
		return maxGap;
	}

	public int maximumGap2(int[] nums) {
		Arrays.sort(nums);
		if (nums.length < 2)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(nums[i + 1] - nums[i], max);
		}
		return max;
	}

	public int maximumGap3(int[] nums) {
		if (nums.length < 2)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int n : nums) {
			max = Math.max(max, n);
		}
		int exp = 1;
		int aux[] = new int[nums.length];
		while (max / exp > 0) {
			int[] count = new int[10];
			for (int i = 0; i < nums.length; i++) {
				count[(nums[i] / exp) % 10]++;
			}
			for (int i = 1; i < 10; i++) {
				count[i] += count[i - 1];
			}
			for (int i = nums.length - 1; i >= 0; i--) {
				aux[--count[(nums[i] / exp) % 10]] = nums[i];
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i] = aux[i];
			}
			exp *= 10;
		}
		int maxgap = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			maxgap = Math.max(maxgap, nums[i + 1] - nums[i]);
		}
		return maxgap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
