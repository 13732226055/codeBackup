/*
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 
 * 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，
 * 以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。 
 * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
 * 若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。 
 * 输入数值范围：2<=n<=100,0<=prices[i]<=100
 * 输入
	3,8,5,1,7,8
	输出
	12
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Stork {
	public static void main(String[] args) {
		Scanner scanner	=	new Scanner(System.in);
		String[] strings	=	scanner.nextLine().split(",");
		
		int i=0;
		int[] prices = new int[strings.length];
		for(String string : strings){
			prices[i++]	=	Integer.valueOf(string);
		}
		System.out.println(calculateMax(prices));
	}
	public static int calculateMax(int[] prices){
		long startTime=System.currentTimeMillis(); 
//		int i=0,j=0,k=0,l=0,max=0,tmp=0;
//		for(i=0;i<prices.length;i++){
//			for(j=i;j<prices.length;j++){
//				for(k=j;k<prices.length;k++){
//					for(l=k;l<prices.length;l++){
//						max	=	Math.max(max, prices[j]-prices[i]+prices[l]-prices[k]);
//						if(max==(prices[j]-prices[i]+prices[l]-prices[k]))
//							System.out.print(">>");
//								
//						System.out.println(max+":"+i+" "+j+" "+k+" "+l);
//					}
//				}
//			}
//		}
//		此算法运行时间过长
		 // these four variables represent your profit after executing corresponding transaction
	    // in the beginning, your profit is 0. 
	    // when you buy a stock ,the profit will be deducted of the price of stock.
	    int firstBuy = Integer.MIN_VALUE, firstSell = 0;
	    int secondBuy = Integer.MIN_VALUE, secondSell = 0;

	    for (int curPrice : prices) {
	        firstBuy	= Math.max(firstBuy, -curPrice); // the max profit after you buy first stock
	        firstSell 	= Math.max(firstSell, firstBuy + curPrice); // the max profit after you sell it
	        secondBuy 	= Math.max(secondBuy, firstSell - curPrice); // the max profit after you buy the second stock
	        secondSell	= Math.max(secondSell, secondBuy + curPrice); // the max profit after you sell the second stock
	    }
	    long endTime=System.currentTimeMillis(); //获取结束时间

		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		
	    return secondSell; // secondSell will be the max profit after passing the prices
		
		
	}
}
