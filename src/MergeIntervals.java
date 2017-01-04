import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval obj0, Interval obj1) {
				return obj0.start - obj1.start;
			}
		});
		for (int i = 0; i < intervals.size();) {
			Interval newInter = intervals.get(i);
			while (i < intervals.size() - 1 && newInter.end >= intervals.get(i + 1).start) {
				newInter.end = Math.max(newInter.end, intervals.get(i + 1).end);
				i++;
			}
			result.add(newInter);
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals mi = new MergeIntervals();
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(4, 5));
		System.out.println(mi.merge(intervals).get(1).end);
	}

}
