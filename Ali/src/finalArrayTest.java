import javax.swing.text.html.CSS;

class AA{
	final public  String s = "111";
	final public String so=new String("111");
	public final char[] cs = "hello".toCharArray();
	public final char[] cs2={'h','e','l','l','o'};
	public final char ch='y';
	public final char ch2='y';
	public final int j=1;
	public int i=0;
}
public class finalArrayTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA a1 = new AA();
		AA a2 = new AA();
		String s2 = new String("111");
		System.err.println("数组");
		System.out.println((a1.cs==a2.cs)+"a1.cs:"+a1.cs.hashCode()+" a2.cs:"+a2.cs.hashCode());
		System.out.println(a1.cs==a1.cs2);
		System.out.println(a1.cs2==a2.cs2);
		a1.cs2[1]='E';
		a1.so.valueOf("222");
		System.out.println("Chaange a1 char[]:"+a2.cs[1]);
		System.out.println("Chaange a1 string object:"+a2.so);
		System.out.println((a1.cs[0]==a2.cs[0]));
		System.err.println("字符串");
		System.out.println((a1.s==a2.s)+" a1:"+a1.s.hashCode()+" a2: "+a2.s.hashCode());
		System.out.println(a1.s==s2);
		System.out.println(a1.s.equals(s2));
		
		System.out.println(a1.so);
		System.out.println("字符");
		System.err.println(a1.ch==a1.ch2);
		
		System.out.println("不同对象成员是否共享");
		a1.i = 2;
		System.err.println("i:"+a2.i);
	}

}
