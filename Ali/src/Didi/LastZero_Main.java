package Didi;

import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月26日 下午2:38:11 
* @Details
输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2 
输入描述:
输入为一行，n(1 ≤ n ≤ 1000)


输出描述:
输出一个整数,即题目所求

输入例子1:
10

输出例子1:
2
*/
public class LastZero_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt = 0;
		String multi = "1";
		for (int i = 1; i <= n; i++) {
			multi = getMulti(multi, String.valueOf(i));
			StringBuffer sb = new StringBuffer(multi);
			while(sb.charAt(sb.length()-1) == '0') {
				sb.deleteCharAt(sb.length()-1);
				cnt++;
			}
			multi = sb.toString();
		}
		
		System.out.println(cnt);
	}
	private static String getMulti(String n1, String n2) {
		// TODO Auto-generated method stub
		char[] fir = reverseNum(n1).toCharArray();
		char[] sec = reverseNum(n2).toCharArray();
		int m = fir.length;
		int n = sec.length;
		char[] result = new char[m+n];
		int multiFlag = 0;
		int addFlag	= 0;
		for(int i=0;i<m+n;i++)
			result[i] = '0';
		for(int i=0;i<m;i++){
			multiFlag = 0;
			addFlag = 0;
			for(int j=0;j<n;j++){
				int multi = (fir[i] - 48)*(sec[j] - 48) + multiFlag;
				multiFlag = multi/10;
				int add = result[i+j] - 48 + multi%10 + addFlag;
				result[i+j] = (char) (add%10 + 48);
				
				addFlag = add/10;
			}
			result[i+n] = (char) (addFlag + multiFlag + result[i+n]);
			
		}
		String end = String.valueOf(result);
		
		return (result[m+n-1] == '0')? reverseNum(end).substring(1,m+n)
											:reverseNum(end);
	}
	private static String  reverseNum(String n1) {
		// TODO Auto-generated method stub
		
		char[] cs = n1.toCharArray();
		
		int p = 0;
		int q = cs.length-1;
		
		while(p<q){
			char tmp = cs[p];
			
			cs[p++] = cs[q];
			cs[q--] = tmp;
			
		}
		
		return String.valueOf(cs);
	}


}
