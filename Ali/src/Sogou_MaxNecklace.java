import java.util.Arrays;
import java.util.Scanner;

/*
 * 
有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，
但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，
这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。
如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。 
输入描述:
我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等
，我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。每行代表一种情况。


输出描述:
输出学者能够拿到的最多的宝石数量。每行一个

输入例子1:
ABCYDYE
ATTMBQECPD

输出例子1:
1
3
 */
public class Sogou_MaxNecklace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String necklace = scanner.nextLine();
		System.out.println(getMaxNecklace(necklace));
	}

	private static int getMaxNecklace(String necklace) {
		// TODO Auto-generated method stub	
		int[] x = new int[5];
		int length = necklace.length();
		StringBuffer necklaces = new StringBuffer(necklace);
		int last_pos = length;
		for (int i = 0; i < length; i++) {
			x[0] = necklaces.indexOf("A");
			x[1] = necklaces.indexOf("B");
			x[2] = necklaces.indexOf("C");
			x[3] = necklaces.indexOf("D");
			x[4] = necklaces.indexOf("E");
			Arrays.sort(x);
			if (last_pos > x[4]) {
				last_pos = x[4];
			}
			if(x[0] == -1) return 0;
			necklaces.append(necklaces.charAt(0));
			necklaces.deleteCharAt(0);
			
		}
		return length - last_pos - 1;
	}
}
