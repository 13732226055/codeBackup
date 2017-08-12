/*
 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。 
 输入描述:
输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 1000。
第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。


输出描述:
输出保留下来的结果。

输入例子1:
325
1

输出例子1:
35
 */
import java.io.IOException;
import java.util.Scanner;

public class Sogou_CutNum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(scan.nextLine());
		int cnt;
		try {
			 cnt = Integer.valueOf(scan.nextLine());
		}catch (NumberFormatException e) {
			// TODO: handle exception
			return ;
		}
		System.out.println(getMaxAfterCut(sb,cnt));
		
	}

	private static String getMaxAfterCut(StringBuffer sb, int cnt) {
		// TODO Auto-generated method stub
		
		StringBuffer sBuffer = sb;
		if(sBuffer.length()>1000 || cnt>sBuffer.length() || cnt <1 || sBuffer.length()<1) return "";
		int max = Integer.MIN_VALUE;
		int maxpos_start = -1;
		int maxpos_end = maxpos_start;
		
		while(cnt>0) {
			max = Integer.MIN_VALUE;
			int start = maxpos_end+1;
			if(start+cnt >= sBuffer.length()) break;
			for(int i = start;i<start+cnt+1;i++) {
				if(sBuffer.charAt(i) > '9' || sBuffer.charAt(i)<'0') return "";
				if(sBuffer.charAt(i) > max) {
					maxpos_end = maxpos_start = i;
					max = sBuffer.charAt(i);
				}else if(sBuffer.charAt(i) == max) {
					maxpos_end++;
				}
			}
			sBuffer.delete(start, maxpos_start);
			cnt -= (maxpos_start-start);
			maxpos_end -= (maxpos_start-start);
			
		}
		for(;cnt>0;cnt--) {
			if(maxpos_end+1 >= sBuffer.length()) {
				sBuffer.deleteCharAt(maxpos_end--);
				continue;
			}
			if(sBuffer.charAt(maxpos_end) < sBuffer.charAt(maxpos_end+1)) {
				sBuffer.delete(maxpos_end-cnt+1, maxpos_end+1);
				break;
			}else {
				sBuffer.deleteCharAt(maxpos_end+1);
			}
		}
		return sBuffer.toString();
	}

}
