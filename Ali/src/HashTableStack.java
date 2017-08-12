import java.util.Hashtable;

/** 
* @author ZYJ 
* @version 创建时间：Aug 8, 2017 7:10:21 AM 
 * @param <K>
 * @param <T>
* @Details 
* 已知模块类Hashtable<KeyT, ValueT>支持get(key)，
* set(key,value)和delete(key)的操作，
* 请使用该Hashtable作为唯一成员变量，实现一个栈（Stack）类，
* 支持入栈（push）和出栈（pop）的操作。 
*/
public class HashTableStack{
	public static void main(String[] args) {
		myHashTableStack<String> mStack = new myHashTableStack();
		mStack.push("111");
		mStack.push("112");
		mStack.push("113");
		System.out.println(mStack.pop());
		System.out.println(mStack.pop());
		System.out.println(mStack.pop());
	}
}
class myHashTableStack<V> {
	private Hashtable<Integer, V> table = new Hashtable<>();
	public void push(V value) {
		int size = table.size();
		if(value != null){
			table.put(size,  value);
		}
	}
	public V pop(){
		int size = table.size();	
		V value = table.get(size-1);
		table.remove(size-1);
		return value;
	}
	

}
