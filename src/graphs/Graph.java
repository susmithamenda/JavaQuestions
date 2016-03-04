package graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	Vertex[] vertexList; 
	Stack<Integer> stack;
	Queue<Integer> queue;
	int[][] adjList;
	int vertexCount;
	int maxVertices  = 8;
	
	Graph(){
		vertexList = new Vertex[maxVertices];
		adjList = new int[maxVertices][maxVertices];
		stack = new Stack<Integer>();
		queue = new LinkedList<Integer>();
		vertexCount = 0;
		for(int i = 0 ; i < maxVertices ; i++){
			for ( int j  = 0 ; j < maxVertices ; j++){
				adjList[i][j] = 0;
			}
		}
	}
	
	public void addVertex(String label)
	{
		Vertex vertex = new Vertex(label);
		vertexList[vertexCount++] = vertex;
	}
	
	public void addEdge(int start, int end)
	{
		adjList[start][end] = 1;
		adjList[end][start] = 1;
	}

	public void display(int v)
	{
		System.out.println("Vertex is: " + vertexList[v].label);
	}
	
	public void dfs()
	{
		vertexList[0].visited = true;
		display(0);
		stack.push(0);
		
		while(!stack.isEmpty())
		{
			int v = getAdjUnvisitedVertex(stack.peek());
			if(v == -1)
			{
				stack.pop();
			}else
			{
				vertexList[v].visited = true;
				display(v);
				stack.push(v);
			}
		}
		for(int j = 0 ; j < vertexCount; j++){
			vertexList[j].visited = false;
		}
		
	}

	public void bfs()
	{
		vertexList[0].visited = true;
		display(0);
		queue.add(0);
		
		int v2;
		
		while(!queue.isEmpty())
		{
			int v1 = queue.remove();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1){
				vertexList[v2].visited = true;
				display(v2);
				queue.add(v2);
			}
		}
		
	}
	private int getAdjUnvisitedVertex(int peek) 
	{
		for(int j = 0; j < vertexCount;  j++)
		{
			if( adjList[peek][j] == 1 && vertexList[j].visited == false)
			{
				return j;
			}
		}
		return -1;
	}
	
	
}
