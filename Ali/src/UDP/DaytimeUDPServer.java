package UDP;
/** 
* @author ZYJ 
* @version 创建时间：Aug 4, 2017 6:13:30 PM 
* @Details 
*/
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class DaytimeUDPServer {

    private final static int PORT = 1303;
    
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request);
                    
                    String daytime = new Date().toString();
                    byte[] data = daytime.getBytes("ASCII");
                    DatagramPacket response = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
                    socket.send(response);
                    System.out.println(daytime + " " + request.getAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
