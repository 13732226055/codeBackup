import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Jul 29, 2017 9:32:07 PM 
* @Details 
* 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3…….
这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
例如：
N = 4，M = 24：
4->6->8->12->18->24
于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
输入描述:
输入为一行，有两个整数N，M，以空格隔开。
(4 ≤ N ≤ 100000)
(N ≤ M ≤ 100000)

输出描述:
输出小易最少需要跳跃的步数,如果不能到达输出-1

输入例子:
4 24

输出例子:
5
*/
public class jumpStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		long startTime=System.nanoTime();   //获取开始时间 
		System.out.println(jumpStone(N,M,0));
		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		
		startTime=System.nanoTime();   //获取开始时间
	
		System.out.println(jumpStone_dp(N,M));
			
		endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
	}

	private static int jumpStone_dp(int n, int m) {
		// TODO Auto-generated method stub
		int dp[] =new int[m+1];
		for(int i=2;i<m+1;i++)	
				dp[i] = (i==n)? 0:Integer.MAX_VALUE;		
		for(int j=n;j<=m;j++){
			if(dp[j]==Integer.MAX_VALUE) continue;
			List<Integer> divisors = getDivisor_dp(j);
			if(null == divisors) continue;
			for(int i=0;i<divisors.size();i++){
				//System.out.println(divisors.size()+":"+i+" "+divisors.get(i)+" "+j+" "+dp[j]);
				if(divisors.get(i)+j>m) continue;		
				dp[divisors.get(i)+j] = Math.min(dp[divisors.get(i)+j], dp[j]+1); 
			}
		}
		if(dp[m]==Integer.MAX_VALUE) return -1;
		return dp[m];
	}
	private static List<Integer> getDivisor_dp(int n) {
		// TODO Auto-generated method stub
		if(n<3) return null; 
		List<Integer> list = new ArrayList<>();
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i == 0) {
				list.add(i);
				if(n/i!=i) list.add(n/i);
			}	
		}	
		return list;	
	}
	private static int jumpStone(int n, int m, int step) {
		// TODO Auto-generated method stub
		int[] divisors = getDivisor(n);
		int min = Integer.MAX_VALUE;
		if(divisors == null||divisors.length == 0 ) return min;
		if(n==m) {
			//System.out.print("Return "+step);
			return step;
		}
		else if(n<m){
			for(int i=0;i<divisors.length;i++){
				int divisor = divisors[i];
				//System.out.print(n+" "+divisor+" "+step+"-> ");
				min = Math.min(min, jumpStone(n+divisor, m,	step+1));
				//System.out.println();
			}
			return min;
		}else {
			//System.out.print("END");
			return Integer.MAX_VALUE;
		}
	}

	private static int[] getDivisor(int n) {
		// TODO Auto-generated method stub
		if(n<3) return null; 
		List<Integer> list = new ArrayList<>();
		for(int i=2;i<=Math.sqrt(n)+1;i++){
			if(n%i == 0) {
				list.add(i);
				if(n/i!=i) list.add(n/i);
			}	
		}	
		if(list.size()>0) return Arrays.stream(list.toArray(new Integer[list.size()]))
									.mapToInt(Integer::valueOf).toArray();
		return null;
	}
	
	

}
