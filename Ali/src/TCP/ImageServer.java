package TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** 
* @author ZYJ 
* @version 创建时间：Aug 4, 2017 6:25:49 PM 
* @Details 
*/
public class ImageServer{  
    public static void main(String[] args) throws Exception{  
        ServerSocket ss = new ServerSocket(10010);  
        Socket s = ss.accept();  
        BufferedInputStream bis = new BufferedInputStream(s.getInputStream());  
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/var/www/html/Rev/1.png"));  
        byte[] buf = new byte[1024*100];  
        int len = 0 ;  
        while((len=bis.read(buf))!=-1){  
            bos.write(buf, 0, len);  
        }  
        BufferedOutputStream bos2 = new BufferedOutputStream(s.getOutputStream());  
        bos2.write("upload successful".getBytes());  
        bos2.close();  
        s.close();  
        ss.close();  
    }  
} 