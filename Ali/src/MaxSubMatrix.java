import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class MaxSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		int[][] map = new int[m][n];
		for(int i = 0;i<m;i++) {
			String[] strings = scanner.nextLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.valueOf(strings[j]);
			}
		}
		System.out.println(getMaxSubMatrix(m,n,map));
	}

	private static int getMaxSubMatrix(int m, int n, int[][] map) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE ;
		int[][] count = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i == 0 && j!=0) {
					count[i][j] = count[i][j-1]+map[i][j];
				}
				if(j == 0 && i!=0) {
					count[i][j] = count[i-1][j]+map[i][j];
				}
				if(i!=0 && j!=0){
					count[i][j] = count[i-1][j] + count[i][j-1]+map[i][j]-count[i-1][j-1];
				}
				if(count[i][j] < 0) count[i][j] = 0;
				
				max = Math.max(count[i][j],max);
			}
			System.out.println("-----------------------");
			for(int k=0;k<m;k++) {
				for(int p =0;p<n;p++) {
					System.out.print(" "+count[k][p]);
				}
				System.out.println();
			}
		}
	/*
	 * 
5 6
0 0 -1 3 0 0
0 0 3 -3 0 0
-1 2 0 0 0 0
1 1 1 1 0 0
0 2 -1 0 0 0

5 6
0 0 -1 3 0 0
0 0 3 -3 0 0
0 2 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

5 6
0 0 -1 3 0 0
0 0 0 -3 0 0
0 2 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
	 */
		return max;
	}

}
