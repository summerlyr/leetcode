import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> res = new LinkedList<Integer>();
        for(int n:nums1) {
            map.put(n,map.containsKey(n)?map.get(n)+1:1);
        }
        for(int n:nums2) {
            if(map.containsKey(n)&&map.get(n)>0) {
                res.add(n);
                map.put(n,map.get(n)-1);
            }
        }
        int[] result = new int[res.size()];
        int count = 0;
        for(int n:res) {
            result[count++] = n;
        }
        return result;
    }
	public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new LinkedList<Integer>();
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
