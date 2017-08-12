import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;

/** 
* @author ZYJ 
* @version 创建时间：Aug 8, 2017 7:22:46 PM 
* @Details 
*  假设有一个有 n 个元素的数组，求该数组右移 k 个元素后的数组，要求算法的空间复杂度为 O(1) 。

输入数据右三行，第一行表示数组元素个数 n ，第二行表示数组，第三行表示 k

7
1,2,3,4,5,6,7
3

输出

5,6,7,1,2,3,4 
*/
public class RightMoveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] is = new int[n];
		scan.nextLine();
		String[] strings = scan.nextLine().split(",");
		for(int i=0;i<n;i++){
			is[i] = Integer.valueOf(strings[i]);
		}
		int k = scan.nextInt();
		RightMoveArray(n,is,k);
	}

	private static void RightMoveArray(int n, int[] is, int k) {
		// TODO Auto-generated method stub
		int[] res = new int[n];
		for(int i =0;i<n;i++){
			res[(i+k)%n] = is[i];
		}
		countWays.breath(res);
	}

}
