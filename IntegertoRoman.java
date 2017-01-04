
public class IntegertoRoman {

	public String intToRoman(int num) {
		int length = Integer.toString(num).length();
		String number = Integer.toString(num);
		if (length < 4) {
			for (int i = 0; i < 4 - length; i++) {
				number = "0" + number;
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			String cur = number.substring(i, i + 1);
			if (cur == "0") {
				continue;
			}
			if (i == 0) {
				if (cur != "0") {
					for (int j = 0; j < Integer.parseInt(cur); j++) {
						result.append("M");
					}
				}
			}
			if (i == 1) {
				if (cur.equals("9")) {
					result.append("CM");
				} else if (cur.equals("4")) {
					result.append("CD");
				} else if (cur.equals("5")) {
					result.append("D");
				} else if (Integer.parseInt(cur) >= 6) {
					result.append("D");
					for (int j = 0; j < Integer.parseInt(cur) - 5; j++) {
						result.append("C");
					}
				} else if (Integer.parseInt(cur) <= 3) {
					for (int j = 0; j < Integer.parseInt(cur); j++) {
						result.append("C");
					}
				}
				continue;
			}
			if (i == 2) {
				if (cur.equals("9")) {
					result.append("XC");
				} else if (cur.equals("4")) {
					result.append("XL");
				} else if (cur.equals("5")) {
					result.append("L");
				} else if (Integer.parseInt(cur) >= 6) {
					result.append("L");
					for (int j = 0; j < Integer.parseInt(cur) - 5; j++) {
						result.append("X");
					}
				} else if (Integer.parseInt(cur) <= 3) {
					for (int j = 0; j < Integer.parseInt(cur); j++) {
						result.append("X");
					}
				}
				continue;
			}
			if (i == 3) {
				if (cur.equals("9")) {
					result.append("IX");
				} else if (cur.equals("4")) {
					result.append("IV");
				} else if (cur.equals("5")) {
					result.append("V");
				} else if (Integer.parseInt(cur) >= 6) {
					result.append("V");
					for (int j = 0; j < Integer.parseInt(cur) - 5; j++) {
						result.append("I");
					}
				} else if (Integer.parseInt(cur) <= 3) {
					for (int j = 0; j < Integer.parseInt(cur); j++) {
						result.append("I");
					}
				}
				continue;
			}
		}
		return result.toString();
	}

	public String intToRoman2(int num) {
		int f = num / 1000;
		num = num % 1000;
		int s = num / 100;
		num = num % 100;
		int t = num / 10;
		num = num % 10;
		int g = num;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < f; i++) {
			res.append("M");
		}
		if (s == 9) {
			res.append("CM");
		} else if (s == 4) {
			res.append("CD");
		} else if (s >= 5) {
			res.append("D");
			s = s - 5;
			for (int i = 0; i < s; i++) {
				res.append("C");
			}
		} else {
			for (int i = 0; i < s; i++) {
				res.append("C");
			}
		}

		if (t == 9) {
			res.append("XC");
		} else if (t == 4) {
			res.append("XL");
		} else if (t >= 5) {
			res.append("L");
			t = t - 5;
			for (int i = 0; i < t; i++) {
				res.append("X");
			}
		} else {
			for (int i = 0; i < t; i++) {
				res.append("X");
			}
		}

		if (g == 9) {
			res.append("IX");
		} else if (g == 4) {
			res.append("IV");
		} else if (g >= 5) {
			res.append("V");
			g = g - 5;
			for (int i = 0; i < g; i++) {
				res.append("I");
			}
		} else {
			for (int i = 0; i < g; i++) {
				res.append("I");
			}
		}
		return res.toString();
	}

	public String intToRoman3(int num) {
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				sb.append(strs[i]);
				num = num - values[i];
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegertoRoman ir = new IntegertoRoman();
		System.out.println(ir.intToRoman(1990));
	}

}
