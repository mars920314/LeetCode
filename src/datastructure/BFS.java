package datastructure;
import java.util.ArrayList;

import datastructure.Graph;

public class BFS {
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
        bfs(myGraph.vertexList[0]);
        for(int i=0;i<myGraph.nVerts;i++){
            //System.out.println(myGraph.vertexList[i].printnode());        	
        }
        
        Vertex vert;  
        Graph Gra = new Graph(nVerts);
        for (int i = 0; i < nVerts; i++) {  
            v++;  
            vert = new Vertex(v);  
            Gra.addVertex(vert);  
        }  
        Gra.addEdge(0, 1);  
        Gra.addEdge(0, 4);  
        Gra.addEdge(1, 2);  
        Gra.addEdge(2, 3);  
        Gra.addEdge(4, 5);  
        Gra.addEdge(4, 6);  
        Gra.addEdge(5, 8);  
        Gra.addEdge(6, 7);  
        Gra.addEdge(7, 8);  
        Gra.addEdge(8, 9);
	}
	
	public static void bfs(Vertex root){
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
					buffer.add(front.Adj.get(i));
				}
			}
		}
	}

}
