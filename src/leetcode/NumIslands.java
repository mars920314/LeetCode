package leetcode;
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
//and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
import java.util.ArrayList;
public class NumIslands {
	public int numIslands1(char[][] grid) {
		if(grid.length==0)
			return 0;
		int num=0;
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='1'){
					num++;
					dfs(grid, i, j);
				}
			}
		return num;
	}
	void dfs(char[][] grid, int i, int j){
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) 
			return;
		if(grid[i][j]=='1'){
			grid[i][j]='0';
			dfs(grid,i-1,j);
			dfs(grid,i+1,j);
			dfs(grid,i,j-1);
			dfs(grid,i,j+1);
		}
	}
	public static void main(String[] args){
		//char[][] grid={{1,1,1,0},{1,1,0,0},{1,0,0,1},{0,0,1,1}};
		char[][] grid={{1}};
		NumIslands numislands=new NumIslands();
		System.out.print(numislands.numIslands(grid));
	}
    public int numIslands(char[][] grid) {
    	Vertex vertex;
    	if(grid.length==0)
    		return 0;
        Graph mygraph=new Graph(grid.length*grid[0].length);
        for(int i=0;i<grid.length;i++)
        	for(int j=0;j<grid[0].length;j++){
        		char value=grid[i][j];
        		vertex=new Vertex(value);
        		mygraph.addVertex(vertex);
        		if(i!=0 && value==grid[i-1][j])
        			mygraph.addEdge(mygraph.nVert-1, mygraph.nVert-1-grid[0].length);
        		if(j!=0 && value==grid[i][j-1])
        			mygraph.addEdge(mygraph.nVert-1,mygraph.nVert-1-1);
        	}
        
        int count=0;
        for(int i=0;i<mygraph.vertexlist.length;i++){
        	if(mygraph.vertexlist[i].isvisited==false && mygraph.vertexlist[i].value==1){
        		DFS(mygraph.vertexlist[i]);
        		count++;
        	}
        }
        return count;
    }
    public static void DFS(Vertex root){
    	ArrayList<Vertex> buffer=new ArrayList<Vertex>();
    	root.isvisited=true;
    	buffer.add(root);
    	while(!buffer.isEmpty()){
    		Vertex front=buffer.get(0);
    		buffer.remove(0);
    		ArrayList<Vertex> Adj=front.getAdj();
    		for(int i=0;i<Adj.size();i++){
    			if(!Adj.get(i).isvisited){
    				Adj.get(i).isvisited=true;
    				DFS(Adj.get(i));
    			}
    		}
    	}
    }
}
class Graph{
	public int MAX_vertex=20;
	public Vertex[] vertexlist;
	public int nVert=0;
	public Graph(){
		vertexlist=new Vertex[MAX_vertex];
	}
	public Graph(int num){
		vertexlist=new Vertex[num];
	}
	public void addVertex(Vertex vertex){
		vertex.setIndex(nVert);
		vertexlist[nVert]=vertex;
		nVert++;
	}
	public void addEdge(int start,int end){
		vertexlist[start].addAdj(vertexlist[end]);
		vertexlist[end].addAdj(vertexlist[start]);
	}
	public int getVertsCount(){
		return vertexlist.length;
	}
	
}
class Vertex{
	public char value;
	public int index;
	public boolean isvisited;
	public ArrayList<Vertex> Adj=new ArrayList<Vertex>();
	public Vertex(char value){
		this.value=value;
	}
	public void addAdj(Vertex vertex){
		if(Adj == null)
			Adj = new ArrayList<Vertex>();
		Adj.add(vertex);
	}
	public ArrayList<Vertex> getAdj(){
		return Adj;
	}
	public void setIndex(int index){
		this.index=index;
	}
}