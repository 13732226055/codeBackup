package Zhaoshang;

import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月13日 下午7:30:02 
* @Details 
* 二进制gcd算法
*/
public class Main1 {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		
		int d = binaryGcd(n, m);
		int x = m*n/d;
		System.out.println(k/x);
	}
	public static int gcd(int i,int j) {
		if(j>i) {
			int tmp =i;
			i =j;
			j = tmp;
		}
		int r = i%j;
		while(r > 0) {
			j = i;
			i = r;
		}
		return j;
	}
	 public static int binaryGcd(int a, int b) {// assume a>=b;  
		    a = Math.abs(a); // gcd(a,b) = gcd(|a|,|b|) 31.8  
		    b = Math.abs(b);  
		    if (a < b) {  
		      return binaryGcd(b, a);  
		    }  
		    if (b == 0) {  
		      return a;  
		    }  
		  
		    if ((a & 1) == 0 && (b & 1) == 0) {// both a and b are even  
		      int half = binaryGcd(a >> 1, b >> 1);  
		      return half << 1;  
		    }  
		    else if ((a & 1) == 1 && (b & 1) == 0) {// a odd, b even  
		      return binaryGcd(a, b >> 1);  
		    }  
		    else if ((a & 1) == 0 && (b & 1) == 1) {// a even, b odd  
		      return binaryGcd(a >> 1, b);  
		    }  
		    else { // a odd, b odd  
		      return binaryGcd((a - b) >> 1, b);  
		    }  
		  }  
}
