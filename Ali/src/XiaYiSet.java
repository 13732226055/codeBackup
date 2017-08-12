import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* @author ZYJ 
* @version 创建时间：Aug 6, 2017 6:36:50 AM 
* @Details 
* 小易最近在数学课上学习到了集合的概念,集合有三个特征：1.确定性 2.互异性 3.无序性.
小易的老师给了小易这样一个集合：
S = { p/q | w ≤ p ≤ x, y ≤ q ≤ z }
需要根据给定的w，x，y，z,求出集合中一共有多少个元素。小易才学习了集合还解决不了这个复杂的问题,需要你来帮助他。
输入描述:

输入包括一行：
一共4个整数分别是w(1 ≤ w ≤ x)，x(1 ≤ x ≤ 100)，y(1 ≤ y ≤ z)，z(1 ≤ z ≤ 100).以空格分隔



输出描述:

输出集合中元素的个数


输入例子1:

1 10 1 1


输出例子1:

10
*/
public class XiaYiSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		System.out.println(getSetsNum(w,x,y,z));
	}

	private static int getSetsNum(int w, int x, int y, int z) {
		// TODO Auto-generated method stub
		Set<Float> set = new HashSet<>();
		for(int i=w;i<x+1;i++)
			for(int j=y;j<z+1;j++)
				set.add(i/(float)j);
		return set.size();
	}

}
