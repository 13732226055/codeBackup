package LocalBuffer;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	     String str = input.nextLine();  
	     Main mains =new Main();
	     System.out.println(mains.evalRPN(str));
    }
	public int evalRPN(String token) {
    	Stack<Integer> s=new Stack<Integer>();
    	 char num[] = token.toCharArray();
    	 int count = 0,test=0;
    	 for (int i = 0; i < num.length; i++) {
    		// 判断输入的数字是否为数字还是字符
    		if (Character.isDigit(num[i])) count++;
    		if(num[i] =='+' || num[i]=='-'||num[i]=='*'||num[i]=='/') test+=2;
    		if(num[i]=='^' && count==0) return 0;
    	 }
    	 if( test!=count) return -1;
    	String[] tokens =token.split(" ");
    	
    	for (int i=0;i<tokens.length;i++){
    		if(tokens[i].equals("+")){
    			int right=s.pop();
    			int left=s.pop();
    			int result=left+right;
    			s.push(result);
    		}else if(tokens[i].equals("*")){
    			int right=s.pop();
    			int left=s.pop();
    			int result=left*right;
    			s.push(result);
    		}else if(tokens[i].equals("-")){
    			int right=s.pop();
    			int left=s.pop();
    			int result=left-right;
    			s.push(result);
    		}else if(tokens[i].equals("/")){
    			int right=s.pop();
    			int left=s.pop();
    			int result=left/right;
    			s.push(result);
    		}else if(tokens[i].equals("^")){
    			int right=s.pop();
    			//int left=s.pop();
    			int result=right*right;
    			s.push(result);
    		}else{
    			s.push(Integer.parseInt(tokens[i]));
    		}
    		if(s.size()>16) return 0;
    	}
    	int result = s.pop();
    	if(s.isEmpty()) return result;
    	else return -1;
    }
}