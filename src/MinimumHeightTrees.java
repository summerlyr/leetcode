import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		// List<Integer> result = new LinkedList<Integer>();
		List<Integer> points = new LinkedList<Integer>();
		if (n <= 0)
			return points;
		if (n == 1) {
			points.add(0);
			return points;
		}
		if (n == 2) {
			points.add(0);
			points.add(1);
			return points;
		}
		List<Set<Integer>> pairs = new ArrayList<Set<Integer>>();

		for (int i = 0; i < n; i++) {
			pairs.add(new HashSet<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			pairs.get(edges[i][0]).add(edges[i][1]);
			pairs.get(edges[i][1]).add(edges[i][0]);
		}
		for (int i = 0; i < n; i++) {
			if (pairs.get(i).size() == 1)
				points.add(i);
		}
		while (n > 2) {
			List<Integer> tmp = new LinkedList<Integer>();
			n -= points.size();
			for (int point : points) {
				for (int m : pairs.get(point)) {
					pairs.get(point).remove(m);
					pairs.get(m).remove(point);

					if (pairs.get(m).size() == 1)
						tmp.add(m);
				}
			}
			points = tmp;
		}

		return points;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees mht = new MinimumHeightTrees();
		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		System.out.println(mht.findMinHeightTrees(4, edges));
	}

}
