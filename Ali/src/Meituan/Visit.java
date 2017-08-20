package Meituan;

import UDP.DaytimeUDPClient;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月20日 下午1:03:17 
* @Details 
* 题目描述
现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，
已知他的位置以及商家的位置，但是由于城市道路交通的原因，
他只能在左右中选择一个方向，在上下中选择一个方向，
现在问他有多少种方案到达商家地址。
给定一个地图map及它的长宽n和m，
其中1代表经理位置，2代表商家位置，
-1代表不能经过的地区，0代表可以经过的地区
，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
测试样例：
[[0,1,0],[2,0,0]],2,3
返回：2
*/
public class Visit {
	// write code here
	 public int countPath(int[][] map, int n, int m) {
		 int mx=0,my=0,tx=0,ty=0;
		 for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					mx=i;
					my=j;
				}
				if(map[i][j] == 2) {
					tx=i;ty=j;
				}
			}
		}
		if(mx == tx || my==ty) return 1;
		int dx = (mx>tx)? -1:1; 
		int dy = (my>ty)? -1:1; 
		int[][] dp = new int[map.length][map[0].length];
		dp[mx][my] = 1;
		for (int i = mx; i < tx+dx; i=i+dx) {
			for (int j = my; j < ty+dy; j=j+dy) {
				if(i==mx && j==my) dp[i][j] = 1;
				else {
					if(i-dx<0) dp[i][j] = (map[i][j]==-1)? 0:dp[i][j-dy];
					else if(j-dy<0)	dp[i][j] = (map[i][j]==-1)? 0:dp[i-dx][j];
					else dp[i][j] = (map[i][j]==-1)? 0:dp[i-dx][j]+dp[i][j-dy];
				}
			}
		}
		return dp[tx][ty];
	}
}