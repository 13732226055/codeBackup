package Zhaoshang;


import java.util.Arrays;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月13日 下午7:42:55 
* @Details 
* f[i]表示从i~n-1区间中先手选择时可以获得的最大值，
* s[i]表示从i~n-1区间中在对手选择完后（后手）选择时可以获得的最大值
* 那么就可以得到 f[i] = max(num[i]+s[i+1],num[i]+num[i+1]+s[i+2]),而
* s[i] = min(f[i+1],f[i+2]),因为在对手之后选择时，对手肯定会选最优策略，即f[i+1]与
* f[i+2]中的最大值，那么s[i]就是较小值了。
5
1 2 10 6 1 
*/
public class Main2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int[] ms = new int[m];
		for (int i = 0; i < ms.length; i++) {
			ms[i] = scan.nextInt();
		}
		int[] f =new int[m];
		int[] s = new int[m];
		for(int i=0;i<m;i++) {
			f[i] = ms[i];
		}
		f[m-2] = ms[m-2]+f[m-1];
		for(int i=m-3;i>=0;i--) {
			f[i] = Math.max(ms[i]+s[i+1], ms[i]+ms[i+1]+s[i+2]);
			s[i] =Math.min(f[i+1], f[i+2]);
		}
//		for(int i=m-3;i>=0;i--) {
//			f[i] = Math.max(ms[i]+f[i+1], ms[i]+ms[i+1]+f[i+2]);
//			s[i] =Math.min(f[i+1], f[i+2]);
//		}
//		for(int i=m-3;i>=0;i--) {
//			f[i] = Math.max(ms[i]+f[i+1], ms[i]+ms[i+1]+f[i+2]);
//			s[i] =Math.min(f[i+1], f[i+2]);
//		}
		System.out.println(Arrays.toString(f));
		System.out.println(Arrays.toString(s));
		if(f[0]>s[0])System.out.println("true");
		else System.out.println("false");
	}
}
