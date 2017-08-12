import java.util.Scanner;

/**
 * @author ZYJ
 * @version 创建时间：Jul 30, 2017 6:08:16 AM
 * @Details 一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
 *          BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串 AABBCCAABB
 *          不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
 *          你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。 输入描述:
 * 
 *          输入一个整数n，表示字符串长度(1 ≤ n ≤ 30)
 * 
 * 
 * 
 *          输出描述:
 * 
 *          输出一个整数表示有多少个暗黑字符串
 * 
 * 
 *          输入例子1:
 * 
 *          2 3
 * 
 * 
 *          输出例子1:
 * 
 *          9 21
 */
public class DarkNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = new Scanner(System.in).nextInt();
		System.out.println(getDarkNum(n));
	}

	private static int getDarkNum(int n) {
		// TODO Auto-generated method stub
		//假设一个长度为n的字符串是黑暗的，
		//假设该字符串中，子串{n-2,n-1,n}的第n个字符的可能性由第n-1和第n-2个字符决定，那么可以推出第n个字符的可能性f(n) = x*d(n)+ y*s(n),
		//其中d(n)表示该子串{n-2,n-1,n}的前两个字符不相同，如AB#，s(n)表示相同，如AA#。那么f(n)=2d(n)+3s(n),
		//than f(n) = 2*(d(n) + s(n)) +s(n), besides, d(n) IN {AB#,AC#,BC#,BA#,BC#,CA#,CB#}, S(n) IN {AA#,BB#,CC#} ,
		// SO, 	d(n)+s(n)=f(n-1);
		// More, for 4 words,s(n) in {#AA#,#BB#,#CC#} => S(N)=s(n-1)+d(n-1), in other word, {AAA#,BBB#,CCC#}+{[B,C]AA#,[A,C]BB#,[A,B]CC#}
		// => f(n) = 2f(n-1)+s(n-1)+d(n-1)=2f(n-1)+f(n-2), We can using dynamic planing to solve it.
		
		int f1 = 3;
		int f2 = 9;
		int f3 = 0;
		if(n==1) return f1;
		if(n==2) return f2;
		for(int i=3;i<=n;i++){
			f3 = 2*f2 + f1;
			f2 = f3;
			f1 = f2;
		}
		return f3;
	}

}
