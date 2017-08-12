import java.util.LinkedList;
import java.util.List;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月12日 下午12:13:52 
* @Details 
* 请设计一个排队系统，能让每个排队的用户，都能看到自己在队列中所处的位置和变化，
* 队列中随时有人可能加入和退出，当有人退出影响到自己的位置时需要及时
* 反馈到用户
*/
class qNode<T>{
	private int pos;
	private T data;
	public qNode(T data, int pos) {
		setData(data);
		this.pos = pos;
	}
	public void forward() {
		this.pos --;
		System.out.println("pos-->"+this.pos);
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
@SuppressWarnings("hiding")
public class Meitu_Queue<T>{
	List<qNode> list = new LinkedList<>();
	public void add(T data) {
		qNode q = new qNode(data, list.size());
		list.add(q);
	}
	public T poll() {
		qNode data = list.remove(0);
		for(int i =0;i<list.size();i++) {
			qNode tmp = list.remove(i);
			tmp.forward();
			list.add(i, tmp);
		}
		return (T) data.getData();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Meitu_Queue<Integer> mq = new Meitu_Queue();
		mq.add(1);
		mq.add(2);
		mq.add(3);
		mq.add(4);
		System.out.println(mq.poll());
		mq.add(5);
		System.out.println(mq.poll());
		System.out.println(mq.poll());
	}

}
