public class JumpGame {

	public boolean canJump(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++)// ���Ը�����ÿһ���Ͽ��Ե�������ֵ
		{
			if (max >= A.length - 1) {
				return true;
			} else if (A[i] + i > max) {
				max = A[i] + i;
			} else if (max == i) {
				return false;
			}
		}
		return true;
	}
	/*
	 * for(int i=0;i<A.length;) { if(A[i] == 0 && i!=A.length-1) { int offset =
	 * 0; while(i>0) { i--; offset++; if(A[i]>offset) { i += A[i]; break; } }
	 * if(i<=0) { return false; }
	 * 
	 * } else if(i >= A.length-1) { return true; } else { i += A[i]; } } return
	 * true;
	 */

	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] a = { 3, 2, 1, 0, 4 };
		System.out.println(jg.canJump(a));

	}

}
