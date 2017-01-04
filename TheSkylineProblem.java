import java.util.LinkedList;
import java.util.List;

public class TheSkylineProblem {

	public List<int[]> getSkyline(int[][] buildings) {
		if (buildings.length == 0) {
			return new LinkedList<int[]>();
		} else {
			return help(buildings, 0, buildings.length - 1);
		}
	}

	public List<int[]> help(int[][] buildings, int start, int end) {
		List<int[]> res = new LinkedList<int[]>();
		if (start < end) {
			int mid = start + (end - start) / 2;
			return merge(help(buildings, start, mid), help(buildings, mid + 1, end));
		} else {
			int[] s = new int[] { buildings[start][0], buildings[start][2] };
			int[] e = new int[] { buildings[start][1], 0 };
			res.add(s);
			res.add(e);
			return res;
		}
	}

	public List<int[]> merge(List<int[]> l1, List<int[]> l2) {
		List<int[]> res = new LinkedList<int[]>();
		int h1 = 0;
		int h2 = 0;
		while (l1.size() > 0 && l2.size() > 0) {
			int x = 0;
			int h = 0;
			if (l1.get(0)[0] < l2.get(0)[0]) {
				x = l1.get(0)[0];
				h1 = l1.get(0)[1];
				h = Math.max(h1, h2);
				l1.remove(0);
			} else if (l1.get(0)[0] > l2.get(0)[0]) {
				x = l2.get(0)[0];
				h2 = l2.get(0)[1];
				h = Math.max(h1, h2);
				l2.remove(0);
			} else {
				x = l1.get(0)[0];
				h1 = l1.get(0)[1];
				h2 = l2.get(0)[1];
				h = Math.max(h1, h2);
				l1.remove(0);
				l2.remove(0);
			}

			if (res.size() == 0 || h1 != res.get(res.size() - 1)[1]) {
				res.add(new int[] { x, h });
			}
		}
		res.addAll(l1);
		res.addAll(l2);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
