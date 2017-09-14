package JingDong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月8日 下午6:41:29 
* @Details 
* {A}+{B}
*/
public class TwoWayMerge {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		Integer[] A= new Integer[n];
		Integer[] B= new Integer[m];
		for (int i = 0; i < A.length; i++) {
			A[i] = scan.nextInt();
		}
		for (int i = 0; i < B.length; i++) {
			B[i] = scan.nextInt();
		}
		
		Set<Integer> set= new HashSet<>();
		Arrays.sort(A);
		Arrays.sort(B);
		int i=0,j=0;
		for(int k=0;i<n && j<m;) {
			if(A[i]<B[j]) {
				set.add(A[i++]);
			}else if(A[i]>=B[j]) {
				set.add(B[j++]);
			}
		}
		while(i<n) {
			set.add(A[i++]);
		}
		while(j<m) {
			set.add(B[j++]);
		}
		System.out.println(set.toString());
	}
}
