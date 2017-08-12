import java.util.Scanner;

/*
 * 
һֻ����Ҫ�Ӻ���������Ӷ԰����Ӻܿ����Ǻ��м���˺ܶ�׮�ӣ�ÿ��һ�׾���һ����
ÿ��׮���϶���һ�����ɣ��������������ϾͿ������ĸ�Զ��
ÿ������������ͬ����һ�����ִ������������������������Ϊ5���ʹ��������һ������ܹ���5�ף�
���Ϊ0���ͻ��ݽ�ȥ�޷�������Ծ������һ��N�׿������ʼλ�þ��ڵ�һ���������棬
Ҫ�������һ������֮���������ˣ�����ÿ�����ɵ������������������Ҫ�������ܹ�����԰�������޷��������-1 
��������:
��������У���һ�������鳤��N (1 �� N �� 10000)���ڶ�����ÿһ���ֵ���ÿո�ָ���


�������:
������ٵ��������޷��������-1

��������1:
5
2 0 1 1 1

�������1:
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
