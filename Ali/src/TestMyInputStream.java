import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Collator;
import java.util.Collection;
import java.util.Iterator;

import org.omg.IOP.ServiceContext;

public class TestMyInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c=0;
		System.out.println("classpath:");
		try{
			InputStream is= new MyInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
			while((c=is.read())>=0){
				System.out.print((char)c);
			}
			is.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
