package BFS;

import java.util.Stack;

/** 
* @author ZYJ 
* @version 创建时间：Jul 26, 2017 9:12:18 AM 
* @Details 
*/
public class testBFS {
	String[] vertex = {"North Gate", "South Gate", "Classroom", "Square", "Toilet", "Canteen"};
	Edge[] edges = {
	      new Edge("North Gate", "Classroom"),
	      new Edge("North Gate", "Square"),
	      new Edge("Classroom", "Toilet"),
	      new Edge("Square", "Toilet"),
	      new Edge("Square", "Canteen"),
	      new Edge("Toilet", "South Gate"),
	      new Edge("Toilet", "South Gate"),
	  };
	  public void testBFS() {
	    Graph g = new Graph(new BFS_shortest());
	    for (String v : vertex) {
			g.addVertex(v);
		}
	    for (Edge edge : edges) {
	    	System.out.println(edge);
			g.addEdge(edge.fromVertex, edge.toVertex);
		}
	    
	    g.done();
	    Stack<String> result = g.findPathTo("Canteen");
	    System.out.println("BFS: From [North Gate] to [Canteen]:");
	    while (!result.isEmpty()) {
	      System.out.println(result.pop());
	    }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testBFS t = new testBFS();
		t.testBFS();
	}

}
