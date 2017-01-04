
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		String result = "";
		while (n > 0) {
			int remain = (n - 1) % 26;
			n = (n - 1) / 26;
			result = (char) ('A' + remain) + result;
		}
		return result;
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		System.out.println(esct.convertToTitle(5678));
	}

}
