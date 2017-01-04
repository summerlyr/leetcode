import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			result.add(intervals.get(i));
			i++;
		}
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		result.add(newInterval);
		while (i < intervals.size()) {
			result.add(intervals.get(i));
			i++;
		}

		return result;
	}

	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		int count = 0;
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		while (count < intervals.size() && intervals.get(count).end < newInterval.start) {
			count++;
		}
		while (count < intervals.size() && intervals.get(count).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(count).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(count).end);
			intervals.remove(count);
		}
		intervals.add(count, newInterval);
		return intervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
