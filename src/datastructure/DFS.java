package datastructure;

import java.util.ArrayList;

public class DFS {
	public static void main(String[] args){
		int nVerts = 9;  
        int v = 'A'-1;  
        Vertex vertex;  
        Graph myGraph = new Graph(nVerts);  
        for (int i = 0; i < nVerts; i++) {  
            v++;  
            vertex = new Vertex(v);  
            myGraph.addVertex(vertex);  
        }  
        myGraph.addEdge(0, 1);  
        myGraph.addEdge(0, 3);  
        myGraph.addEdge(0, 8);  
        myGraph.addEdge(1, 7);  
        myGraph.addEdge(2, 7);  
        myGraph.addEdge(2, 5);  
        myGraph.addEdge(2, 3);  
        myGraph.addEdge(3, 4);  
        myGraph.addEdge(4, 8);  
        myGraph.addEdge(5, 6);
        dfs(myGraph.vertexList[0]);
        for(int i=0;i<myGraph.nVerts;i++){
            //System.out.println(myGraph.vertexList[i].printnode());        	
        }
	}

	public static void dfs(Vertex root) {
		ArrayList<Vertex> buffer=new ArrayList<Vertex>();
		root.isVisited=true;
		buffer.add(root);
		while(!buffer.isEmpty()){
			Vertex front=buffer.get(0);
			buffer.remove(0);
			for(int i=0;i<front.Adj.size();i++){
				if(!front.Adj.get(i).isVisited){
					front.Adj.get(i).isVisited=true;
					System.out.println(front.Adj.get(i).printnode());
					dfs(front.Adj.get(i));
				}
			}
		}
	}

}
