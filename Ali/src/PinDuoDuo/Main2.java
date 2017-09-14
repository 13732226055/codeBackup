package PinDuoDuo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

import PinDuoDuo.Main.Bear;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午3:34:26 
* @Details 打印树形目录
10
java-root -1
word 5
class 3
bin 0
java 5
src 0
run 3
fast 3
readme 0
test 0
*/
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		List<Node> list = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		Node root = null;
		for(int i =0 ;i<n;i++) {
			String[] strings = scan.nextLine().split(" ");
			Node node = new Node(strings[0], Integer.valueOf(strings[1]), i);
			list.add(node);
			if(Integer.valueOf(strings[1]) == -1) {
				queue.add(node);
				root = node;
			}
		}
		// Building Tree
		Collections.sort(list);
		
		
		while(!queue.isEmpty()) {
			Node index = queue.poll();
			
			Iterator<Node> it = list.iterator();
			while(it.hasNext()) {
				Node tmp = it.next();
				
				if(tmp.parent == index.number) {
					index.addSon(tmp);
					queue.add(tmp);
					
				}
			}
		}
		dfstravel(root,true,0);
//		
		
	}
	public static <T> int dfstravel(Node pNode, boolean flag,int depth){
		if(pNode == null )return 0;
		String tree;
		if(flag) tree = "|--";
		else tree = "`--";
		if(depth == 1) System.out.print(tree);
		if(depth > 1) {
			for(int i = 1;i<depth;i++) {
				System.out.print("|  ");
			}
			System.out.print(tree);
		}
		System.out.println(pNode);
		depth++;
		Queue<Node> queue = new LinkedList<>(pNode.soNodes);
		while(!queue.isEmpty()) {
			if(queue.size()>1)
				dfstravel(queue.poll(),true,depth);
			else dfstravel(queue.poll(), false,depth);
		}
		return 0;
	}
	static class Node  implements Comparable<Node>{
		private String name;
		private int parent; 
		private int number;
		private List<Node> soNodes = new LinkedList<>();
		public void addSon(Node node) {
			soNodes.add(node);
		}
		public Node(String name, int parent,int number) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.parent = parent;
			this.number = number;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.name.compareTo(o.name);
//			if(o.parent > this.parent) {
//				return -1;
//			}else if(o.parent < this.parent) return 1;
//			return 0;
		}
		@Override
		public String toString(){
			return this.name;
			//return "name:"+this.name+",parent:"+this.parent+",number:"+this.number+";";
		}
		
	}
}
