package graphs;

import java.util.Arrays;

import org.junit.Test;

public class GraphTest {

	@Test
	public void graphTest()
	{
		Graph graph = new Graph();
		
		graph.addVertex("A"); //0
		graph.addVertex("B"); //1
		graph.addVertex("C"); //2
		graph.addVertex("D"); //3
		graph.addVertex("E"); //4
		graph.addVertex("F"); //5
		graph.addVertex("G"); //6
		graph.addVertex("H"); //7
		
		graph.addEdge(0, 1); //A -- B
		graph.addEdge(1, 2); //B -- C
		graph.addEdge(1, 7); //B -- H
		graph.addEdge(2, 4); //C -- E
		graph.addEdge(2, 3); //C -- D
		graph.addEdge(4, 7); //E -- H
		graph.addEdge(4, 5); //E -- F
		graph.addEdge(4, 6); //E -- G
		
		//System.out.println(Arrays.toString(graph.adjList));
		
		graph.bfs();
	}
}
