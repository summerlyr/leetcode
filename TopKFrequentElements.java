import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new LinkedList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}
		List<Integer>[] bucket = new ArrayList[nums.length + 1];
		for (int key : map.keySet()) {
			int feq = map.get(key);
			if (bucket[feq] == null)
				bucket[feq] = new ArrayList<Integer>();
			bucket[feq].add(key);
		}
		for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
			if (bucket[i] != null)
				result.addAll(bucket[i]);
		}

		return result;
	}
	
	public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> result = new LinkedList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int n:nums) {
            if(map.containsKey(n)) {
                map.put(n,map.get(n)+1);
            }
            else
            {
                map.put(n,1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            pq.offer(entry);
            if(pq.size()>k) pq.poll();
        }
        
        while(!pq.isEmpty()) result.add(0,pq.poll().getKey());
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElements t = new TopKFrequentElements();
		int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3 };
		List<Integer> l = t.topKFrequent(nums, 2);
		for (int i : l) {
			System.out.println(i);
		}
	}

}
