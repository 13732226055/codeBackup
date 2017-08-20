package Meituan;

/**
 * @author ZYJ
 * @version 创建时间：2017年8月20日 下午12:54:47
 * @Details
 */
public class Flip {
	public int[][] flipChess(int[][] A, int[][] f) {
		// write code here
		int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < dir.length; j++) {
				int x = f[i][0] + dir[j][0] -1;
				int y = f[i][1] + dir[j][1] -1;
				if(0<=x&&x<4 && 0<=y&&y<4) {
					A[x][y] = (A[x][y] == 0)? 1:0;
				}
			}
		}
		return A;
	}
}
