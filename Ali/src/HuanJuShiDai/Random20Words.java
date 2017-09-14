package HuanJuShiDai;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 上午10:24:38 
* @Details 
* 随机生成20个不重复的小写字母并进行排序，排序方式为倒序。
*/
public class Random20Words {
	private static int WORD_NUM = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StringBuffer sb = new StringBuffer();
//		char[] cs  = new char[WORD_NUM];
//		for (int i = 0; i < cs.length; i++) {
//			cs[i] = '0';
//		}
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		for (int i = 0; i < n; i++) {
//			Increase(cs);
//			PrintCS(cs);
//		}
		
//		String words = "abcdefghijklmnopqrstuvwxyz";
//		int cnt = 0;
//		boolean visited[] = new boolean[26];
//		Random random = new Random();
//		while(cnt < WORD_NUM) {
//			int pos = random.nextInt(26);
//			if(!visited[pos]) {
//				visited[pos] = true;
//				cnt++;
//			}
//		}
//		for (int i = 0; i < visited.length; i++) {
//			if(visited[i]) System.out.print(words.substring(i, i+1));
//		}
		Scanner scan = new Scanner(System.in);
		PrintArrayWords(scan.nextLine());
	}
	public static void PrintArrayWords(String s) {
		if(s == null) return;
		ReverseArray(s.toCharArray(),0);
	}
	private static void ReverseArray(char[] charArray, int start) {
		// TODO Auto-generated method stub
		if(start == charArray.length -1) System.out.println(String.valueOf(charArray));
		else {
			for (int i = start; i < charArray.length; i++) {
				char tmp = charArray[start];
				charArray[start] = charArray[i];
				charArray[i] = tmp;
				
				ReverseArray(charArray, start+1);
				
				tmp = charArray[start];
				charArray[start] = charArray[i];
				charArray[i] = tmp;
			}
		}
	}
	private static void PrintCS(char[] cs) {
		// TODO Auto-generated method stub
		String string = String.valueOf(cs).replaceFirst("^0*", "");
		System.out.println(string);
	}
	private static void Increase(char[] cs) {
		// TODO Auto-generated method stub
		int adding = 0;
		for (int i = cs.length - 1; i >=0 ; i--) {
			int num = cs[i] - '0' + adding ;
			if(i == cs.length - 1) num++;
			adding = 0;
			if(num > 9) {
				num %= 10;
				adding = 1;
			}
			cs[i] = (char)(num + '0');
		}
	}
	

}
