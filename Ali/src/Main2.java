import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        String str = input.nextLine();      
        String pattern = input.nextLine();     
   
      Main2 t =new Main2();
      t.filter(str, pattern);
    	  
	}
	public void filter(String str,String pattern){
		String regEx ;//10?-*-done
	    regEx = pattern.replaceAll("[*]", "[.*]");
	    regEx = regEx.replaceAll("[?]", "[.{1}]");
	    regEx = regEx.replace("[", "");
	    regEx = regEx.replace("]", "");
	     
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
