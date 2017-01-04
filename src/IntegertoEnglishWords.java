import java.util.HashMap;
import java.util.Map;

public class IntegertoEnglishWords {

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		Map<Integer, String> number = new HashMap<Integer, String>();
		number.put(0, "");
		number.put(1, "One");
		number.put(2, "Two");
		number.put(3, "Three");
		number.put(4, "Four");
		number.put(5, "Five");
		number.put(6, "Six");
		number.put(7, "Seven");
		number.put(8, "Eight");
		number.put(9, "Nine");
		number.put(10, "Ten");
		number.put(11, "Eleven");
		number.put(12, "Twelve");
		number.put(13, "Thirteen");
		number.put(14, "Fourteen");
		number.put(15, "Fifteen");
		number.put(16, "Sixteen");
		number.put(17, "Seventeen");
		number.put(18, "Eighteen");
		number.put(19, "Nineteen");
		number.put(20, "Twenty");
		number.put(30, "Thirty");
		number.put(40, "Forty");
		number.put(50, "Fifty");
		number.put(60, "Sixty");
		number.put(70, "Seventy");
		number.put(80, "Eighty");
		number.put(90, "Ninety");
		number.put(100, "Hundred");

		String numstring = num + "";
		String result = "";
		int count = 0;
		int length = numstring.length() - 1;
		while (count < numstring.length()) {
			String current = numstring.substring(count, count + 1);
			if ((!current.equals("0"))) {
				if (length >= 0 && length < 3) {
					if (length % 3 == 0) {
						result += number.get(Integer.parseInt(current)) + " ";
					} else if (length % 3 == 1) {
						if (current.equals("1")) {
							count++;
							length--;
							result += number.get(Integer.parseInt(current + numstring.substring(count, count + 1)))
									+ " ";
						} else {
							result += number.get(Integer.parseInt(current + "0")) + " ";
							if (numstring.substring(count + 1, count + 2).equals("0")) {
								count++;
								length--;
								result += "";
							}
						}
					} else if (length % 3 == 2) {

						result += number.get(Integer.parseInt(current)) + " " + "Hundred ";

					}
				} else if (length >= 3 && length < 6) {
					if (length % 3 == 0) {
						result += number.get(Integer.parseInt(current)) + " " + "Thousand" + " ";
					} else if (length % 3 == 1) {
						if (current.equals("1")) {
							count++;
							length--;
							result += number.get(Integer.parseInt(current + numstring.substring(count, count + 1)))
									+ " " + "Thousand" + " ";
						} else {
							result += number.get(Integer.parseInt(current + "0")) + " ";
							if (numstring.substring(count + 1, count + 2).equals("0")) {
								count++;
								length--;
								result += "Thousand" + " ";
							}
						}
					} else if (length % 3 == 2) {

						result += number.get(Integer.parseInt(current)) + " " + "Hundred" + " ";
						if (numstring.substring(count + 1, count + 2).equals("0")
								&& numstring.substring(count + 2, count + 3).equals("0")) {
							count++;
							length--;
							count++;
							length--;
							result += "Thousand" + " ";
						}

					}
				} else if (length >= 6 && length < 9) {
					if (length % 3 == 0) {
						result += number.get(Integer.parseInt(current)) + " " + "Million" + " ";
					} else if (length % 3 == 1) {
						if (current.equals("1")) {
							count++;
							length--;
							result += number.get(Integer.parseInt(current + numstring.substring(count, count + 1)))
									+ " " + "Million" + " ";
						} else {
							result += number.get(Integer.parseInt(current + "0")) + " ";
							if (numstring.substring(count + 1, count + 2).equals("0")) {
								count++;
								length--;
								result += "Million" + " ";
							}
						}
					} else if (length % 3 == 2) {

						result += number.get(Integer.parseInt(current)) + " " + "Hundred" + " ";
						if (numstring.substring(count + 1, count + 2).equals("0")
								&& numstring.substring(count + 2, count + 3).equals("0")) {
							count++;
							length--;
							count++;
							length--;
							result += "Million" + " ";
						}

					}
				} else if (length >= 9 && length < 12) {
					if (length % 3 == 0) {
						result += number.get(Integer.parseInt(current)) + " " + "Billion" + " ";
					} else if (length % 3 == 1) {
						if (current.equals("1")) {
							count++;
							length--;
							result += number.get(Integer.parseInt(current + numstring.substring(count, count + 1)))
									+ " " + "Billion" + " ";
						} else {
							result += number.get(Integer.parseInt(current + "0")) + " ";
							if (numstring.substring(count + 1, count + 2).equals("0")) {
								count++;
								length--;
								result += "Billion" + " ";
							}
						}
					} else if (length % 3 == 2) {

						result += number.get(Integer.parseInt(current)) + " " + "Hundred" + " ";
						if (numstring.substring(count + 1, count + 2).equals("0")
								&& numstring.substring(count + 2, count + 3).equals("0")) {
							count++;
							length--;
							count++;
							length--;
							result += "Billion" + " ";
						}
					}
				}
			}

			count++;
			length--;

		}
		return result.trim();

	}

	private final String[] lessThan20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	private final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	public String numberToWords2(int num) {
		if (num == 0)
			return "Zero";
		int[] a = new int[4];
		StringBuilder sb = new StringBuilder();
		for (int i = 3; i >= 0; i--) {
			a[i] = num % 1000;
			num = num / 1000;
		}
		if (help(a[0]).length() > 0) {
			sb.append(help(a[0])).append("Billion ");
		}
		if (help(a[1]).length() > 0) {
			sb.append(help(a[1])).append("Million ");
		}
		if (help(a[2]).length() > 0) {
			sb.append(help(a[2])).append("Thousand ");
		}
		if (help(a[3]).length() > 0) {
			sb.append(help(a[3]));
		}
		return sb.toString().trim();
	}

	public String help(int num) {
		if (num == 0)
			return "";
		else if (num < 20)
			return lessThan20[num] + " ";
		else if (num < 100)
			return tens[num / 10] + " " + help(num % 10);
		else if (num >= 100)
			return lessThan20[num / 100] + " Hundred " + help(num % 100);
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
