import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/** 
* @author ZYJ 
* @version 创建时间：Aug 6, 2017 7:31:13 AM 
* @Details 
*/
public class JavaIO_read {
	public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("f.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] b = new byte[5];
        int len;
        while((len = fis.read(b))!=-1){
            baos.write(b,0,len);//将读取的数据一次性从缓冲区中取出来
        }
        System.out.println(baos);
        
    }
}

