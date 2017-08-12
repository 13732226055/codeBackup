import java.util.Arrays;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Aug 3, 2017 12:53:10 AM 
* @Details 
*/
public class BiggestTwoNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String[] strings = scan.nextLine().split(" ");
		int[] ints = Arrays.stream(strings).mapToInt(Integer::valueOf).toArray();
		getTwoBigNum(ints);
	}

	private static void getTwoBigNum(int[] ints) {
		// TODO Auto-generated method stub
		int max = ints[0];
		int sec = ints[0];
		for(int i = 0;i < ints.length;i++){
			if(ints[i] > max){
				sec = max;
				max = ints[i];
			}else if(ints[i] > sec)
				sec = ints[i];
		}
		System.out.println("Max:"+max+" Sec:"+sec);
	}

}
