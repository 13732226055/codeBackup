import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.RequestingUserName;
class Node<T> implements Comparable<Node<T>>{
	private T data;
	private int weight;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T data,int weight){
		this.data=data;
		this.weight=weight;
	}

	@Override
	public int compareTo(Node<T> o) {
		// TODO Auto-generated method stub
		return (o.weight>this.weight)? -1:(o.weight==this.weight)? 0:1;
	}
	@Override
	public String toString(){
		return "data:"+this.data+",weight:"+this.weight+";";
	}
	public T getData(){
		return data;
	}
	public void setData(T data){
		this.data=data;
	}
	public int getWeight(){
		return weight;
	}
	public void setWeight(int weight){
		this.weight=weight;
	}
	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
	
}
public class Huffman {
	public static  <T> Node<T> createTree(List<Node<T>> nodes){
		while(nodes.size()>1){
			Collections.sort(nodes);
			Node left = nodes.get(0);
			Node right = nodes.get(1);
			Node parent = new Node(null, left.getWeight()+right.getWeight());
			parent.setLeft(left);
			parent.setRight(right);
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	public static <T> List<Node<T>> breath(Node root){
		List<Node<T>> list = new ArrayList<Node<T>>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node pNode = queue.poll();
			list.add(pNode);
			if(pNode.getLeft()!=null){
				queue.add(pNode.getLeft());
			}
			if(pNode.getRight()!=null){
				queue.add(pNode.getRight());
			}
		}
		return list;
		
	}
	public static <T> int dfstravel(Node pNode,int depth){
		if(pNode == null )return 0;
		System.err.println(pNode);
		if(pNode.getData()==null){
			
			depth++;
			System.err.println("Add depth:"+depth);
			return dfstravel(pNode.getLeft(),depth)+dfstravel(pNode.getRight(),depth);
		}else{
			System.out.println("Return weight:"+pNode.getWeight()+"*"+depth);
			return pNode.getWeight()*depth;
		}
	}
	public static boolean destory(Node root){
		root.setWeight(111);;
		System.gc();
		if(root==null) return true;
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1234;
		int count =0;
		String binary=Integer.toBinaryString(i);
		System.err.println(binary);
		for(int j=0;j<binary.length();j++){
			count += binary.charAt(j)-48;
		}
		System.err.println(count);
		
//		Scanner scanner=new Scanner(System.in);
//		String input = scanner.nextLine();
		String input = "1,2,3,4";
		if(input.length()!=0){
			String[] strings = input.split(",");
			List<Node<String>> nodes = new ArrayList<>();
			for(int j =0;j<strings.length;j++){
				nodes.add(new Node("node_"+j, Integer.valueOf(strings[j])));
			}
			Node root = createTree(nodes);
			System.err.println(breath(root));
			System.err.println(dfstravel(root, 0));
			destory(root);
			System.out.println(breath(root));
			//getHuffman(input);
		}	
	}
	
}
