package JingDong;

import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月8日 下午6:23:14 
* @Details 
一个数A，它的2-(A-1)进制表示为A(2),A(3),.... 它们的各个位上的数相加为B(2),B(3)....
求所有的B的均值x/y(不可约分的形式)
*/
public class SumEverySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//求各个进制的各个位相加的和
		int sum = 0;
		for (int i = 2; i < n; i++) {
			int num = n;
			while(num>0) {
				sum += num%i;
				num /= i;
			}
		}
		//求分数形式，一共有2，3，4，。。。，n-1个进制，那么分母就是n-2,分子是sum，然后用gcd求最大公约数进行约分。
		int numerator = gcd(sum,n-2);
		System.out.println((sum/numerator)+"/"+((n-2)/numerator));
		
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		if(a<b) {
			int tmp = a;
			a =b;
			b=a;
		}
		int r = a%b;
		while(r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

}
