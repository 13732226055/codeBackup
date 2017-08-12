package BFS;
/** 
* @author ZYJ 
* @version 创建时间：Jul 26, 2017 9:18:51 AM 
* @Details 
*/
public class Edge {
	public String fromVertex;
	public String toVertex;
	public Edge(String fromVertex,String toVertex) {
		this.fromVertex = fromVertex;
		this.toVertex	= toVertex;
	}
	@Override
	public String  toString() {
		return this.fromVertex+"-"+this.toVertex;
	}
}
