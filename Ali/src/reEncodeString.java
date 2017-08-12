import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Jul 26, 2017 7:03:42 AM 
* @Details 
* 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
输入描述:

每个测试输入包含1个测试用例
每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。

输出描述:
输出编码后的字符串

输入例子1:
AAAABCCDAA

输出例子1:
4A1B2C1D2A
*/
public class reEncodeString {
	public static String reEncode(String string){
		String reString = "";
		for(int i=0;i<string.length();i++){
			char prechar = string.charAt(i);
			int count = 1;
			while(i+1<string.length() && prechar == string.charAt(i+1)){
				count++;
				i++;
			}
			reString+=""+count+prechar;
		}
		return reString;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = new Scanner(System.in).nextLine();
		System.out.println(reEncode(string));
	}

}
