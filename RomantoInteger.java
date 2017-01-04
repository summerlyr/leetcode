import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

	public int romanToInt(String s) {
		if (s.length() == 0)
			return 0;
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char cur = s.charAt(i);
			switch (cur) {
			case 'I':// 1
				result += 1 * (result >= 5 ? -1 : 1);
				break;
			case 'V':// 5
				result += 5;
				break;
			case 'X':// 10
				result += 10 * (result >= 50 ? -1 : 1);
				break;
			case 'L':// 50
				result += 50;
				break;
			case 'C':// 100
				result += 100 * (result >= 500 ? -1 : 1);
				break;
			case 'D':// 500
				result += 500;
				break;
			case 'M':// 1000
				result += 1000;
				break;
			}
		}
		return result;
	}

	public int romanToInt2(String s) {
		if (s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int result = map.get(s.charAt(s.length() - 1));
		int pivot = result;
		for (int i = s.length() - 2; i >= 0; i--) {
			int curr = map.get(s.charAt(i));
			if (curr >= pivot) {
				result += curr;
			} else {
				result -= curr;
			}
			pivot = curr;
		}
		return result;
	}

	public int romanToInt3(String s) {
		if (s.length() == 0)
			return 0;
		int result = 0;
		if (s.indexOf("IV") != -1)
			result -= 2;
		if (s.indexOf("IX") != -1)
			result -= 2;
		if (s.indexOf("XL") != -1)
			result -= 20;
		if (s.indexOf("XC") != -1)
			result -= 20;
		if (s.indexOf("CD") != -1)
			result -= 200;
		if (s.indexOf("CM") != -1)
			result -= 200;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I')
				result += 1;
			if (s.charAt(i) == 'V')
				result += 5;
			if (s.charAt(i) == 'X')
				result += 10;
			if (s.charAt(i) == 'L')
				result += 50;
			if (s.charAt(i) == 'C')
				result += 100;
			if (s.charAt(i) == 'D')
				result += 500;
			if (s.charAt(i) == 'M')
				result += 1000;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
