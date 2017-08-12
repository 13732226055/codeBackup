import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Aug 8, 2017 6:51:44 PM 
* @Details
*  实现一个 mergeArray 函数，对两个已经排好序（从小到大）的数组进行排序（从小到大），
*  数组里面是数字均为整数，在 [0,100000) 之间，数组长度不超过 10000 。

输入数据有三行，第一行两个数字表示每个数组数字个数，后面两行分别表示两个数组

5,3
9,6,5,3,1
7,4,2

输出

1,2,3,4,5,6,7,9  
*/
public class mergeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] l1 = scan.nextLine().split(",");
		int m = Integer.valueOf(l1[0]);
		int n = Integer.valueOf(l1[1]);
		String[] l2 = scan.nextLine().split(",");
		int[] is1 = new int[m];
		int[] is2 = new int[n];
		for(int i=0;i<m;i++){
			is1[i] = Integer.valueOf(l2[i]);
		}
		String[] l3 = scan.nextLine().split(",");
		for(int i=0;i<n;i++){
				is2[i] = Integer.valueOf(l3[i]);
		}
		countWays.breath(is2);
		mergeArray(m,n,is1,is2);
	}

	private static void mergeArray(int m, int n,int[] is1, int[] is2) {
		// TODO Auto-generated method stub
		int[] res = new int[m+n];
		int i =0,j=0,k=0;
		while(i<m || j<n){
			if(i>=m){
				res[k++] = is2[j++];
				continue;
			}else if(j>=n){
				res[k++] = is1[i++];
				continue;
			}
			if(is1[i]>=is2[j]){
				res[k++] = is2[j++];
			}else if(is1[i]<is2[j]){
				res[k++] = is1[i++];
			}
		}
		System.out.print(res[0]);
		for(int l=1;l<m+n;l++){
			System.out.print(","+res[l]);
		}
	}

}
