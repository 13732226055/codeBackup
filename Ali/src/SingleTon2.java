/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午2:57:33 
* @Details 
*/
public class SingleTon2 {
	public SingleTon2() {
		// TODO Auto-generated constructor stub
		System.out.println("New!");
	}
	public static SingleTon2 Instance() {
		return Nested.instance;
	}
	static class Nested{
		public Nested() {
			System.out.println("Nested");
			// TODO Auto-generated constructor stub
		}
		private final static SingleTon2 instance = new SingleTon2();
	}
}
