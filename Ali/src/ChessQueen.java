import javax.security.auth.login.FailedLoginException;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 上午11:36:38 
* @Details 
* 在8*8的国际象棋上摆放8个皇后，使其不能相互攻击，请问有多少种不同的摆法？
*/
public class ChessQueen {
	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queen = new int[8];
		for (int i = 0; i < queen.length; i++) {
			queen[i] = i;
		}
		ReverseArray(queen,0);
		System.out.println(cnt);
	}
	private static void ReverseArray(int[] queen, int start) {
		// TODO Auto-generated method stub
		if(start == queen.length-1) {
			int flag = 0;
			for (int i = 0; i < queen.length; i++) {
				for (int j = 0; j < queen.length; j++) {
					if(i-j == queen[i] - queen[j] && i != j) flag = 1; 
				}
			}
			if(flag == 0) {
				cnt++;
				countWays.breath(queen);
			}
			
			return;
		}else {
			for(int i = start;i<queen.length;i++) {
				int tmp = queen[start];
				queen[start] = queen[i];
				queen[i] = tmp;
				
				ReverseArray(queen, start+1);
				
				tmp = queen[start];
				queen[start] = queen[i];
				queen[i] = tmp;
			}
		}
	}

}
