import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Jul 27, 2017 6:43:00 AM 
* @Details 
* 大家一定玩过“推箱子”这个经典的游戏。具体规则就是在一个N*M的地图上，
* 有1个玩家、1个箱子、1个目的地以及若干障碍，其余是空地。玩家可以往
* 上下左右4个方向移动，但是不能移动出地图或者移动到障碍里去。如果往
* 这个方向移动推到了箱子，箱子也会按这个方向移动一格，当然，箱子也不
* 能被推出地图或推到障碍里。当箱子被推到目的地以后，游戏目标达成。
* 现在告诉你游戏开始是初始的地图布局，请你求出玩家最少需要移动多少
* 步才能够将游戏目标达成。
* 输入描述:

每个测试输入包含1个测试用例
第一行输入两个数字N，M表示地图的大小。其中0<N，M<=8。
接下来有N行，每行包含M个字符表示该行地图。其中 . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
每个地图必定包含1个玩家、1个箱子、1个目的地。



输出描述:

输出一个数字表示玩家最少需要移动多少步才能将游戏目标达成。当无论如何达成不了的时候，输出-1。


输入例子1:

4 4
....
..*@
....
.X..
6 6
...#..
......
#*##..
..##.#
..X...
.@#...


输出例子1:

3
11
*/
public class pushBox {
	private static int M;
	private static int N;
	private static char[][] map;
	private static int mx,my,bx,by,dx,dy;
	public static boolean valid(int x,int y){
		if(x<M && x>=0 && y<N && y>=0 && map[x][y]!='#') return true;
		return false;
	}
	public static int[] toIntArray(int x1,int y1,int x2,int y2){
		int[] array = null ;
		array[0] = x1;
		array[1] = y1;
		array[2] = x2;
		array[3] = y2;
		return array;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getMap();
		System.out.println(pushBox());
		
	}
	public static void getMap() {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		scanner.nextLine();
		
		//List<Integer[]> map= new ArrayList<>();
		map = new char[N][M];
		for(int i = 0;i<N;i++){
			map[i] = scanner.nextLine().toCharArray();
			for(int j = 0; j<M;j++){
				switch (map[i][j]) {
				case 'X':
					mx = i;my = j;
					break;
				case '*':
					bx = i;by = j;
					break;
				case '@':
					dx = i;dy = j;
					break;
				default:
					break;
				}
			}
		}
	}
	public static int pushBox() {
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][][][] dp = new int[N][M][N][M];
		
		Queue<Integer[]> queue = new LinkedList<>();
		
		queue.add(new Integer[]{mx,my,bx,by});
		dp[mx][my][bx][by] = 0;
		while(!queue.isEmpty()){
			Integer[] tmp = queue.poll();
			mx = tmp[0];my = tmp[1];bx = tmp[2];by = tmp[3];
			for(int i =0;i<dir.length;i++){
				int nmx = mx+dir[i][0];
				int nmy = my+dir[i][1];
				int nnmx = nmx+dir[i][0];
				int nnmy = nmy+dir[i][1];
				if(valid(nmx, nmy) && (nmx != bx || nmy != by) && dp[nmx][nmy][bx][by] == 0){
					dp[nmx][nmy][bx][by] = dp[mx][my][bx][by] + 1;
					queue.add(new Integer[]{nmx, nmy, bx, by});
					continue;
				}else if(valid(nnmx, nnmy) && nmx == bx && nmy == by && dp[nmx][nmy][nnmx][nnmy] == 0){
					dp[nmx][nmy][nnmx][nnmy] = dp[mx][my][bx][by] + 1;
					if(nnmx == dx && nnmy == dy) return dp[nmx][nmy][nnmx][nnmy];
					queue.add(new Integer[]{nmx, nmy, nnmx, nnmy});
				}
			}
		}
		return -1;
		
	}
}
