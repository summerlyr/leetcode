
import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators {

	public List<String> addOperators(String num, int target) {
		List<String> result = new LinkedList<String>();
		if (num.length() == 0)
			return result;
		helper(result, "", num, target, 0, 0, 0);
		return result;
	}

	public void helper(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
		if (pos == num.length() && eval == target) {
			result.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (num.charAt(pos) == '0' && i != pos)
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(result, path + cur, num, target, i + 1, cur, cur);
			} else {
				helper(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);
				helper(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
				helper(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);// Ҫ�ȼ�ȥ֮ǰ�ĳ˷�������ʽ�ӣ�Ҫ��Ȼ�ͻ������
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
