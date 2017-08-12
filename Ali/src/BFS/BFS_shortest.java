/** 
* @author ZYJ 
* @version 创建时间：Jul 26, 2017 8:55:03 AM 
* @Details 
*/
package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS_shortest implements Algorithm {
  // 保存已经访问过的地点
  private List<String> visitedVertex;
  // 保存最短路径
  private Map<String, String> path;
  @Override
  public void perform(Graph g, String sourceVertex) {
    if (null == visitedVertex) {
      visitedVertex = new ArrayList<>();
    }
    if (null == path) {
      path = new HashMap<>();
    }
    BFS(g, sourceVertex);
  }
  @Override
  public Map<String, String> getPath() {
    return path;
  }
  private void BFS(Graph g, String sourceVertex) {
    Queue<String> queue = new LinkedList<>();
    // 标记起点
    visitedVertex.add(sourceVertex);
    // 起点入列
    queue.add(sourceVertex);
    while (false == queue.isEmpty()) {
      String ver = queue.poll();
      List<String> toBeVisitedVertex = g.getAdj().get(ver);
      for (String v : toBeVisitedVertex) {
        if (false == visitedVertex.contains(v)) {
          visitedVertex.add(v);
          path.put(v, ver);
          queue.add(v);
        }
      }
    }
  }
}