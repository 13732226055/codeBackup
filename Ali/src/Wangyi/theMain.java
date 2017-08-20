package Wangyi;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月12日 上午9:26:51 
* @Details 
*/
public class theMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long x= scan.nextInt();
		long f= scan.nextInt();
		long d = scan.nextInt();
		long p = scan.nextInt();
		System.out.println(getMaxDay(x,f,d,p));
		
	}

	private static long getMaxDay(long x, long f, long d, long p) {
		// TODO Auto-generated method stub
		if(d<x || f<1 || d<1 || x<1 ||p<1) return 0;
		if(d/x<=f) return d/x;
		else return (d+f*p)/(x+p);
		
	}

}
