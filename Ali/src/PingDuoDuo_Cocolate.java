import java.util.Arrays;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Aug 7, 2017 4:27:35 AM 
* @Details
3
2 2 3
2
3 1 
*/
public class PingDuoDuo_Cocolate {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		int h[] =new int[n];
		for(int i=0;i<n;i++){
			h[i] = scan.nextInt();
		}
		scan.nextLine();
		int m = scan.nextInt();
		int[] w = new int[m];
		for(int i=0;i<m;i++){
				w[i] = scan.nextInt();
		}
		
		//getNum(h,w,0,new int[h.length],0);
		System.out.println(getNum(h,w));
	}

	private static int getNum(int[] h, int[] w) {
		// TODO Auto-generated method stub
		//用最低的重量满足最大的需求
		Arrays.sort(h);
		for(int i=0;i<h.length/2;i++){
			int tmp = h[i];
			h[i] =h[h.length-i-1] ;
			h[h.length-i-1] = tmp;
		}
		Arrays.sort(w);
		for(int i=0;i<w.length/2;i++){
			int tmp = w[i];
			w[i] =w[w.length-i-1] ;
			w[w.length-i-1] = tmp;
		}
		//countWays.breath(h);
		int counts =0;
		for(int i=0,j=0;i<h.length;){
			if(j>=w.length) break;
			if(h[i]<=w[j]){
				counts++;
				j++;
			}else i++;
		}
		return counts;
	}

}
