import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> iterator;
	boolean hasPeek;
	int peekElement;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
		hasPeek = false;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (!hasPeek) {
			hasPeek = true;
			peekElement = iterator.next();
		}
		return peekElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (!hasPeek) {
			return iterator.next();
		}
		int tmp = peekElement;
		hasPeek = false;
		return tmp;
	}

	@Override
	public boolean hasNext() {
		return hasPeek || iterator.hasNext();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}