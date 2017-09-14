import java.util.Scanner;

import javax.swing.plaf.multi.MultiTableHeaderUI;

import java.util.Arrays;
public class TwoCPU{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();      
        int[] work = new int[length];
        int sum=0;
        for(int i=0;i<length;i++) 
        	//work[i]=(int) (Math.log(input.nextInt())/Math.log(2));  
        {	work[i]=(int)(input.nextInt());
        	sum+=work[i];
        }
        //System.out.println(input.nextInt());
        
		//Arrays.sort(work);
		System.out.println(Arrays.toString(work));
		int[] cpu1 = new int[sum/2+1];	
		//int[][] handler =new int[length+1][sum/2+1];
		for(int i=0;i<=length;i++){
			System.out.println(i);
//			for(int j=0;j<=sum/2;j++){
			for(int j=sum/2;j>0;j--){
				//handler[i][j]= i==0?0:handler[i-1][j];
				//if(i>0 && j>=work[i-1]) handler[i][j] = Math.max(handler[i-1][j],handler[i-1][j-work[i-1]]+work[i-1]);
				if(i>0 && j>=work[i-1]) cpu1[j] = Math.max(cpu1[j], cpu1[j-work[i-1]]+work[i-1]);
				//work[i]表示第i项cpu任务所需空间，cpu1[j]表示cpu1在拥有空间大小为j时所能存放的最大任务空间
				System.out.println(Arrays.toString(cpu1));
			}
		}
		int j = sum/2;
	
		/*
		 * int[] x =new int[length+1];
		for(int i=length; i>0; --i){
			if(handler[i][j] > handler[i-1][j]){
				x[i-1] = 1;
				j = j - work[i-1];
			}
		}
		
		for(int i=0; i<length; ++i)	System.out.println(x[i]);
		*/
		System.out.println(Math.max(cpu1[sum/2], sum-cpu1[sum/2]));
		//System.out.println(Arrays.toString(handler));
		//System.out.println(Math.max(handler[length][sum/2], sum - handler[length][sum/2])*1024);

			
    }
}
