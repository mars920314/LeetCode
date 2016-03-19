package DfsBfs;
//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
public class SurroundedRegions {
	//because use DFS, wrong. Line 37: java.lang.StackOverflowError
	//at least has 200*200 stack, must overflow
	public void solve1(char[][] board) {
        if(board.length==0)
            return;
        int[][] isVisited=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='O' && isVisited[i][j]==0)
                dfsO(board,isVisited,i,j,true);
            isVisited[i][j]=1;
        }
    }
    boolean dfsO(char[][] board, int[][]isVisited, int i, int j, boolean modify){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return true;
        if(isVisited[i][j]!=0 || board[i][j]=='X'){
        	isVisited[i][j]=1;
        	return true;
        }
        else{
            if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1)
                modify=false;
            isVisited[i][j]=2;
            modify=modify && dfsO(board,isVisited,i+1,j,modify);
            modify=modify && dfsO(board,isVisited,i-1,j,modify);
            modify=modify && dfsO(board,isVisited,i,j+1,modify);
            modify=modify && dfsO(board,isVisited,i,j-1,modify);
        }
        if(modify && isVisited[i][j]==2){
            board[i][j]='X';
            isVisited[i][j]=1;
        }
        return modify;
    }
  //wrong. Line 37: java.lang.StackOverflowError    
	public void solve(char[][] board) {
		int x=board.length;
		if(x==0)
			return;
		int y=board[0].length;
		int[][] isVisited=new int[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++){
				if(board[i][j]=='O' && isVisited[i][j]==0){
					dfs(board, isVisited, i, j);
					flag=false;
				}
			}
	}
	boolean flag=false;
	void dfs(char[][] board, int[][] isVisited, int i, int j){
		if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1){
			return;
		}
		else if(board[i][j]=='X')
		    return;
		else{
			if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1)
				flag=true;
			if(flag && isVisited[i][j]!=1){
				isVisited[i][j]=1;
				board[i][j]='X';
			}
			else if(!flag && isVisited[i][j]==0)
    			isVisited[i][j]=2;
    		else
    		    return;
			dfs(board, isVisited, i-1, j);
			dfs(board, isVisited, i+1, j);
			dfs(board, isVisited, i, j-1);
			dfs(board, isVisited, i, j+1);
		}
	}
//unvisited 0
//visited	1
//near edge	2
	public static void main(String[] args){
		SurroundedRegions SR=new SurroundedRegions();
		char[][] board={{'X','X','X'},{'X','O','X'},{'X','O','X'}};
		SR.solve1(board);
	}
}
