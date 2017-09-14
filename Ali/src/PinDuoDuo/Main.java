package PinDuoDuo;
/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午3:01:14 
* @Details 
2 5
5 6 10 20 30
4 34
3 35

2 5
5 6 10 20 30
100 1
99 30
*/
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		Arrays.sort(a);
		int x = 0, y = a.length-1;
		while(x<y) {
			int t = a[x];
			a[x++] = a[y];
			a[y--] = t;
		}
		
		Queue<Bear> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int b = scan.nextInt();
			int c =scan.nextInt();
//			if(b<=a[a.length-1]) 
			queue.add(new Bear(b,c));
		}
		boolean[] visited = new boolean[m];
		
		while(!queue.isEmpty()) {
			
			Bear tmp = queue.poll();
			for (int i = 0; i < a.length; i++) {
				if(a[i] <= tmp.hungry && visited[i] == false) {
					tmp.hungry -= a[i];
					visited[i] = true;
				}
			}
			System.out.println(tmp.hungry);
		}
	}
	static class Bear implements Comparable<Bear>{
		private int fight;
		private int hungry;
		public Bear(int b, int c) {
			// TODO Auto-generated constructor stub
			this.fight = b;
			this.hungry = c;
		}
		@Override
		public int compareTo(Bear o) {
			// TODO Auto-generated method stub
			if(o.fight > this.fight) {
				return 1;
			}else if(o.fight < this.fight) return -1;
			return 0;
		}
	}

}
