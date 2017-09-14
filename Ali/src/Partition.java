import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午1:12:49 
* @Details 
*/
public class Partition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] s= "13254876".toCharArray();
		int n = scan.nextInt();
		
		int start = 0;
		int end = s.length -1;
		int index = Partition(s,start,end);
		while(index != n) {
			if(index > n) {
				end = index -1;
			}else {
				start = index +1;
			}
			index = Partition(s,start,end);
		}
		System.out.println(s[index]);
		
		//Quick Sort.....
		
	}
	public static int Partition(int[] cs,int start, int end) {
		swap(cs,start,end);
		int index = start;
		int small = start;
		while(index < end) {
			if(cs[index] < cs[end]) {
				swap(cs, index, small);
				small++;
			}
			index++;
		}
		swap(cs, small, end);
		return small;
	}

	private static void swap(int[] cs, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = cs[i];
		cs[i] = cs[j];
		cs[j] = tmp;
	}
	public static int Partition(char[] cs,int start, int end) {
		swap(cs,start,end);
		int index = 0;
		int small = 0;
		while(index < end) {
			if(cs[index] < cs[end]) {
				swap(cs, index, small);
				small++;
			}
			index++;
		}
		swap(cs, small, end);
		return small;
	}

	private static void swap(char[] cs, int i, int j) {
		// TODO Auto-generated method stub
		char tmp = cs[i];
		cs[i] = cs[j];
		cs[j] = tmp;
	}
	
}
