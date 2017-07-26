import java.awt.Color;
import java.util.Scanner;
import java.util.Stack;

/** 
* @author ZYJ 
* @version 创建时间：Jul 25, 2017 1:16:31 AM 
* @Details 
*/
public class Island {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int map[][] = {{1,1,1,0,1,1},
					   {1,1,0,1,0,0},
					   {1,0,0,1,0,1},
					   {1,1,0,0,1,1},
					   {0,0,0,1,0,0}
					};
		System.out.println(countIsland(map));;
	}

	private static int  countIsland(int[][] map) {
		// TODO Auto-generated method stub
		if(map==null) return 0;
		int row = map.length;
		int column=map[0].length;
		int sum=0;
		boolean[][] visited = new boolean[row][column];
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				if(map[i][j]==1 && !visited[i][j]){
					sum++;
					dfs(i,j,map,visited);
					countWays.breath(visited);
				}
				
			}
		}
		return sum;
	}

	private static void dfs(int row,int column,int[][] map,boolean[][] visited) {
		// TODO Auto-generated method stub
		if(row>=map.length || column>=map[0].length || row<0 ||column <0 || visited[row][column]) return ;
		
		if(map[row][column]==1){
			visited[row][column] = true;
			dfs(row+1, column, map,visited);
			dfs(row, column+1, map,visited);
			dfs(row-1, column, map,visited);
			dfs(row, column-1, map,visited);
		}
		return ;
		
	}

}
