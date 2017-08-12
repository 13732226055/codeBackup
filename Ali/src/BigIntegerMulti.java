import java.math.BigInteger;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Aug 2, 2017 7:11:27 AM 
* @Details 
* 两个大数相乘的运算 O(n^2)
*/
public class BigIntegerMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String n1 = scan.nextLine();
		String n2 = scan.nextLine();
		System.out.println(getMulti(n1,n2));
		//System.out.println(new BigInteger(n1).multiply(new BigInteger(n2)));
	}

	private static String getMulti(String n1, String n2) {
		// TODO Auto-generated method stub
		char[] fir = reverseNum(n1).toCharArray();
		char[] sec = reverseNum(n2).toCharArray();
		int m = fir.length;
		int n = sec.length;
		char[] result = new char[m+n];
		int multiFlag = 0;
		int addFlag	= 0;
		for(int i=0;i<m+n;i++)
			result[i] = '0';
		for(int i=0;i<m;i++){
			multiFlag = 0;
			addFlag = 0;
			for(int j=0;j<n;j++){
				int multi = (fir[i] - 48)*(sec[j] - 48) + multiFlag;
				multiFlag = multi/10;
				int add = result[i+j] - 48 + multi%10 + addFlag;
				result[i+j] = (char) (add%10 + 48);
				
				addFlag = add/10;
			}
			result[i+n] = (char) (addFlag + multiFlag + result[i+n]);
			
		}
		String end = String.valueOf(result);
		
		return (result[m+n-1] == '0')? reverseNum(end).substring(1,m+n)
											:reverseNum(end);
	}

	private static String  reverseNum(String n1) {
		// TODO Auto-generated method stub
		
		char[] cs = n1.toCharArray();
		
		int p = 0;
		int q = cs.length-1;
		
		while(p<q){
			char tmp = cs[p];
			
			cs[p++] = cs[q];
			cs[q--] = tmp;
			
		}
		
		return String.valueOf(cs);
	}

}
