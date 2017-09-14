package Xiaozhao;

import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
/** 请完成下面这个process函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
	static int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
	static int price = CUSTOMS_LIMIT_MONEY_PER_BOX;
	static int length;
	static int width;
	static int height;
	private static int process(Model[] items) 
	{
		int sum_price = 0;
		int maxmater = Math.max(height, Math.max(length, width));
		for (int i = 0; i < items.length; i++) {
			sum_price += items[i].price;
			if(items[i].height >  maxmater
					|| items[i].length > maxmater
					|| items[i].width > maxmater
					|| items[i].length+items[i].width+items[i].width 
								> height+width+length) {
				return -1;
			}
		}
		
		if(sum_price <= 2000) return 0;
		
		return CUSTOMS_LIMIT_MONEY_PER_BOX;
	
	}
	public static void main(String args[]){
	        Scanner scanner = new Scanner(System.in);
	
	        while (scanner.hasNext()){
	            length = scanner.nextInt();
	            width = scanner.nextInt();
	            height = scanner.nextInt();
	
	            int itemNum = scanner.nextInt();
	            Model[] items = new Model[itemNum];
	            for(int i=0; i<itemNum; i++){
	                Model item = new Model();
	                item.price = scanner.nextInt();
	                item.length = scanner.nextInt();
	                item.width = scanner.nextInt();
	                item.height = scanner.nextInt();
	                items[i] = item;
	            }
	            long startTime = System.currentTimeMillis();
	            
	          System.out.println (process(items));
	        
	        }
		}

    }
class Model {
	public int price;
	public int length;
	public int width;
	public int height;
}
