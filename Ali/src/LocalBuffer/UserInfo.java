package LocalBuffer;


public class UserInfo {
	private String userId;
	private String userName;
	private String cardNo;
	private long timeOut;
	private boolean expired;
		
	public UserInfo(String userId,String userName,String cardNo){
		super();
		this.setUserId(userId);
		this.setUserName(userName);
		this.setCardNo(cardNo);
		setTimeOut(System.currentTimeMillis()+1000*60*30);	
		setExpired(false);
	}
	public UserInfo(String userId,String userName,String cardNo,long time,boolean expired){
		super();
		this.setUserId(userId);
		this.setUserName(userName);
		this.setCardNo(cardNo);
		setTimeOut(time);
		//如果超时则重置时间为最后一次读取操作时间
		setExpired(true);
	}
	public UserInfo(){
		super();
	}
	public void setExpired(boolean expired) {
        this.expired = expired;
	}
	public boolean getExpired() {
		return expired;
	}
    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
    public long getTimeOut() {
        return timeOut;
    }
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

    
}
