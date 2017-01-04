public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		int length = A.length;
		if (length == 0) {
			return 0;
		}

		for (int i = 0; i < length; i++) {
			if (A[i] == elem) {
				A[i] = A[length - 1];
				i--;
				length--;

			}
		}
		return length;
	}

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		int[] A = { 4, 5 };
		System.out.println(re.removeElement(A, 5));
		System.out.println(A[0]);

	}

}
