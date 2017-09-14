package Wangyi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月22日 下午11:55:04 
* @Details 
题目描述
给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，
遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，
也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
输入描述:
每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。
接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。
接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，
左上角的坐标为 （0, 0），出发位置一定是 '.'）。之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，
接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）
输出描述:
输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。
以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，地牢出口如果被设置在右下角，
牛牛想离开需要移动的次数最多，为3次。
示例1
输入

3 3
...
...
...
0 1
4
1 0
0 1
-1 0
0 -1
输出

3
*/
public class EscapeFromDungeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		char[][] map = new char[n][m];
		for (int i = 0; i < map.length; i++) {
			map[i] = scan.nextLine().toCharArray();
		}
		int sx = scan.nextInt();
		int sy = scan.nextInt();
		scan.nextLine();
		int step = scan.nextInt();
		int[][]  pstep = new int[step][2];
		for (int i = 0; i < pstep.length; i++) {
			pstep[i][0] = scan.nextInt();
			pstep[i][1] = scan.nextInt();
			scan.nextLine();
		} 
		
		int[][] visited = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{sx,sy});
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int px = pos[0],py = pos[1];
			for (int i = 0; i < pstep.length; i++) {
				int x = pos[0] + pstep[i][0];
				int y = pos[1] + pstep[i][1];
				if( 0 <= x && x<n && 0<=y && y<m && map[x][y]!= 'X' && visited[x][y] == 0) {
					visited[x][y] = visited[px][py] +1;
					queue.add(new int[] {x,y});
				}
			}
		}
		int max = 0;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if(visited[i][j] == 0 && !(i == sx && j == sy) && map[i][j] != 'X') {
					System.out.println("-1");
					return;
				}
				max = Math.max(max, visited[i][j]);
			}
		}
		System.out.println(max);
	}

}
