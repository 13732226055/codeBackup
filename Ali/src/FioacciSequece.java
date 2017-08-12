/** 
* @author ZYJ 
* @version 创建时间：Aug 3, 2017 6:36:16 AM 
* @Details 
*/
public class FioacciSequece {

    public static void main(String[] args) {  
        final int num = 100;  
        long begin = System.currentTimeMillis();  
        System.err.println("采用尾递归算法");  
        long result = tailRecursiveFib(0L,1L,num);  
        long end = System.currentTimeMillis();  
        System.err.println("fib("+num+")=="+result+"，耗时"+(end-begin)+"毫秒");  
    }  
	public  static long tailRecursiveFib(long a,long b,int n)  
    {  
        if(n <0 ) return -1;  
        if(n == 0) return a;  
        if(n == 1) return b;  
          
        //返回值出现在函数的末尾，且没有包含其他表达式，是尾递归！  
        return tailRecursiveFib(b, a+b, n-1);    
    }  

}
