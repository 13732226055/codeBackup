import java.awt.geom.Ellipse2D;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.print.attribute.standard.RequestingUserName;

public class MyInputStream extends FilterInputStream{

	public MyInputStream(InputStream in){
		// TODO Auto-generated method stub
		super(in);
	
		
		
	}
	public int read() throws IOException{
		int c=0;
		if((c=super.read())!=-1){
			if(Character.isLowerCase((char)c))
					return Character.toUpperCase((char)c);
			else if(Character.isUpperCase((char)c))
				return Character.toLowerCase((char)c);
			else
				return c;
		}else{
			return -1;
		}	
	}
}
