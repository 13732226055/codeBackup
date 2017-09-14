import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator.OfDouble;

/** 
* @author ZYJ 
* @version 创建时间：2017年9月2日 下午4:48:47 
* @Details 
*/
public class testOverrideEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test("ss",1);
		Map<Integer, Test> map = new HashMap<>();
		map.put(0, t);
		Test t2 = new Test("",1);
		if(map.containsValue(t2)) System.out.println(11111);
		
	}
	static class Test{
		private int num;
		private String name ;
		public Test(String name,int num) {
			// TODO Auto-generated constructor stub
			this.name =name;
			this.num =num;
		}
		public boolean equals(Object obj) {
			Test o = (Test)obj; 
			if(o.num == this.num) {
				return true;
			}
			return false;
		}
	}

}
