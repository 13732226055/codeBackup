import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午2:19:19 
* @Details 
*/
public class TreeSetTest {
	static int NUMX = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[NUMX];
		for(int i=0;i<NUMX;i++) {
			nums[i] = scan.nextInt();
		}
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2) return 1;
				else if(o1 < o2) return -1;
				return 0;
			}
		});
		for (int i : nums) {
			ts.add(i);
		}
		System.out.println(ts.toString());
	}

}
