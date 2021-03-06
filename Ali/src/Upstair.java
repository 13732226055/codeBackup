import java.util.Scanner;
/** 
* @author ZYJ 
* @version 创建时间：Jul 24, 2017 9:55:18 PM 
* @Details 
3、走台阶问题

有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 100000
给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
测试样例：
1
返回：1
*/
public class Upstair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = new Scanner(System.in).nextInt();
		for(int i=0;i<=n;i++)
			if(countUpstair(n)!=countUpstair2(n)) System.out.println(false);;
		System.out.println(true);
		System.out.println(countUpstair(n));
		System.out.println(countUpstair2(n));
	}

	private static int countUpstair(int n) {
		// TODO Auto-generated method stub
		int dp[][] = new int[3][n+1];
		for(int i =0 ;i<=n;i++)
			dp[1][i]=1;
		
		//System.out.println(dp[0][0]);
		//countWays.breath(dp);
		
		for(int j=0;j<=n;j++){
			dp[2][j] = (j>1)? dp[2][j-2]+dp[2][j-1]:1;
			//countWays.breath(dp);
		}
	
		return dp[2][n];
	}
	// f(n)=f(n-1)+f(n-2);
	public static int countUpstair2(int n ){
		int f1=1%10000007;
		int f2=2%10000007;
		int f3=f1+f2;
		for(int i =3;i<=n;i++){
			f3=(f1+f2)%10000007;
			f1=f2;
			f2=f3;
		}
		return f3;
	}

}
