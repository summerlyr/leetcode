import java.util.LinkedList;
import java.util.List;

public class NQueens {

	List<String[]> result = new LinkedList<String[]>();

	public List<String[]> solveNQueens(int n) {

		if (n == 0)
			return result;
		int[] x = new int[n + 1];
		queen(1, n, x);
		return result;
	}

	public void queen(int t, int n, int[] x) {
		if (t > n && n > 0) {
			String[] cur = new String[n];
			for (int i = 1; i <= n; i++) {
				String s = "";
				for (int j = 0; j < n; j++) {
					if (x[i] == j + 1) {
						s += "Q";
					} else {
						s += ".";
					}
				}
				cur[i - 1] = s;
			}
			result.add(cur);
		} else {
			for (int i = 1; i <= n; i++) {
				x[t] = i;
				if (place(t, x)) {
					queen(t + 1, n, x);
				}
			}
		}
	}

	public boolean place(int k, int[] x) {
		for (int i = 1; i < k; i++)// �ж�ǰk���ʺ���û�����k���ʺ��ͻ
		{
			if (Math.abs(k - i) == Math.abs(x[k] - x[i]) || x[k] == x[i]) // ��һ����ʾ�Խ��߳�ͻ���ڶ�����ʾ�г�ͻ������������Ϊ���ģ����Եڼ����ʺ���ڵڼ���
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		System.out.println(nq.solveNQueens(4));

	}

}
