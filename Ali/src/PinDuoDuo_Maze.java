import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ZYJ
 * @version 创建时间：Aug 7, 2017 7:21:49 PM
 * @Details 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
 *          迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。迷宫之中有的路上还有门，
 *          每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。 请设计一个算法，帮助探险家找到脱困的最短路径。
 *          如前所述，迷宫是通过一个二维矩阵表示的， 每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，
 *          小写字母-对应大写字母所代表的门的钥匙 输入描述:
 * 
 *          迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
 *          后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。
 * 
 * 
 * 
 *          输出描述:
 * 
 *          路径的长度，是一个整数
 * 
 * 
 *          输入例子1:
 * 
 *          5 6 021111 01a0A0 01bBA3 010011 011110
 * 
 * 
 *          输出例子1:
 * 
 *          7
 */
public class PinDuoDuo_Maze {
	public static char[][] map;
	public static int x, y, tx, ty;
	public static int M, N;
	public static int key;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getMap();
		System.out.println(getMazeStep());
	}

	private static int getMazeStep() {
		// TODO Auto-generated method stub
		Queue<int[]> queue = new LinkedList<>();
		int[][][] dp = new int[M][N][1024];
		int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		queue.add(new int[] { x, y, 0 });
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			x = tmp[0];
			y = tmp[1];
			key = tmp[2];
			for (int[] is : dir) {
				int nx = x + is[0], ny = y + is[1];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N || dp[nx][ny][key] != 0 || map[nx][ny] == '0')
					continue;
				if (map[nx][ny] == '3')
					return dp[x][y][key] + 1;
				if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z' && (key >> (map[nx][ny] - 'A') & 1) == 0)
					continue;
				int step = dp[x][y][key];
				if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
					key += 1 << (map[nx][ny] - 'a');
				}
				dp[nx][ny][key] = step + 1;
				queue.add(new int[] { nx, ny, key });
				
				/*if (vaild(nx, ny) && dp[nx][ny][key] == 0) {
					dp[nx][ny][key] = dp[x][y][key] + 1;
					if (nx == tx && ny == ty)
						return dp[nx][ny][key];
					if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
						int prev_key = key;
						key += 1 << (map[nx][ny] - 'a');
						dp[nx][ny][key] = dp[nx][ny][prev_key];
					}
					queue.add(new int[] { nx, ny, key });
				}*/
			}
		}
		return -1;
	}

	private static boolean vaild(int nx, int ny) {
		// TODO Auto-generated method stub
		if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] != '0') {
			if (map[nx][ny] == '1' || map[nx][ny] == '3' || (map[nx][ny] >= 97 && map[nx][ny] <= 122))
				return true;
			else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z' && ((key >> (map[nx][ny] - 'a') & 1) == 1))
				return true;
		}

		return false;
	}

	private static void getMap() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt();
		N = scan.nextInt();
		scan.nextLine();
		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			map[i] = scan.nextLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '2') {
					x = i;
					y = j;
				}
				if (map[i][j] == '3') {
					tx = i;
					ty = j;
				}
			}
		}
	}

}
