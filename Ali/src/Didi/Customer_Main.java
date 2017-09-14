package Didi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月26日 下午12:19:49 
* @Details 
* 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，
* 每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，
* 请实现一个算法选择其中一部分客人，使得总预计消费金额最大 
输入描述:
输入包括m+2行。
第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。


输出描述:
输出一个整数,表示最大的总预计消费金额

输入例子1:
3 5
2 4 2
1 3
3 5
3 7
5 9
1 10

输出例子1:
20
*/
public class Customer_Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		Arrays.sort(a);
		Queue<Customer> queue = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			int b = scan.nextInt();
			int c =scan.nextInt();
			if(b<=a[a.length-1]) queue.add(new Customer(b,c));
		}
		boolean[] visited = new boolean[n];
		
		long sum = 0;
		int count = 0;
		while(!queue.isEmpty()) {
			Customer tmp = queue.poll();
			for (int i = 0; i < n; i++) {
				if(tmp.people <= a[i] & visited[i] == false ) {
					visited[i] = true;
					sum += tmp.money;
					count++;
					break;
				}	
			}
			if(count == n) {
				break;
			}
		}
		System.out.println(sum);
	}
	static class Customer implements Comparable<Customer>{
		private int money;
		private int people;
		public Customer(int b, int c) {
			// TODO Auto-generated constructor stub
			this.people = b;
			this.money = c;
		}
		@Override
		public int compareTo(Customer o) {
			// TODO Auto-generated method stub
			if(o.money > this.money) {
				return 1;
			}else if(o.money < this.money) return -1;
			return 0;
		}
	}
	
}
