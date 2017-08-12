import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月12日 下午1:53:57 
* @Details 
*/
public class Meitu_Add8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "8888888888";
		long sum = 0;
		for(int i=0;i<10;i++) {
			long tmp = Long.parseLong(string.substring(0,i+1));
			sum += tmp;
		}
		System.out.println(sum);
		int i =0;
		sum =0;
		while(i<10) {
			sum += Long.parseLong(string.substring(0,++i));		
		}
		System.out.println(sum);
		System.out.println(Character.MAX_VALUE);
	}

}

