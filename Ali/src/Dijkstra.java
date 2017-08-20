import java.util.ArrayList;

/**
 * @author ZYJ
 * @version 创建时间：Jul 30, 2017 8:30:00 AM
 * @Details
 */
public class Dijkstra {
	public static int[][] map = { 
			{ 0, 4, 2, 0, 100 }, 
			{ 4, 0, 2, 9, 0 }, 
			{ 2, 2, 0, 2, 1 }, 
			{ 0, 9, 2, 0, 10 },
			{ 100, 0, 1, 10, 0 } 
			};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Node[] = new int[map.length];
		int visited[] = new int[map.length];
		ArrayList<String> list = new ArrayList<>();

		int pre = 0;
		visited[0] = 1;
		
		
		for (int i = 1; i < map.length; i++) {
			Node[i] = Integer.MAX_VALUE;
		}
		
		while (list.size() < map.length) {

			list.add("" + pre);
			/*
			 * 更新每个节点状态
			 */
			for (int i = 0; i < map.length; i++) {
				if (map[pre][i] != 0 ) {
					Node[i] = Math.min(map[pre][i] + Node[pre], Node[i]);
				}
			}
			/*
			 * 再从未访问的节点中找出权值最小的节点作为pre
			 */
			for (int i = 0,min = Integer.MAX_VALUE; i < Node.length; i++) {	
				if (visited[i] == 0 && min > Node[i]) {
					min = Node[i];
					pre = i;
				}
			}
			visited[pre] = 1;
		}
		System.out.println(list);
	}

}
