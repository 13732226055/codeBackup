import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.naming.ldap.SortControl;


public class QuickSortTree {
	int max=0;
	int min=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8,9};
		QuickSortTree QS = new QuickSortTree();
		BinaryTree T = QS.buildTree(arr);
		QS.max=QS.min=T.date;
		QS.findDiffer(T);
		System.out.println("Differ:"+Math.abs(QS.max-QS.min));
	}
	public BinaryTree buildTree(int[] arr){
		BinaryTree T = new BinaryTree();
		Queue<BinaryTree> Q =new LinkedList<BinaryTree>(); //使用队列建立二叉树
		if(arr.length<1) return null;
		T.date=arr[0];
		Q.offer(T);
		if(arr.length==1) return T;
		BinaryTree temp = new BinaryTree();
		for(int i=1;i<arr.length;){
			temp = Q.poll();			
			BinaryTree Left = new BinaryTree();
			Left.date = arr[i++];
			temp.left = Left;
			Q.offer(Left);
			if(i==arr.length) return T; 
			BinaryTree Right = new BinaryTree();
			Right.date = arr[i++];
			temp.right= Right;
			Q.offer(Right);
		}
		return T;
	}
	public void findDiffer(BinaryTree T){
		//前序遍历
		if(T==null) return;
		System.out.println(T.date);
		if(T.date>max) max=T.date;
		if(T.date<min) min=T.date;
		if(T.left!=null) findDiffer(T.left);
		if(T.right!=null)findDiffer(T.right);
	}
}
class BinaryTree{
	int date=0;
	BinaryTree left =null;
	BinaryTree right=null;		
}