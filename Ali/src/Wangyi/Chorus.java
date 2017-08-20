package Wangyi;

import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月20日 下午2:07:47 
* @Details 
* 题目描述
有 n 个学生站成一排，每个学生有一个能力值，
牛牛想从这 n 个学生中按照顺序选取 k 名学生，
要求相邻两个学生的位置编号的差不超过 d，
使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
输入描述:
每个输入包含 1 个测试用例。
每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，
表示学生的个数，接下来的一行，包含 n 个整数，
按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
输出描述:
输出一行表示最大的乘积。
示例1
输入

3
7 4 7
2 50
输出

49
*/
public class Chorus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		int[] a = new int[n];
		for (int i = 0; i < n; a[i++] = scan.nextInt()) ;
		scan.nextLine();
		int k = scan.nextInt();
		int d = scan.nextInt();
		long ans = Long.MIN_VALUE;
		long[][] dpm = new long[k][n];
		long[][] dpn = new long[k][n];
		
		for (int i = 0; i < n; i++) {
			dpm[0][i] = dpn[0][i] = a[i]; 
		}
		for (int i = 1; i < dpm.length; i++) {
			for (int j = 1; j < n; j++) {
				for (int j2 = j-1; 0 <= j2 && j-j2 <= d ; j2--) {
					dpm[i][j] = Math.max(dpm[i][j], Math.max(dpm[i-1][j2]*a[j], dpn[i-1][j2]*a[j]));
					dpn[i][j] = Math.min(dpn[i][j], Math.min(dpm[i-1][j2]*a[j], dpn[i-1][j2]*a[j]));
				}	
			}
		}
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dpm[k-1][i]);
		}
		System.out.println(ans);
	}
}
