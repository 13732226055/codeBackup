
public class SYSGC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a =new A();
		B b =new B();
		//a.b=b;
		//b.a=a;
		//b=null;
		//a=null;
		//System.gc();
		//System.out.println(.hashCode());
		//for(int i=0;i=0;i++) 
		System.out.print("End");
	}

}
class A{

	public B b;
	public void finalize(){
		System.out.print("A deleted");
	}
};
class B{

	public A a;
	public void finalize(){
		System.out.print("B deleted");
	}
}
