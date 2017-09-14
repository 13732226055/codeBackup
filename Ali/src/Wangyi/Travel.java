package Wangyi;

import java.util.FormatFlagsConversionMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月9日 下午3:44:40 
* @Details 
* 树的深度优先遍历同时记录L
*/
public class Travel {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n =scan.nextInt();
		int L = scan.nextInt();
		int max = 0;
		int[] parent = new int[n];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = scan.nextInt();
		}
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {0,L,0});
		while(!stack.isEmpty()) {
			int[] now = stack.pop();
			if(now[1] == 0) {
				int cnt = 0;
				int city = now[2];
				while(city > 0) {
					cnt++;
					city &= city-1;
				}
				max = Math.max(max, cnt);
			}else {
				int flag = 0;
				for (int i = 1; i < parent.length; i++) {
					if(parent[i] == now[0] && now[1]>0 && (now[2] >> i & 1) ==  0) {
						stack.push(new int[] {i,now[1]-1,now[2]+ (1 << i)});
						flag = 1;
					}
				}
				if( flag == 0) {
					stack.push(new int[] {parent[now[0]],now[1]-1,now[2]});
				}
				
			}
		}
		System.out.println(max+1);
	}
	

}
