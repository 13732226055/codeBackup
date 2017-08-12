package TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/** 
* @author ZYJ 
* @version 创建时间：Aug 4, 2017 6:26:22 PM 
* @Details 
*/
public class ImageClient{  
    public static void main(String[] args) throws Exception{  
        Socket imageClientSocket = new Socket("127.0.0.1",10010);  
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/var/www/html/1.png"));  
        BufferedOutputStream bos = new BufferedOutputStream(imageClientSocket.getOutputStream());  
        byte[] buf = new byte[1024*100];  
        int len = 0 ;  
        while((len=bis.read(buf))!=-1){  
            bos.write(buf,0,len);  
        }  
        imageClientSocket.shutdownOutput();  
        BufferedInputStream bis2 = new BufferedInputStream(imageClientSocket.getInputStream());  
        byte[] buf2 = new byte[1024];  
        int len2 = 0 ;  
        while((len2=bis2.read(buf2))!=-1){  
            System.out.println(new String(buf2,0,len2));  
        }  
        bis.close();  
        imageClientSocket.close();  
          
    }  
}  
  