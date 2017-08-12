package BFS;

import java.util.Map;

/** 
* @author ZYJ 
* @version 创建时间：Jul 26, 2017 8:59:34 AM 
* @Details 
*/
public interface Algorithm {
	  /**
	   * 执行算法
	   */
	  void perform(Graph g, String sourceVertex);
	  /**
	   * 得到路径
	   */
	  Map<String, String> getPath();
}
