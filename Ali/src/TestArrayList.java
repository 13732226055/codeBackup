import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList();
		 
	         // 将“”
         list.add(1);
        list.add(2);
         list.add(3);
         list.add(4);
         // 将下面的元素添加到第1个位置
         list.add(1, 5);
		
		
		
		Integer value = null;
		int size = list.size();
		for (int i=0; i<size; i++) {
		    value = (Integer)list.get(i); 
		    System.err.println(value);
		}
		Integer values = null;
		for (Integer integ:list) {
		    values = integ;
		    System.err.println(values);
		}
		Integer values2 = null;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
		    values2 = (Integer)iter.next();
		    System.out.println(values2);
		}
		Integer[] newint = list.toArray(new Integer[0]);//将ArrayList转Integer[]
		for(int i=0;i<newint.length;i++)
			System.out.println(newint[i]);
		
	}
	public static Integer[] vectorToArray2(ArrayList<Integer> v) {
	    Integer[] newText = (Integer[])v.toArray(new Integer[0]);
	    return newText;
	}

}
