import java.util.HashMap;

import java.util.Map;

public class MaxPointsonaLine {

	public int maxPoints(Point[] points) {
		int n = points.length;
		int max = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		for (int i = 0; i < n; i++) {
			int samep = 0;
			int samex = 1;
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (points[i].x == points[j].x && points[i].y == points[j].y) {
						samep++;
					}
					if (points[i].x == points[j].x) {
						samex++;
						continue;
					}
					double delta = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
					if (map.containsKey(delta)) {
						map.put(delta, map.get(delta) + 1);
					} else {
						map.put(delta, 2);
					}
					max = Math.max(max, map.get(delta) + samep);
				}
			}
			max = Math.max(max, samex);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
