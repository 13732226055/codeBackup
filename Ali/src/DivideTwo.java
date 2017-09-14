/** 
* @author ZYJ 
* @version 创建时间：2017年9月11日 下午2:01:27 
* @Details 
*/
public class DivideTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
		int L = 0;
		int R = nums.length -1;
		int T = 6;
		while(L <= R) {
			int mid = (L+R)/2;
			int num = nums[mid];
			if(num < T) {
				L = mid+1;
			}
			if(num>T) {
				R = mid -1;
			}
			else if(num == T){
				
				System.out.println(mid);
				return;
			}
		}
		System.out.println("-1");
	}

}
