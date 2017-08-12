import java.util.ArrayList;

/**
 * @author ZYJ
 * @version 创建时间：Jul 30, 2017 8:30:00 AM
 * @Details
 */
public class Dijkstra {
	public static int[][] map = { { 0, 2, 3, 1, -1 }, { 2, 0, 1, 4, 2 }, { 3, 1, 0, 5, 1 }, { 1, 4, 5, 0, 2 },
			{ -1, 2, 1, 2, 0 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Node[] = new int[map.length];
		int visited[] = new int[map.length];
		ArrayList<String> list = new ArrayList<>();
		int pre = 0;
		visited[0] = 1;
		for (int i = 0; i < map.length; i++) {
			Node[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < map.length; i++) {
			Node[i] = Math.min(map[pre][i] + Node[pre], Node[i]);
		}
		for (int i = 0; i < Node.length; i++) {
			int min = Integer.MAX_VALUE;
			if (visited[i] == 0 && min > Node[i]) {
				min = Node[i];
				pre = i;
			}
		}
		System.out.println(list);
	}

}
