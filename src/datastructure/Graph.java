package datastructure;
//implement undirected graph first
import java.util.ArrayList;

public class Graph {
	public int MAX_VERTS = 20; 
	public Vertex vertexList[];
	public int nVerts = 0;
	
	public Graph(){
		vertexList=new Vertex[MAX_VERTS];
	}
	public Graph(int n){  
        vertexList = new Vertex[n];
	}
	public void addVertex(Vertex vertex){  
        vertex.setIndex(nVerts);  
        vertexList[nVerts] = vertex;  
        nVerts++;  
    }
	public void addEdge(int start, int end){  
        vertexList[start].addAdj(vertexList[end]);  
        vertexList[end].addAdj(vertexList[start]);  
    }
	public int getVertsCount(){  
        return vertexList.length;  
    }
	
	
	public static void main(String[] args) {  
        int nVerts = 10;  
        int v = 'A'-1;  
        Vertex vertex;  
        Graph myGraph = new Graph(nVerts);  
        for (int i = 0; i < nVerts; i++) {  
            v++;  
            vertex = new Vertex(v);  
            myGraph.addVertex(vertex);  
        }  
        myGraph.addEdge(0, 1);  
        myGraph.addEdge(0, 4);  
        myGraph.addEdge(1, 2);  
        myGraph.addEdge(2, 3);  
        myGraph.addEdge(4, 5);  
        myGraph.addEdge(4, 6);  
        myGraph.addEdge(5, 8);  
        myGraph.addEdge(6, 7);  
        myGraph.addEdge(7, 8);  
        myGraph.addEdge(8, 9);
        
        for(int i=0;i<myGraph.nVerts;i++){
            System.out.println(myGraph.vertexList[i].toString());
        	
        }
	}

}

class Vertex{  
    public int value;
    public int index;  
    public boolean isVisited=false;
    public ArrayList<Vertex> Adj = null;  
    public Vertex(int value)  // constructor  
    {     
        this.value=value;
    }  
    //为节点添加邻接点  
    public void addAdj(Vertex ver){  
        if(Adj == null) Adj = new ArrayList<Vertex>();  
        Adj.add(ver);  
    }  
      
    public ArrayList<Vertex> getAdj(){  
        return Adj;  
    }  
      
    public void setIndex(int index){  
        this.index = index;  
    }  
      
    public String printnode(){  
        return "index "+index+" value "+value;
    }  
}  