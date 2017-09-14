package TodayTop;

import java.util.Arrays;
import java.util.Scanner;

import Wangyi.countWays;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月10日 下午7:15:49 
* @Details 
5 2 3
3 1 2 3
0
2 2 3
1 2
1 3
*/
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m= scan.nextInt();
		int c = scan.nextInt();
		int[][] map = new int[n][c+1];
		for (int i = 0; i < map.length; i++) {
			int num = scan.nextInt();
			for (int j = 0; j < num; j++) {
				int color = scan.nextInt();
				map[i][color] = 1;
			}
		}
		//countWays.breath(map);
		int cnt = 0;
		for (int i = 1; i < map[0].length; i++) {
			int sum = 0;
			for(int j=0;j<2*n;j++) {
				int x = j%n;
				sum += (map[x][i] == 1)? m-1:-1;
				if(sum>m-1) {
					cnt ++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
