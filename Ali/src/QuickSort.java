/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午1:43:37 
* @Details 
*/
public class QuickSort {
	public static void main(String[] args) {
		int[] x = {1,2,3,4,5,6,8,24,4,5,345,34,5,4};
		sort(x, 0, x.length-1);
		countWays.breath(x);
	}
	public  static void sort(int[] x,int start, int end) {
		if(start >= end) return;
		int index = Partition.Partition(x, start, end);
		sort(x, index+1, end);
		sort(x, start, index-1);
	}
}
