import java.util.Scanner;
import java.util.Stack;

/**
 * @author ZYJ
 * @version 创建时间：Aug 4, 2017 6:57:32 AM
 * @Details 现在有n位工程师和6项工作(编号为0至5)，现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。
 *          现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，两位工程师不能安排到同一项工作当中去。
 *          如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，现在需要计算出有多少种不同工作安排计划。 输入描述:
 * 
 *          输入数据有n+1行： 第一行为工程师人数n(1 ≤ n ≤ 6) 接下来的n行，每行一个字符串表示第i(1 ≤ i ≤
 *          n)个人能够胜任的工作(字符串不一定等长的)
 * 
 * 
 * 
 *          输出描述:
 * 
 *          输出一个整数，表示有多少种不同的工作安排方案
 * 
 * 
 *          输入例子1:
 * 
 *          6 012345 012345 012345 012345 012345 012345
 * 
 * 
 *          输出例子1:
 * 
 *          720
 */
public class EngineerSchedule {
	// public static int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		int ability[][] = new int[n][6];
		for (int i = 0; i < n; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < str.length(); j++) {
				ability[i][str.charAt(j) - 48] = 1;
			}
		}
		scan.close();
		getScheduleNum(ability, n, new int[6], 0, 0);
		System.out.println(getScheduleNum(ability, n, new int[6], 0, 0));
	}

	private static int getScheduleNum(int[][] ability, int n, int visited[], int pos, int mission) {
		// TODO Auto-generated method stub
		int count = 0;
		if (pos >= n) {
			return 1;
		}
		for (int i = 0; i < 6; i++) {
			if (ability[pos][i] != 0 && visited[i] == 0) {
				visited[i] = 1;
				count += getScheduleNum(ability, n, visited, pos + 1, mission);
				visited[i] = 0;
			}
		}
		return count;

	}
	// Unused!!
	/*
	 * private static int[][] reverseMatrix(int[][] ability) { // TODO
	 * Auto-generated method stub int[][] matrix = new
	 * int[ability[0].length][ability.length]; for(int i=0;i<ability.length;i++)
	 * for(int j=0;j<ability[0].length;j++) matrix[j][i] = ability[i][j];
	 * 
	 * return matrix; }
	 */

}
