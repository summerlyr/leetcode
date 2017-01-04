public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] A) {

		if (A.length == 0) {
			return 0;
		}
		int count = 1;
		int[] AA = new int[A.length];
		int current = A[0];
		AA[0] = current;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != current) {
				current = A[i];
				AA[count++] = A[i];
			}
		}

		for (int i = 0; i < AA.length; i++) {
			A[i] = AA[i];
		}
		return count;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray rdfs = new RemoveDuplicatesfromSortedArray();
		int[] A = { 1, 1, 2 };
		System.out.println(rdfs.removeDuplicates(A));
		System.out.println(A[0] + "*0");
		System.out.println(A[1] + "*1");
		System.out.println(A[2] + "*2");

	}

}
