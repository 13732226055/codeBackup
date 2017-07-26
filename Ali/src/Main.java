import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
       // String str = input.nextLine();      
       // String pattern = input.nextLine();     
   String str ="200-paid-done";
   String pattern="2***]paid*done";
      Main t =new Main();
      t.filter(str, pattern);
    	  
	}
	public void filter(String str,String pattern){
		String regEx ;//10?-*-done
		
		if(pattern.contains("[")||pattern.contains("]")) {
			System.out.println(0);
			return;
		}
	    pattern = pattern.replaceAll("\\*+", "[*]");
	    pattern = pattern.replaceAll("\\?+", "[?]");

	    pattern = pattern.replace("[*", "*");
	    pattern = pattern.replace("[?", "?");
	    pattern = pattern.replace("*]", "*");
	    pattern = pattern.replace("?]", "?");

	    
	    
		regEx = pattern.replaceAll("[*]", "[[a-zA-Z0-9\\-]*]");
		
	    regEx = regEx.replaceAll("[?]", "[[a-zA-Z0-9\\-]{1}]");
	    regEx = regEx.replace("[*", "*");
	    regEx = regEx.replace("*]", "*");
	    regEx = regEx.replace("}]", "}");
	    regEx = regEx.replace("[[", "[");
	    regEx = regEx.replace("]]", "]");
	    
	    
	     /*200-paid-done
	       2*paid*done
	      * 
	      */
	    System.out.println(regEx);
	    
	      Pattern patterns = Pattern.compile(regEx);
	       // 忽略大小写的写法       
	      Matcher matcher = patterns.matcher(str);
	       // 查找字符串中是否有匹配正则表达式的字符/字符串
	      boolean rs = matcher.find();
	      if(rs){
	       System.out.println(1);      
	      }
	      else System.out.println(0);
	      
	}
}
