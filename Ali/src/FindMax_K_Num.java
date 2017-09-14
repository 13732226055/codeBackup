import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月26日 下午4:43:13 
* @Details 
*/
public class FindMax_K_Num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		
		String[] strings = scan.nextLine().split(" ");
		int[] data = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			data[i] = Integer.valueOf(strings[i]);
		}
		int K = scan.nextInt() - 1;
		int n = partition(data, 0, data.length-1);
		
		while(n != K) {
			if(n > K) {
				n = partition(data, 0, n-1);
			}else {
				n = partition(data, n+1, data.length-1);
			}
		}
		
		System.out.println(data[K]);
	}
	public static int partition(int[] data , int start, int end) {
		int pivot = data[start];
		int store = start;
		swap(data, start, end);
		for (int i = start; i < end; i++) {
			if(data[i] < pivot) {
				swap(data, store, i);
				++store;
			}
		}
		swap(data, store, end);
		return store;
		
		
	}
	public static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

}
