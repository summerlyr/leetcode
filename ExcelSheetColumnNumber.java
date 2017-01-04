public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		int length = s.length();
		int sum = 0;
		for (int i = 0; i < length; i++) {
			char current = s.charAt(i);
			int tmp = current - 'A' + 1;
			sum = sum * 26 + tmp;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnNumber esc = new ExcelSheetColumnNumber();
		System.out.println(esc.titleToNumber("AAA"));
	}

}
