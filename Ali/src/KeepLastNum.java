import java.util.Arrays;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Aug 3, 2017 11:12:24 PM 
* @Details 
* 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
输入描述:

输入包括两行：
第一行为序列长度n(1 ≤ n ≤ 50)
第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔



输出描述:

输出消除重复元素之后的序列，以空格分隔，行末无空格


输入例子1:

9
100 100 100 99 99 99 100 100 100


输出例子1:

99 100
*/
public class KeepLastNum {
	public final static int Range = 1001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		scan.nextLine();
		//int[] sequence = (int[]) Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray(); //使用Stream转化字符串
		int[] sequence = new int[length];
		int i=0;
		while(i<length){
			sequence[i++] = scan.nextInt();
		}
		System.out.println(DistinctSeq(sequence));
	}

	private static String DistinctSeq(int[] sequence) {
		// TODO Auto-generated method stub
		int[] pos = new int[Range];
		for(int i=0;i<Range;i++){
			pos[i] = -1;
		}
		for(int i =0;i<sequence.length;i++){
			pos[sequence[i]] = (pos[sequence[i]]<i)? i:pos[sequence[i]];
		}
		int[] list = new int[Range];
		for(int i =0;i<Range;i++){
			if(pos[i] != -1)
				list[pos[i]] = i;
		}
		String result = "";
		for(int i=0;i<Range;i++){
			if(list[i]!=0)
				result += " "+String.valueOf(list[i]);
		}
		return result.trim();
	}

}
