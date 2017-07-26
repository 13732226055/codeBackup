import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.imageio.ImageTypeSpecifier;

public class regEx {
	public static void main(String[] args) {
		String s = "1,2,4";
		String regEx = "\\d+";
		Pattern pattern = Pattern.compile("\\d+,");
		Matcher matcher = pattern.matcher(s);
		while(matcher.find()){
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group());
		}
		
	}
	
	
}
