package TodayTop;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.omg.PortableInterceptor.DISCARDING;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月10日 下午8:50:12 
* @Details 
*/
public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int n = scan.nextInt();
		int[] ints = new int[10000];
		for (int i = 0; i < s.length(); i++) {
			ints[i- 'a'] += 1<<i;
		}
		for (int i = 0; i < ints.length; i++) {
			if(ints[i] == 1) {
				List<Integer> distance = new LinkedList<>();
				for(int j=i+1;j<ints.length;j++) {
					if(ints[j]==1) distance.add(j-i);
				}
			}
		}
	}

}
