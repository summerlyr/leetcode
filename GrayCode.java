import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		for (int i = 0; i < n; i++) {
			int s = 1;
			s = s << i;
			for (int j = result.size() - 1; j >= 0; j--) {
				result.add(result.get(j) + s);
			}
		}
		return result;
	}

	public List<Integer> grayCode2(int n) {
		List<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < 1 << n; i++) {
			res.add(i ^ (i >> 1));
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
