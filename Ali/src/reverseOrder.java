import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/** 
* @author ZYJ 
* @version 创建时间：Jul 28, 2017 6:49:11 PM 
* @Details 
* 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
现在给出一个数字序列，允许使用一种转换操作：
选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。

输入描述:
输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50)
第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。

输出描述:
输出一个数，表示最少需要的转换次数

输入例子:
4
1 1 1 3

输出例子:
2
*/
public class reverseOrder {
	public static boolean isReverseOrder(List<Integer> items) {
		
		List<Integer> tmp = new ArrayList<>() ;
		tmp.addAll(items);
		Collections.reverse(tmp);
		return items.equals(tmp)? true:false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n =scanner.nextInt();
		scanner.nextLine();
		String string = scanner.nextLine();
		LinkedList<Integer> list = new LinkedList<>();
		for (String str : string.split(" ")) {
			list.add(Integer.valueOf(str));
		}
		
		//List<Integer> items = Arrays.asList(item);//只能用Integer作为泛型，因为asList函数调用时的参数为foo(T... a)，是一个可变参数的函数
													//，它会将传入的每个数组元素的一个对象作为一个参数：
													//如果是asList(new Integer[]{1,2,3}),那么foo会根据数组中对象的数量并确定参数的数量，
													//并为每个参数add();
													//如果asList(new int[]{1,2,3}),foo会判断一个int[]为一个对象（int是基本类型不是对象），
													//那么只会传入一个参数
		//System.out.println(isReverseOrder(items));
		
		//LinkedList<Integer> list = new LinkedList<>(items); 
		System.out.println(getStep_better(list));
	}
	private static int getStep(LinkedList<Integer> list,int pos) {
		// TODO Auto-generated method stub
		int step = 0;
		if(list.size() <2 ) return step;
		for(int i =0,j=list.size()-1;i<j;){
			
			if(list.get(i) > list.get(j)){
				int tmp = list.remove(j) + list.remove(j-1);
				list.add(--j, tmp);				
				step++;
				//System.out.println(list);
			}
			if(list.get(i) < list.get(j)){
				int tmp = list.remove(i)+list.remove(i);
				list.add(i, tmp);
				j--;
				step++;
				//System.out.println(list);
			}
			if(list.get(i) == list.get(j)){
				i++;j--;
				//System.out.println(list);
			}
		}
		return step;
	}
	private static int getStep_better(LinkedList<Integer> list) {
		// TODO Auto-generated method stub
		int step = 0;
		if(list.size() <2 ) return step;
		int i=0,j=list.size()-1;
		int left = list.get(i);
		int right = list.get(j);
			
		while(i<j){
			if(left>right){
				step++;
				right+=list.get(--j);
			}else if(left < right){
				step++;
				left+=list.get(++i);
			}else{
				i++;j--;
				left = list.get(i);
				right = list.get(j);
			}
		}
		
		return step;
	}
}
