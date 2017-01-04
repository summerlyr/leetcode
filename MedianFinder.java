
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

	Queue<Integer> large = new PriorityQueue<Integer>();
	Queue<Integer> small = new PriorityQueue<Integer>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		large.add(num);
		small.add(-large.poll());
		if (large.size() < small.size()) {
			large.add(-small.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (large.size() > small.size()) {
			return large.peek();
		} else {
			return (large.peek() - small.peek()) / 2.0;
		}
	}
};