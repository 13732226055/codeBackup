import java.util.LinkedList;
import java.util.Queue;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月20日 上午10:55:15 
* @Details 
*/
public class BinaryTreeMinDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMinDepth b = new BinaryTreeMinDepth();
		System.out.println(b.run(null));
	}
	public int run(TreeNode root) {
		if(root == null) return 0;
		int left_depth = run(root.left);
		int right_depth = run(root.right);
		if(left_depth==0 || right_depth == 0)
			return 1+left_depth+right_depth;
		return 1+Math.min(left_depth, right_depth);
	}
	
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
 TreeNode(int x) { val = x; }
}
 