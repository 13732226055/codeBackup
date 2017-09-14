import java.nio.charset.spi.CharsetProvider;
import java.util.Arrays;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月14日 上午9:07:58 
* @Details 
最长公共子序列和最长公共上升子序列问题
abcbdabc
bdcabac

*/
public class LCSAndLCIS {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] s1 = scan.nextLine().toCharArray();
		char[] s2 = scan.nextLine().toCharArray();
		String lcs = LCS(s1,s2);
		System.out.println(lcs);
		//LCIS解法一： lcis为lcs其本身与排序后的lcs的最长公共子序列
		char[] lcs_nature = lcs.toCharArray();
		char[] lcs_sorted = lcs.toCharArray();
		Arrays.sort(lcs_sorted);
		String lcis = LCS(lcs_nature,lcs_sorted);
		System.out.println(lcis);
		//LCIS解法二：仍然用dp，其推导公式为：
		//dp[n] = max(dp[i])+1,其中str[i]<str[n],0<i<n且n!=1
		//得到了dp[n]之后，再从dp回溯推出对应的字符串
		//找到dp的最大值dp[i]，再从[0,i]找到dp[j] = dp[i-1]且s[i]<s[j]的值。。。
		char[] lcs_dp =lcs.toCharArray();
		int[] dp2 = new int[lcs.length()];
		for (int i = 0; i < dp2.length; i++) {
			dp2[i] = 1;
		}
		int max = 0,max_pos=0;
		for (int i = 1; i < dp2.length; i++) {
			for (int j = 0; j < i; j++) {
				if(lcs_dp[j] <= lcs_dp[i]) {
					dp2[i] = Math.max(dp2[i], dp2[j]+1);
				}
			}
			if(dp2[i]>max) {
				max = dp2[i];
				max_pos = i;
			}
		}
		countWays.breath(dp2);
		StringBuffer sb = new StringBuffer();
		sb.append(lcs_dp[max_pos]);
		for(int i=max_pos;i>=0;i--) {
			if(lcs_dp[i] < lcs_dp[max_pos] && dp2[i] == max-1) {
				sb.append(lcs_dp[i]);
				max_pos = i;
				max = dp2[i];
			}
		}
		System.out.println(sb.reverse().toString());
		
	}
	public static String LCS(char[] s1,char[] s2) {
		
		int n = s1.length,m = s2.length;
		
		//先得到[n-1,m-1]之前的最长公共子序列的大小，推导公式为：
		//如果s1[n] == s2[m],那么dp[n][m]就为dp[n-1][m-1]+1,
		//否则，dp[n][m] = max(dp[n-1][m],dp[n][m-1])
		
		int[][] dp = new int[n][m];
		for (int i = 0; i < dp.length; i++) {
			if(s1[i] == s2[0])
					dp[i][0] = 1;
		}
		for (int i = 0; i < dp[0].length; i++) {
			if(s1[0] == s2[i])
					dp[0][i] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(s1[i] == s2[j]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
		}
		////再从[n-1,m-1]回溯查找最长子序列的字符
		StringBuffer result = new StringBuffer();
		n--;m--;
		while (n >= 0 && m >= 0) {
			if (s1[n] == s2[m]) {
				result.append(s1[n]);
				n--;
				m--;
			} else {
				if (dp[n - 1][m] > dp[n][m - 1]) {
					n--;
				} else {
					m--;
				}
			}
		}
		return result.reverse().toString();
	}
}
