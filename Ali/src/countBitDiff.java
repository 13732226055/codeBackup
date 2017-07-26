import java.util.Scanner;

//input two int32 number then counts their diff in bit
public class countBitDiff {
	// @param int32 m,n
	//return int count
	public static int countDiff(int m,int n){
		int count=0,diff=m^n;
		while(diff>0){
			count++;
			diff&=diff-1;
		}
		return count;
	}
	public static void main(String[] args){
		Scanner scanner= new Scanner(System.in);
		System.out.println(countDiff(scanner.nextInt(), scanner.nextInt()));
	}
	
}
