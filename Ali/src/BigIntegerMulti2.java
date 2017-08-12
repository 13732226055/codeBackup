import java.math.BigInteger;

/**
 * @author ZYJ
 * @version 创建时间：Aug 6, 2017 7:59:41 PM
 * @Details 使用分治法实现，如果有n位长度的数字N=AB,A为N的前n/2位，B为N的后n/2位，同时M=CD，那么
 *          N*M=A*C*10^n+(A*D+B*C)*10^(n/2)+B*D；------------------------------公式1
 *          但是这样计算需进行4次n/2位整数的乘法，3次加法和2次位移（×10^n和×10^(n/2)),算法复杂度为O(n^2),所以需简化为：
 *          N×M=A×C×10^n+[(A-B)(D-C)+A*C+B*D]*10^(n/2)+B*D;--------------------公式2
 *          这样一共需要进行3次O(n)的n/2位整数的乘法，6次O(n/2)的ABCD加减乘除运算和2次位移运算，1次O（1）的B×D，
 *          故算法复杂度为O(n^log3).
 *          具体的算法视线中，A×B的运算如果A，B都小于9位，那么计算结果不大于9+9=18位，可以直接用long的
 *          相乘运算，因为java中long的范围为64位，即19个整数位。
 * 
 *          同时我们需要用字符串模拟加法，减法，乘法和位移运算。
 */
public class BigIntegerMulti2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String N = "12345678900987654321";
		String M = "0";
		System.out.println(getBigIntegerMulti(M, N));
		BigInteger b1 = new BigInteger(M);
		System.out.println(b1.multiply(new BigInteger(N)));
		
	}

	private static String getBigIntegerMulti(String m, String n) {
		// TODO Auto-generated method stub
		// 模拟了加法减法位移后模拟乘法
		
		String negative = ((((m.charAt(0) & 16) >> 4) ^ ((n.charAt(0) & 16) >> 4)) == 0) ? "" : "-"; // 正负号
		
		m = m.replaceFirst("-", "");
		n = n.replaceFirst("-", "");
		if (m.length() <= 9 && n.length() <= 9) {
			
			//System.out.println("OUT: "+negative + String.valueOf(Long.parseLong(m) * Long.parseLong(n)));
			return negative + String.valueOf(Long.parseLong(m) * Long.parseLong(n));
		}
		if(m.length()>n.length()) n = LeftPad(n, m.length()-n.length());
		else m = LeftPad(m, n.length()-m.length());
		String a, b, c, d;
		if (m.length() <= 9) {
			a = "0";
			b = m;
		} else if (m.length() % 2 != 0)
			m = "0" + m;
		a = m.substring(0, m.length() / 2 );
		b = m.substring(m.length() / 2, m.length() );
		if (n.length() <= 9) {
			c = "0";
			d = n;
		} else if (n.length() % 2 != 0)
			n = "0" + n;
		c = n.substring(0, n.length() / 2 );
		d = n.substring(n.length() / 2, n.length() );
		
		
		int power = Math.max(n.length(), m.length());
		String part1 = getBigIntegerMulti(a, c);
		String part2 = getBigIntegerMulti(subtract(a, b), subtract(d, c));
		String part3 = add(getBigIntegerMulti(a, c), getBigIntegerMulti(b, d));
		
		String part4 = add(part2, part3);
		String part5 = getBigIntegerMulti(b, d);
		String part6 = add(power10(part1, power), power10(part4, power/2));
		return negative + add(part6, part5);
	}

	private static String power10(String str, int n) {
		StringBuffer sb = new StringBuffer(str);
		while (n > 0) {
			sb.append("0");
			n--;
		}
		
		return sb.toString();
	}

	private static String add(String m, String n) {
		// 模拟加法运算时需要判断正负号
		int sign = 0;
		
		if (m.charAt(0) == '-' && n.charAt(0) == '-') {
			m = m.replaceAll("-", "");
			n = n.replaceAll("-", "");
			sign = 1;
		}
		if (m.charAt(0) == '-' && n.charAt(0) != '-') {
			m = m.replaceAll("-", "");
			return subtract(n, m);
		}
		if (m.charAt(0) != '-' && n.charAt(0) == '-') {
			n = n.replaceAll("-", "");
			return subtract(m, n);
		}
		int flag = 0; // 加法进位；
		StringBuffer sb = new StringBuffer();
		if (m.length() > n.length())
			n = LeftPad(n, m.length() - n.length());
		if (m.length() < n.length())
			m = LeftPad(m, n.length() - m.length());
		for (int i = m.length() - 1; i >= 0; i--) {
			int tmp = m.charAt(i) + n.charAt(i) + flag - 96;
			int diff = tmp % 10;
			flag = tmp / 10;
			sb.insert(0, String.valueOf(diff));
			
		}
		String string;
		if (flag == 1) {
			sb.insert(0, "1");
			string = sb.toString();
		} else {
			string = sb.toString().replaceFirst("^0+", "");
		}
		if (sign == 1)
			string = "-" + string;
		
		return (string.equals(""))? "0":string;

	}

	private static String subtract(String m, String n) {
		// 因公式2中减法运算的相减数ABCD都为正整数，所以不需要事先对符号进行处理
		int compares = compare(m, n);
		if (compares < 0) {// 比较保证大数减小数
			String tmp = m;
			m = n;
			n = tmp;
		}
		if (compares == 0)
			return "0";
		n = LeftPad(n, m.length() - n.length()); // 不足补0
		int flag = 0;// 进位标志
		StringBuffer result = new StringBuffer();
		for (int i = m.length() - 1; i >= 0; i--) {
			int tmp = m.charAt(i) - n.charAt(i) - flag;
			flag = 0;
			if (tmp < 0) {
				flag = 1;
				tmp += 10;
			}
			result.insert(0, tmp);
		}
		String resultStr = result.toString().replaceAll("^0+", "");
		if(resultStr==null) return "0";
		if (compares < 0) {
			resultStr = "-" + resultStr;
		}

		return resultStr;
	}

	private static String LeftPad(String n, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < i; j++) {
			n = "0" + n;
		}
		return n;
	}

	private static int compare(String m, String n) {
		// TODO Auto-generated method stub
		if (m.length() > n.length())
			return 1;
		else if (m.length() < n.length())
			return -1;
		else {
			for (int i = 0; i < m.length(); i++) {
				if (m.charAt(i) > n.charAt(i))
					return 1;
				else if (m.charAt(i) < n.charAt(i))
					return -1;
			}
		}
		return 0;
	}

}
