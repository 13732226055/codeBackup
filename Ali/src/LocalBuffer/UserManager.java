package LocalBuffer;

import java.util.Iterator;
import java.util.PrimitiveIterator.OfDouble;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
public class UserManager {
	private static ConcurrentHashMap userInfoCache = new ConcurrentHashMap();
	public int MAXSIZE=10;
	public UserManager(){
		super();
	}
	public synchronized void initUserInfoCache(){
		userInfoCache.clear();
		/*
		Iterator it=userInfoCache.keySet().iterator();      
        while(it.hasNext())
        {
            String str=(String)it.next();                          
            it.remove();  
        } 
        */ 	
	}
	public UserInfo getUserInfoFromCacheById(String id){
		if(userInfoCache.containsKey(id)){
			//synchronized (userInfoCache) {
				UserInfo info = (UserInfo) userInfoCache.get(id);
				if(info.getTimeOut() < 0 || info.getTimeOut()<= System.currentTimeMillis() && !info.getExpired()){
					updateUserInfoCache(id,null,null,System.currentTimeMillis(),true);
					info = (UserInfo) userInfoCache.get(id);
					//userInfoCache.remove(id);
				}
				return info;
			//}			
		}
		return null;
		
	}
	public void updateUserInfoCache(String id, String userName, String cardNo){
		if(userInfoCache.size()>=MAXSIZE) return;
		UserInfo info = new UserInfo(id,userName,cardNo);
		userInfoCache.put(id, info);
	}
	public void updateUserInfoCache(String id, String userName, String cardNo,long time,boolean expired){
		if(userInfoCache.size()>=MAXSIZE) return;
		UserInfo info = new UserInfo(id,userName,cardNo,time,expired);
		info.setExpired(true);
		userInfoCache.put(id, info);
	}
    
    
}
