package JingDong;

import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月8日 下午7:43:59 
* @Details 
*/
public class Main2 {
	 public static long gcd(long a,long b){
		    return (a % b == 0) ? b : gcd(b,a%b);
	  }
	 static int MOD = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long cnt = (long)(n*n+n*(n-1))%MOD;
		for(int i =2;Math.pow(i, 2)<=n;i++) {
			int pow = 1;
			long num = (long) Math.pow(i, 2);
			
			while(num<=n) {
				pow++;
				num *=i;
			}
			for(int x=1;x<=pow;x++) {
				for(int y=x+1;y<=pow;y++) {
					cnt += (n / Math.max(x/gcd(x, y), y/gcd(x, y)))*(long)2;
					cnt %= MOD;
				}
			}
		}
		System.out.println(cnt);
	}

}
