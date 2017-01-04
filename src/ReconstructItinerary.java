import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new LinkedList<String>();
		if (tickets.length == 0)
			return res;
		Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
		for (int i = 0; i < tickets.length; i++) {
			if (map.containsKey(tickets[i][0])) {
				map.get(tickets[i][0]).add(tickets[i][1]);
			} else {
				PriorityQueue<String> cur = new PriorityQueue<String>();
				cur.add(tickets[i][1]);
				map.put(tickets[i][0], cur);
			}
		}
		help(res, map, "JFK");
		return res;
	}

	public void help(List<String> res, Map<String, PriorityQueue<String>> map, String s) {
		PriorityQueue<String> cur = map.get(s);
		while (cur != null && !cur.isEmpty()) {
			help(res, map, cur.poll());
		}
		res.add(0, s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
