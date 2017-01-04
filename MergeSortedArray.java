
public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {
		/*
		 * ArrayList<Integer> list = new ArrayList(); for(int i=0;i<m;i++) {
		 * list.add(A[i]); } for(int i=0;i<n;i++) { list.add(B[i]); }
		 * Collections.sort(list); for(int i=0;i<m+n;i++) { A[i] = list.get(i);
		 * }
		 */

		int length = m + n - 1;
		int i = m - 1, j = n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[length--] = A[i--];
			} else {
				A[length--] = B[j--];
			}
		}
		while (j >= 0) {
			A[length--] = B[j--];
		}

	}

}
