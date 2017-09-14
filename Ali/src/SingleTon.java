/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午2:46:20 
* @Details 
* 由于java的特性，我们在初始化静态变量instance的时候就创建了一个实例，类静态成员会随着类的加载而加载，并且
* 静态成员只会在常量方法区保留一份数据，这样就可以保证在全局范围内，SingleTon是单例模式。
*/
public class SingleTon {
	
	public SingleTon() {
		System.out.println("NEw");
		// TODO Auto-generated constructor stub
	}
	private static SingleTon instance = new SingleTon();
	public static SingleTon Instance() {
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleTon singleTon= SingleTon.Instance();
	}

}
