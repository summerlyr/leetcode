import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		int length1 = pattern.length();
		String[] strarr = str.split(" ");
		int length2 = strarr.length;
		if (length1 != length2) {
			return false;
		}
		Map<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < length1; i++) {
			char curc = pattern.charAt(i);
			String curstr = strarr[i];
			if (map.containsKey(curc)) {
				if (!map.get(curc).equals(curstr)) {
					return false;
				}
			} else if (map.containsValue(curstr)) {
				return false;
			} else {
				map.put(curc, curstr);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
