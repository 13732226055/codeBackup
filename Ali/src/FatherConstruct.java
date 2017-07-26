import java.util.concurrent.Callable;

class Father{
	private String name = "Father";
	public Father(){
		call();
	}
	public void call(){
		System.out.println(name);
	}
	
}
public class FatherConstruct extends Father{
	private String name = "Son";
	public FatherConstruct() {
		// TODO Auto-generated constructor stub
		call();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father f = new FatherConstruct();
		//在执行该语句时，先创建基类对象->调用基类构造函数->调用call()，但派生类中存在call()，所以此时调用
		//派生类中的call(),此时派生类还未创建，输出null->创建派生类->调用派生类构造函数->调用call(),此时派生类
		//已经创建，所以输出Son
	}
	public void call(){
		System.out.println(name);
	}

}
