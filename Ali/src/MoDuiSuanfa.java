import java.util.Scanner;
import java.util.function.IntPredicate;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月14日 上午10:48:29 
* @Details 
* 莫队算法解多区间查询问题
5
1 2 3 3 5
3
1 2 1
2 4 5
3 5 3 
*/
public class MoDuiSuanfa {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ks = new int[n];
		for (int i = 0; i < ks.length; i++) {
			ks[i] = scan.nextInt();
		}
		int q = scan.nextInt();
		int[][] query = new int[q][3];
		for (int i = 0; i < query.length; i++) {
			for (int j = 0; j < query[0].length; j++) {
				query[i][j] = scan.nextInt();
			}
		}
	}
}
