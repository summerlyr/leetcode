public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int h1 = Math.abs(C - A);
		int w1 = Math.abs(D - B);

		int h2 = Math.abs(G - E);
		int w2 = Math.abs(H - F);

		int result = h1 * w1 + h2 * w2;

		if (B >= H || C <= E) {
			return result;
		}
		if (F >= D || A >= G) {
			return result;
		}

		int I = Math.max(A, E);
		int J = Math.max(B, F);
		int K = Math.min(C, G);
		int L = Math.min(D, H);

		int w3 = Math.abs(K - I);
		int h3 = Math.abs(L - J);

		return result - w3 * h3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleArea ra = new RectangleArea();
		System.out.println(ra.computeArea(-2, -2, 2, 2, -3, 3, -4, 4));
	}

}
