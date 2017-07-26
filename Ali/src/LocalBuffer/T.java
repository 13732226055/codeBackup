package LocalBuffer;

import java.util.Collections;  

import java.util.Map;  
import java.util.concurrent.ConcurrentHashMap;

import org.omg.PortableServer.THREAD_POLICY_ID;  
/** 
 * 测试HashMap和ConcurrentHashMap的并发性能差别。 
 *  
 * @author 老紫竹 JAVA世纪网(java2000.net) 
 *  
 */  
public class T {  
  static final int threads = 1;  
  static final int NUMBER = 20;  
  public static void main(String[] args) throws Exception {  
	UserManager ums = new UserManager(); 
	ums.initUserInfoCache();
	//START 1000 THREADS TO PUT
    for (int i = 0; i < threads; i++) {  
        new BUFTestThread(ums).start();  
    }  
    while (BUFTestThread.counter > 0) {  
    	Thread.sleep(1);  
    }
    //STSRT 1000 THREADS TO GET
    
    System.out.println("");   
  }
}
class BUFTestThread extends Thread {  
  static int counter = 0;  
  static Object lock = new Object();  
  private UserManager ums ;   
  //private String key = String.valueOf(this.getId());  
  private String tid=String.valueOf(this.getId());
  private String key = 1+"";  
  BUFTestThread(UserManager ums) {  
    synchronized (lock) {  
      counter++;  
    }  
    this.ums = ums;
  }  
  public void run() {  
    for (int i = 1; i <= T.NUMBER; i++) { 
    	key=String.valueOf(i);
      ums.updateUserInfoCache(key, String.valueOf(i), String.valueOf(i));
      System.out.println("Thread-"+tid+" key:"+key+":"+String.valueOf(i)+":"+String.valueOf(i));
      try {
    	  	sleep(10);
			UserInfo buf = new UserInfo();
			//System.out.println(System.currentTimeMillis());
			if((buf = ums.getUserInfoFromCacheById(key))!=null){
				System.out.println("Thread-"+tid+" key:"+buf.getUserId()+" userName:"+buf.getUserName()+" cardNo:"+
						buf.getCardNo());
			}

      } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
      }     
    }  
    synchronized (lock) {  
      counter--;  
    }  
  }
}

