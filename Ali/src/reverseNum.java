import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Jul 29, 2017 8:15:53 PM 
* @Details 
* 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
如果 X = 123，则rev(X) = 321;
如果 X = 100，则rev(X) = 1.
现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
输入描述:
输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。

输出描述:
输出rev(rev(x) + rev(y))的值

输入例子:
123 100

输出例子:
223
*/
public class reverseNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		System.out.println(rev(rev(x)+rev(y)));
	}
	public static int rev(int x) {
		String string = String.valueOf(x);
		StringBuffer sb = new StringBuffer();
		for(int i=string.length()-1;i>=0.;i--){
			sb.append(string.charAt(i));
		}
		return Integer.valueOf(sb.toString());
	}
}
