
public class FirstBadVer {
	public static void main(String args[]){
		int[] versions = {1,2,3,4,5,6,7,8,9};
		FirstBadVer f = new FirstBadVer();
		System.out.println(f.FindBadVersion(versions));
	}
	public int FindBadVersion(int[] nums){
		int end = nums.length-1;
		int start  = 0,flag=0;
		for(int i=end;i>start;i--){
			System.out.println(nums[i]);
			if(isBadVersion(nums[i]))
			{	if(!isBadVersion(nums[i-1])) return i;
				i=start+(end-start)/2;
			}
			else i=i+(end-start)/2;
		}
		return 0;
		
	}
	boolean isBadVersion(int version){
		if(5 >= version) return true;
		return false;
		
	}
}
