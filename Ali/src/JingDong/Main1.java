package JingDong;

import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月8日 下午8:50:54 
* @Details 
*/
public class Main1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		int cnt = 0;
		int num = 1;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if(c != ')') {
				cnt++;
			}else {
				num *= cnt;
				cnt--;
			}
		}
		//if(cnt>0) throw new Exception("Error");
		System.out.println(num);
	}

}
