public class ZigZagConversion {

	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		int length = s.length();
		int col = 1000;
		String[][] result = new String[nRows][col];
		int count = 0;
		for (int i = 0; i < col && count < length; i++) {
			if (i % (nRows - 1) == 0) {
				for (int j = 0; j < nRows && count < length; j++) {
					result[j][i] = s.charAt(count) + "";
					count++;
				}
			} else {
				result[nRows - i % (nRows - 1) - 1][i] = s.charAt(count) + "";
				count++;
			}
		}
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if (result[i][j] != null) {
					res.append(result[i][j]);
				}

			}
			// res += " ";
		}
		return res.toString();
	}

	public String convert2(String s, int numRows) {
		if (s.length() == 0 || numRows <= 1)
			return s;
		int length = s.length();
		StringBuilder[] res = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			res[i] = new StringBuilder();
		}
		int i = 0;
		while (i < length) {
			for (int j = 0; j < numRows && i < length; j++) {
				res[j].append(s.charAt(i++));
			}
			for (int j = numRows - 2; j >= 1 && i < length; j--) {
				res[j].append(s.charAt(i++));
			}
		}
		for (i = 1; i < numRows; i++) {
			res[0].append(res[i]);
		}
		return res[0].toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert("ABCDEFGHIJKLMNOPQ", 4));
	}

}
