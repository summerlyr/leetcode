import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for(int n:nums1) set.add(n);
        for(int n:nums2) {
            if(set.contains(n)) {
                res.add(n);
            }
        }
        int[] result = new int[res.size()];
        int count = 0;
        for(int n:res) {
            result[count++] = n;
        }
        return result;
    }
	public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<Integer>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                i++;
            }
            else if(nums1[i]>nums2[j]) {
                j++;
            }
            else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[res.size()];
        int count = 0;
        for(int n:res) {
            result[count++] = n;
        }
        return result;
    }
}
