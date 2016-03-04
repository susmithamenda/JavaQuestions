package graphs;

public class Vertex {

	public String label;
	public boolean visited;
	
	Vertex(String name){
		this.label = name;
		this.visited = false;
	}
}
