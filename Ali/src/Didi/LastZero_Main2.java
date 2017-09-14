package Didi;

import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月26日 下午2:54:09 
* @Details 
*/
public class LastZero_Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt = 0;
		while(n>0) {
			cnt += n/5;
			n /= 5;
		}
		System.out.println(cnt);
	}

}
