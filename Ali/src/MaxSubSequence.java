import java.util.Scanner;

public class MaxSubSequence {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String[] strings = scan.nextLine().split(" ");
		int[] nums = new int[n];
		int i=0;
		for (String string : strings) {
			nums[i++] = Integer.valueOf(string);
		}
		System.out.println(getMaxSubSeq(n,nums));
	}

	private static int getMaxSubSeq(int n, int[] nums) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int count = 0;
		int flag = 0;
		for(int i=0;i<n;i++) {
			if(nums[i]< 0 && flag == 0) {
				max = Math.max(max, nums[i]);
				continue;
			}else {
				flag = 1;
			}
			if(count == 0 && nums[i] <= 0) continue;
			count = count + nums[i];
			max = Math.max(max, count);
			if(count < 0) count =0;
		}
		return max;
	}
}
