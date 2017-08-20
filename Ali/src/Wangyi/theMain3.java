package Wangyi;

import java.util.Scanner;
import java.util.function.IntPredicate;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月12日 下午9:43:11 
* @Details 
小易非常喜欢拥有以下性质的数列:
1、数列的长度为n
2、数列中的每个数都在1到k之间(包括1和k)
3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
例如,当n = 4, k = 7
那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。 
输入描述:
输入包括两个整数n和k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)


输出描述:
输出一个整数,即满足要求的数列个数,因为答案可能很大,输出对1,000,000,007取模的结果。

输入例子1:
2 2

输出例子1:
3

用f(n)表示长度为n的合法数列的数量，那么f(n) = f(n-1)-u(n-1),u(n-1)表示不合法的数量子数列｛1~n-1}中
对于数列｛1~n}不合法的数列的个数。假设｛1~n｝数列的最后两个数字为A，B，那么有 xi*B = A,i=1,2,3,...,u(n-1).
那么我我们可以先算出所有数列的个数,O(nk)，再减去u(n-1),O(nklogk).
我们用dp[i][j]来记录长度为i的并且最后一个字符为j的合法子数列的数量,所以dp[i][j] = dp[i-1][1]+....dp[i-1][x]+..+dp[i-1][k],
其中x!=N. u(n-1) ={####2j,####3j,####4j.....}.
*/
public class theMain3 {
	final static int mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		int[][] dp = new int[n+1][k+1];
		dp[0][1] =1;
		for(int i=1;i<n+1;i++) {
			
			int sum = 0;
			for(int j=1;j<k+1;j++) {
				sum = (sum+dp[i-1][j])%mod;
			}
			for(int j=1;j<k+1;j++) {
				int unlike = 0;
				for(int l=2;l*j<k+1;l++) {
					unlike = (unlike + dp[i-1][l*j])%mod;
				}
				dp[i][j] = (sum-unlike+mod)%mod;
			}
			//countWays.breath(dp);
		}
		int sum = 0;
		for(int i=1;i<k+1;i++) {
			sum = (sum+dp[n][i])%mod;
		}
		System.out.println(sum);
	}
	
}
