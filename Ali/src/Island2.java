import java.util.ArrayList;
import java.util.List;

/** 
* @author ZYJ 
* @version 创建时间：Jul 25, 2017 4:40:38 AM 
* @Details 
* 给出一个m行n列的网格地图，每个位置为0或1，0表示海水1表示陆地。
* 一开始地图全为0（没有陆地）。每次在一个位置加入一块陆地，返回此时地图中陆地的总块数（相邻陆地统计时为同一块陆地）。
*  
* 对于一个静态的地图，统计岛屿个数可以使用dfs（类似于寻找一个图中的连通块个数），算法复杂度是O(m*n)。但是对于一个不断更新的地图，
* 如果我们每次重新统计连通块个数，复杂度为O(m*n*k)，其中k为总操作个数。考虑到每次只有一个位置发生变化（从0变为1），
* 完全不必重新统一，该陆地的产生职能影响周围四个位置。假设该陆地周围有t（p至多为4）个不连通的岛屿，
* 那么该陆地为把这四个不同点岛屿合并为一个岛屿，使得总岛屿数下降t-1个。因此我们需要维护岛屿之间的连通性，
* 自然的我们想到了并查集。并查集是一种解决此类问题的强力数据结构，以此题为例，初始时每个位置都是独立的、互不连通的，
* 每个位置都有一个标签来identify自己，记录在fa数组中，fa[i]为i。当两个位置p、q相邻且都为1时，
* 这两个位置需要统一它们的标签（表示这两个岛屿合并），即fa[p] = q。但是p、q的标签可能已经被修改，
* 因此我们需要通过getfather函数递归找到它们的真实标签（getfather(i)的返回值也称为i的祖先），
* 合并操作变为fa[getfather(p)] = getfather(q)。为了防止最坏情况下每次调用getfather函数都要经过m*n次递归，
* 我们可以采用路径压缩的方法（详见代码中getfather函数），使得每个
* 位置到其祖先的距离始终为一个很小的常数（与m、n无关）。本题中总体时间复杂度为O(m*n+k)，其中每次并查集的查询复杂度为一个常数（不超过4）。
*/
public class Island2 {
	public List<Integer> countIsland(int m ,int n ,int[][] position){
		boolean map[][] = new boolean[m][n];
		int[][] dir	= {{1,0},{0,1},{0,-1},{-1,0}};
		List<Integer> list = new ArrayList<>();
		int island = 0;
		int[] fa = new int[n*m];
		for(int i=0;i<m*n;i++){
			fa[i] = i;
		}
		
		for(int i =0;i<position.length;i++){
			island++;
			map[position[i][0]][position[i][1]] = true;
			int f = position[i][0]*n+position[i][1];
			int x,y;
			for(int j=0;j<4;j++ ){
				x = position[j][0] + dir[j][0];
				y = position[j][1] + dir[j][1];
				if(x>=0&&x<n && y>=0 && y<n && map[x][y]==true && getfa(fa,x*n+y)!=f){
					fa[getfa(fa,x*n+y)] = f;
					island--;
				}
			}
			list.add(island);
		}
		return list;
		
	}
	public static int getfa(int[] fa, int i){
		if(fa[i]==i) return i;
		return fa[i] = getfa(fa, fa[i]);
		
	}
}
