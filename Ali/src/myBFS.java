import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Vector;
import java.util.function.IntPredicate;

import javax.lang.model.element.QualifiedNameable;

/** 
* @author ZYJ 
* @version 创建时间：Jul 26, 2017 6:37:50 PM 
* @Details 
*/
public class myBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map ={
				{1,1,0,1,1,1,1},
				{1,1,1,1,0,0,1},
				{0,1,0,1,1,0,1},
				{1,1,0,0,1,1,1},
				{0,0,0,1,0,0,0}
		};
		List<String> path = new LinkedList(); 
		int[] source = {0,0};
		int[] target = {3,5};
		path = BFS(map,source,target);
		System.out.println(path.size()-1);
		System.out.println(path);
		source[0] = 0;
		source[1] = 6;
		target[0] =4;
		target[1] = 3;
		
		path = BFS(map,source,target);
	
		System.out.println(path);
		System.out.println(path.size()-1);
		
	}

	private static List<String> BFS(int[][] map, int[] source, int[] target) {
		// TODO Auto-generated method stub
		if(map==null) return null;
		
		boolean[][] visited = new boolean[map.length][map[0].length];
		Queue<int[]> queue = new LinkedList<>();
		int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
		Map<Integer[], Integer[]> path = new HashMap();
		List<String> list = new LinkedList<>();
		//queue.add(target);
		Iterator<int[]> iterator = queue.iterator();
		while(iterator.hasNext()){
			int[] tmp = iterator.next();
			System.out.println(tmp[0]);
		}
		//Set All Edge
		queue.add(source);
		//System.out.println(queue);
		visited[source[0]][source[1]] = true;
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			
			for (int[] dir : dirs) {
				int nx = x+dir[0];
				int ny = y+dir[1];
				if(nx<map.length && ny<map[0].length && nx>=0 && ny>=0 && visited[nx][ny]==false && map[nx][ny]!=0){
					visited[nx][ny] = true;
					path.put(new Integer[]{nx,ny},new Integer[]{x,y} );
					int[] tmp = {nx,ny};
					queue.add(tmp);
					
				}
			}
		}
		Iterator<Map.Entry<Integer[], Integer[]>> iterator2 = path.entrySet().iterator();
		while(iterator2.hasNext()){
			Entry<Integer[], Integer[]> entry = iterator2.next();
			Integer[] to  = entry.getKey();
			Integer[] from	= entry.getValue();
			System.out.print("{"+from[0]+","+from[1]+"}->"+"{"+to[0]+","+to[1]+"} ");
		}
		System.out.println();
		
		//Get the path from source to target
		Integer[] location = new Integer[2] ;
		location[0] = target[0];
		location[1] = target[1];
		Iterator<Map.Entry<Integer[], Integer[]>> iterator3 ;
		while(true){		
			iterator3 = path.entrySet().iterator();
			while(iterator3.hasNext()){
				Entry<Integer[], Integer[]> entry = iterator3.next();
				Integer[] to  = entry.getKey();
				if(to[0]==location[0] && to[1] == location[1]){
					location = entry.getValue();
					break;
				}	
			}
			if(location[0] == target[0] && location[1] == target[1]) break;
			list.add(location[0]+","+location[1]);
			//System.out.println(location[0]+","+location[1]);
			if(location[0] == source[0] && location[1] == source[1]) break;
		}
		//Convert int[] to Integer[]
		int data[] = null;
		Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
		
		if(list.isEmpty()) System.out.println("-1");
		//System.out.println(location.getClass().getName());
		return list;
	}

}
