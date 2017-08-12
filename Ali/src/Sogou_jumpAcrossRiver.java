import java.util.Scanner;

/*
 * 
一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，
每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。
每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，
如果为0，就会陷进去无法继续跳跃。河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，
要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1 
输入描述:
输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。


输出描述:
输出最少的跳数，无法到达输出-1

输入例子1:
5
2 0 1 1 1

输出例子1:
4
 * 
 */
public class Sogou_jumpAcrossRiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] string = scanner.nextLine().split(" ");
		int[] wound = new int[n];
		int i = 0;
		for (String string2 : string) {
			wound[i++] = Integer.valueOf(string2);
		}
		System.out.println(getMinJumpStep(n,wound));
	}

	private static int getMinJumpStep(int n, int[] wound) {
		// TODO Auto-generated method stub
		int[] dp = new int[2*n];
		for(int i =0;i<2*n;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for(int i= 0 ;i<n;i++) {
			int maxJump = wound[i];
			for(int j=0;j<=maxJump;j++) {
				if(dp[i]!=Integer.MAX_VALUE)
					dp[i+j] = Math.min(dp[i+j], dp[i]+1);
			}
			
		}
		return (dp[n]==Integer.MAX_VALUE) ? -1:dp[n];
	}

}
