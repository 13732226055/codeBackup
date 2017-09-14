package TodayTop;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月10日 下午7:54:21 
* @Details
* 用莫队算法
5
1 2 3 3 5
3
1 2 1
2 4 5
3 5 3 
*/
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] like = new int[999999999];
		for (int i = 1; i <= n; i++) {
			int tmp = scan.nextInt();
			like[tmp] += (1 << i);
		}
		int q= scan.nextInt();
		int[][] query = new int[q][3];
		int[] res = new int[q];
		for (int i = 0; i < query.length; i++) {
			for (int j = 0; j < query[0].length; j++) {
				query[i][j] = scan.nextInt();
			}
			int cnt =0;
			int users = like[query[i][2]];
			users = users >> query[i][0];
			int pow = query[i][1]-query[i][0]+1;
			users &= (int)Math.pow(2, pow) - 1;
			while(users > 0) {
				cnt++;
				users &= users-1;
			}
			res[i] = cnt;
		}
		//countWays.breath(query);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}

}
