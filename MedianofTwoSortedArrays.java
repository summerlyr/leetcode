public class MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (n < m)
			return findMedianSortedArrays(nums2, nums1);
		int k = (m + n - 1) / 2;
		int l = 0;
		int r = Math.min(m, k);
		while (l < r) {
			int midA = (l + r) / 2;
			int midB = k - midA;
			if (nums1[midA] < nums2[midB]) {
				l = midA + 1;
			} else {
				r = midA;
			}
		}
		int a = Math.max(l > 0 ? nums1[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? nums2[k - l] : Integer.MIN_VALUE);
		if ((m + n) % 2 == 1)
			return (double) a;

		int b = Math.min(l < m ? nums1[l] : Integer.MAX_VALUE, k - l + 1 < n ? nums2[k - l + 1] : Integer.MAX_VALUE);
		return (a + b) / 2.0;
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int i = 0;
		int j = 0;
		int mid1 = 0;
		int mid2 = 0;
		while (i + j <= (m + n) / 2) {
			if (i < m && j < n) {
				mid2 = mid1;
				if (nums1[i] < nums2[j]) {
					mid1 = nums1[i];
					i++;
				} else {
					mid1 = nums2[j];
					j++;
				}
			} else if (i < m) {
				mid2 = mid1;
				mid1 = nums1[i];
				i++;
			} else if (j < n) {
				mid2 = mid1;
				mid1 = nums2[j];
				j++;
			}
		}
		if ((m + n) % 2 == 0)
			return (mid1 + mid2) / 2.0;
		return mid1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
