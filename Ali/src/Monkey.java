import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月21日 下午11:07:39 
* @Details 
* 10
32 345 234 2 325 35  3 53 3 345
*/
public class Monkey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n<=0) {
			System.out.println(0);
			return;
		}
		int peaches[] = new int[n];
		for (int i = 0; i < peaches.length; i++) {
			peaches[i] = scan.nextInt();
		}
		int[] dp = new int[n];
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(peaches[i] >= peaches[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			countWays.breath(dp);
			max = Math.max(max, dp[i]);
			
		}
		System.out.println(max);
		int count = 1;
		for (int i = peaches.length-2; i >=0; i--) {
			if(peaches[i] <= peaches[i+1]) count++;
		}
		System.out.println(count);
	}

}
