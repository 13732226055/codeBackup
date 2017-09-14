/** 
* @author ZYJ 
* @version 创建时间：2017年9月11日 下午1:22:08 
* @Details 
*/
public class UglyNumber {
	static int T = 10;
	public static void main(String[] args) {
		int L = 0;
		int R = 1;
		System.out.println(num235(16));
//		while(num235(R)<T) {
//			L = R;
//			R *= 2;
//			System.out.println(R+" "+num235(R));
//		}
//		while(L <= R) {
//			int mid = L + (R-L)/2;
//			int num = num235(mid);
//			if(num < T) {
//				L = mid+1;
//			}
//			if(num>T) {
//				R = mid -1;
//			}
//			else if(num == T){
//				System.out.println(mid);
//				return;
//			}
//		}
	}
//	private static int num235(int var) {
//		int n =0;
//		if(var > 1) n++;
//		while(var % 2 == 0) {
//			var /= 2;
//			n++;
//		}
//		while(var % 3 == 0) {
//			var /= 3;
//			n++;
//		}
//		while(var % 5 == 0) {
//			var /= 5;
//			n++;
//		}
//		return n;
//		
//	}
	
	
	//统计数R是第几个丑数，比如16，其中最大可以包含4个2和3个4
	private static int num235(int var) {
		// TODO Auto-generated method stub
		if(var < 1) return 0;
		int n = 1;
		while(var >= 2) {
			System.out.println(var+":"+" +2 ");
			n += 1 + num35(var);
			var /= 2;
		}
		return n;
	}
	private static int num35(int var) {
		// TODO Auto-generated method stub
		
		int n =0 ;
		while(var >= 3) {
			System.out.println(var+":"+" +3 ");
			n += 1 + num5(var);
			var /= 3;
		}
		return n;
	}
	private static int num5(int var) {
		// TODO Auto-generated method stub
		int n= 0 ;
		while(var >= 5) {
			System.out.println(var+":"+" +5 ");
			n++;
			var /= 5;
		}
		return n;
	}
	
}
