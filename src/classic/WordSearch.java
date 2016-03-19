package classic;
//Given a 2D board and a word, find if the word exists in the grid.
import java.util.List;
import java.util.ArrayList;
public class WordSearch {
	//DFS with return which indicate false or ture
	public boolean exist(char[][] board, String word) {
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++){
				boolean[][] boardpath=new boolean[board.length][board[0].length];
				if(dfs(board, boardpath, word, i, j, 0))
					return true;
			}
		return false;
	}
	boolean dfs(char[][] board, boolean[][] boardpath, String word, int i, int j, int at){
		if(at==word.length())
			return true;
		if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1)
			return false;
		if(boardpath[i][j]==false && word.charAt(at)==board[i][j]){
			boardpath[i][j]=true;
			boolean d1=dfs(board, boardpath, word, i+1, j, at+1);
			boolean d2=dfs(board, boardpath, word, i-1, j, at+1);
			boolean d3=dfs(board, boardpath, word, i, j+1, at+1);
			boolean d4=dfs(board, boardpath, word, i, j-1, at+1);
			if(d1 || d2 || d3 || d4)
				return true;
			else
				boardpath[i][j]=false;
		}
		return false;
	}
	//Given words = ["oath","pea","eat","rain"] and You would need to optimize your backtracking to pass the larger test.
	//you could stop backtracking immediately. Does a hash table work? Why or why not? How about a Trie?
	//or you can use a arraylist to restore unpass words
	public List<String> findWords(char[][] board, String[] words) {
		ArrayList<String> unexist=new ArrayList<String>();
		ArrayList<String> existwords=new ArrayList<String>();
		for(int i=0;i<words.length;i++){
			if(unexist.contains(words[i]) && exist(board, words[i]))
				existwords.add(words[i]);
			else
				unexist.add(words[i]);
		}
		return existwords;
		
	}

}
