
public class TestAutoPackage {
	public static void main(String args[]){
		Integer i = 1000;
		Integer j = 1000;
		int k=0;
		int g=0;
		System.out.println(i.equals(j));
		/*
		 * new Integer 与 new 比较, ==的结果都为false，因为两者都在堆中，equals比较为true；
		 * Integer 与 new 比较，==结果为false，因为Integer在栈中，new在堆中，equals为true；
		 * Integer 与 Integer比较，在[-128,127]内==为true，因为会执行Integer.valueOf(x)的方法，而此方法会在x在[-128,127]时
		 * 将x放入IntegerCache中，equals无论在什么区间都为true;
		 * int 与 Integer 比较，Integer会被封装为int，==为true，int没有equals方法.
		 */
		
		((TestAutoPackage)null).testMethod(); //静态方法可以直接使用 类名.方法名 调用，null可以被强制转化为任何类型（并不一定是对象）
		TestAutoPackage q = new TestAutoPackage();
		String string = null;
		((TestAutoPackage)null).testMethod(); //静态方法可以直接使用 类名.方法名 调用，null可以被强制转化为任何类型（并不一定是对象）
	}
	public static void testMethod(){ 
		System.out.println("TEST!");
	}
}
