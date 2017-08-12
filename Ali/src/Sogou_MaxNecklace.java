import java.util.Arrays;
import java.util.Scanner;

/*
 * 
��һ����ɫ��ʯ���������ɺܶ��ֲ�ͬ�ı�ʯ��ɵģ������챦ʯ������ʯ����ʯ����䣬����ȡ�
��һ������������ʹ͸���һ��ѧ�ߣ�������˵������Դ�������������
���������ϲ���챦ʯ������ʯ����ˮ����������ʯ�����֣���Ҫ��������н�ȡ������һС�λ����ң�
��һ���б���������е������ֱ�ʯ��ʣ�µĲ�������Դ��ߡ�
����޷��ҵ���һ��Ҳ�޷����ߡ������ѧ���ҳ�����з��������ܹ��õ����ı�ʯ�� 
��������:
������ÿ���ַ�����һ�ֱ�ʯ��A��ʾ�챦ʯ��B��ʾ����ʯ��C������ˮ����D������䣬E������ʯ��F������ʯ��G�������ȵ�
��������һ��ȫ��Ϊ��д��ĸ���ַ����б�ʾ�����ı�ʯ���У�ע����������β��ӵġ�ÿ�д���һ�������


�������:
���ѧ���ܹ��õ������ı�ʯ������ÿ��һ��

��������1:
ABCYDYE
ATTMBQECPD

�������1:
1
3
 */
public class Sogou_MaxNecklace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String necklace = scanner.nextLine();
		System.out.println(getMaxNecklace(necklace));
	}

	private static int getMaxNecklace(String necklace) {
		// TODO Auto-generated method stub	
		int[] x = new int[5];
		int length = necklace.length();
		StringBuffer necklaces = new StringBuffer(necklace);
		int last_pos = length;
		for (int i = 0; i < length; i++) {
			x[0] = necklaces.indexOf("A");
			x[1] = necklaces.indexOf("B");
			x[2] = necklaces.indexOf("C");
			x[3] = necklaces.indexOf("D");
			x[4] = necklaces.indexOf("E");
			Arrays.sort(x);
			if (last_pos > x[4]) {
				last_pos = x[4];
			}
			if(x[0] == -1) return 0;
			necklaces.append(necklaces.charAt(0));
			necklaces.deleteCharAt(0);
			
		}
		return length - last_pos - 1;
	}
}
