import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		if (numerator > 0 ^ denominator > 0)
			sb.append("-");// 负号
		// 注意这里要把两个数字转成long,num*10之后有可能越界
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		// int num = numerator;
		// int den = denominator;
		sb.append(num / den);// 整数部分
		num = num % den;
		if (num == 0)
			return sb.toString();// 没有小数部分
		sb.append(".");
		// map用来记录当前出现的数字在第几个位置
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(num, sb.length());
		while (num != 0) {
			num = num * 10;
			sb.append(num / den);
			num = num % den;
			// 一旦num出现重复了，后面也会继续重复
			if (map.containsKey(num)) {
				int index = map.get(num);
				sb.insert(index, "(");
				sb.append(")");
				break;
			} else {
				map.put(num, sb.length());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractiontoRecurringDecimal fr = new FractiontoRecurringDecimal();
		System.out.println(fr.fractionToDecimal(2, 7));
	}

}
