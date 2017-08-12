import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Aug 8, 2017 7:52:56 PM 
* @Details 
*  输入 n 个未排序的数字组成的数组，求排序之后相邻元素之间最大的差值。
要求：算法的时间复杂度为 O(n) ，数字取值区间为 [-2^32,2^32-1] 。(long)
输入数据有两行，第一行表示数组的数字量 n ，第二行表示数组
4
4,1,7,5
输出
3 
*/
public class BiggestDiffBetweenSortNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(),i=0;
		scan.nextLine();
		String[] strings = scan.nextLine().split(",");
		long[] nums = new long[n];
		for (String string : strings) {
			nums[i++] = Long.parseLong(string);
		}
		BiggestDiffBetweenSortNum(n,nums);
		BiggestDiffBetweenSortNum2(n,nums);
	}

	private static void BiggestDiffBetweenSortNum2(int n, long[] nums) {
		// TODO Auto-generated method stub
		//先遍历一遍求最小值，然后记录每个元素和最小值的相对距离，最后计算相对距离的最小值
		boolean[] distanceFlag; //记录相对距离和距离分割标记
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for(int i=0;i<n;i++){
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		distanceFlag = new boolean[(int) (max-min+1)];
		for (long l : nums) {
			distanceFlag[(int) (l-min)] = true;
		}
		long  count = 0;
		long 	maxcount = 0;
		for(int i = 0;i<distanceFlag.length;i++){
			if(distanceFlag[i]==false){
				count++;
				maxcount = Math.max(maxcount, count);
			}else count = 0;
		}
		maxcount ++;
	}

	private static void BiggestDiffBetweenSortNum(int n, long[] nums) {
		// TODO Auto-generated method stub
		long diff;
		long maxdiff = Math.abs(nums[1]-nums[0]);
		long prev_diff = 0;
		int dir = 0;
		for(int i=1;i<n;i++){ //使用动态规划，用dir记录添加元素的方向，与新添加的方向进行比较，从而选择具体maxdiff的
								//计算方式
			diff = Math.abs(nums[i]-nums[i-1]);
			if(!( (nums[i]>nums[i-1]) ^ (dir == 0) )){
				maxdiff = Math.max(diff, maxdiff);
			}else{
				maxdiff = Math.max(maxdiff, (diff-prev_diff-maxdiff));
				dir = ~dir;
			}
			prev_diff = diff;
		}
		System.out.println(maxdiff);
	}

}
