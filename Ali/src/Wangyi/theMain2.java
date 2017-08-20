package Wangyi;

import java.util.Arrays;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月12日 上午9:29:50 
* @Details
4
1 2 4 9
1 1 1 1 
*/
public class theMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);	
		int n = scan.nextInt();
		scan.nextLine();
		String[] strings = scan.nextLine().split(" ");
		String[] strings2=scan.nextLine().split(" ");
		int[] x =new int[n];
		int[] y = new int[n];
		int max_x = 0;
		int max_y = 0;
		int min_x = Integer.MAX_VALUE;
		int min_y = Integer.MAX_VALUE;
		for(int i =0;i<n;i++) {
			x[i] = Integer.valueOf(strings[i]);
			max_x = Math.max(max_x, x[i]);
			min_x = Math.min(min_x, x[i]);
			y[i] = Integer.valueOf(strings2[i]);
			max_y = Math.max(max_y, y[i]);
			min_y = Math.min(min_y, y[i]);
		}
		for(int i=0;i<n;i++) {
			x[i] -= min_x;
			y[i] -= min_y;
		}
		
		System.out.println(getMinUnionStep(n,x,y,max_x-min_x));
	}
		

	private static String getMinUnionStep(int n, int[] x, int[] y, int max_x) {
		// TODO Auto-generated method stub
		int length = x.length;
		int[] ans = new int[length];
		for(int i =0;i<length;i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				int[] distance = new int[length];
				
				for(int k=0;k<length;k++) {
					distance[k] = Math.abs(x[i]-x[k])+Math.abs(y[i]-y[k]);
				}
				Arrays.sort(distance);
				int tmp = 0;
				for(int k=0;k<length;k++) {
					tmp+=distance[k];
					ans[k] = Math.min(ans[k], tmp);
				}
			}
		}
		String string = "";
		for (int i : ans) {
			string += " "+i;
		}
		return string.substring(1, string.length());
	}

	

}
