import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Aug 3, 2017 7:24:16 PM 
* @Details 
*  题目描述：
幼儿园有n个小朋友排为一个队伍，男生用“B”表示，女生用“G”表示。当男女同挨着时便会发生矛盾。需要对所排的队伍进行调整，每次调整只能让相邻的小朋友交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：GGBGG->GGBGB->GGGBB这样就能使之前的两处男女相邻变为一处男女相邻，需要调整队形两次。

程序输入：输入一个数据包括一个长度为N且只包含Ｇ和Ｂ的字符串。
输入：ＧＧＢＢＧ
输出：２
*/
public class BoyAndGrilSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		char[] cs = scan.nextLine().toCharArray();
		int step = Math.min(StepToLeft(cs,'G'), StepToLeft(cs,'B'));
		System.out.println(step);
	}

	private static int StepToLeft(char[] cs, char c) {
		// TODO Auto-generated method stub
		int step = 0;
		for(int i=0,position=0;i<cs.length;i++)
		{
			if(cs[i] == c){
				step += i-position++;
			}
		}
		return step;
	}

}
