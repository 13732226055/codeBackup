import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @author ZYJ 
* @version 创建时间：Jul 24, 2017 6:42:47 PM 
* @Details ;
* 
*/
/*有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
测试样例：
[[1,2,3],[1,1,1]],2,3
返回：4*/
public class walkSquare {
	public static int  minWayLength(int[][] map){
		int[][] dp =new int[map.length+1][map[0].length+1];
		dp = map;
		int row = map.length;
		int column = map[0].length;
		for(int k =1;k<row;k++){
			dp[k][0] += dp[k-1][0];
		}
		for(int k =1;k<column;k++){
			dp[0][k] += dp[0][k-1];
		}
		for(int i =1;i<row;i++){
			for(int j =1;j<column;j++){
				dp[i][j] = Math.min(dp[i-1][j]+dp[i][j], dp[i][j-1]+dp[i][j]);
			}
		}
		return dp[row-1][column-1];
	}
	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		String string= scanner.nextLine();*/
		String string = "[[1,2,3],[1,1,1]],2,3";
		Pattern pattern = Pattern.compile("\\[?\\[([0-9,]+)\\]\\]?");
		List<String> list = new ArrayList<>();
		int row = 0, column=0;
		
	    Matcher matcher = pattern.matcher(string);
	    while(matcher.find()){
			list.add(matcher.group(1));
		}
	    pattern = Pattern.compile("\\],([0-9]+),([0-9]+)$");
	    matcher = pattern.matcher(string);
	    if(matcher.find()){
	    	row = Integer.valueOf(matcher.group(1));
	    	column = Integer.valueOf(matcher.group(2));
	    }
	    int[][] map = new int[row][column];
	    for(int i=0;i<row;i++){
	    	String[] strings = list.get(i).split(",");
	    	for(int j=0;j<column;j++)
	    		map[i][j] = Integer.valueOf(strings[j]);
	    }
	    for(int[] tmp:map){
	    	for(int i:tmp)
	    		System.out.print(i+" ");
	    	System.out.println();
	    }
	  System.out.println(minWayLength(map));
		//System.out.println(strings[0]);
	}
	
}
