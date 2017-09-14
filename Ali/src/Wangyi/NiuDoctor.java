package Wangyi;

import java.util.Scanner;
import java.util.function.IntPredicate;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月9日 下午5:09:57 
* @Details 
*/
public class NiuDoctor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t= scan.nextInt();
		for(int i=0;i<t;i++) {
			int tmp = scan.nextInt();
			int[] nums = new int[tmp];
			int count4 = 0;
			int count2 = 0;
			int other = 0;
			for (int j = 0; j < nums.length; j++) {
				nums[i] = scan.nextInt();
				if(nums[i]%2==0 && nums[i]%4 != 0) {
					count2++;
				}else if(nums[i]%4 == 0) {
					count4++;
				}else {
					other++;
				}
			}
			if(count2 >= 1) {
				if(other>count4) {
					System.out.println("No");
				}else System.out.println("Yes");
			}
			if(count2 == 0) {
				if(other>count4+1) {
					System.out.println("No");
				}else System.out.println("Yes");
			}
		}
	}
}
