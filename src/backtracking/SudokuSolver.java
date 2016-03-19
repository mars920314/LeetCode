package backtracking;

import java.util.Arrays;

//Write a program to solve a Sudoku puzzle by filling the empty cells.
//Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
public class SudokuSolver {
	//BFS
	public void solveSudoku(char[][] board) {
		//solve(board);
		System.out.print(solve(board));
	}
	public boolean solve(char[][] board){
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				if(board[i][j]=='.'){
					for(char k='1';k<='9';k++){
						board[i][j]=k;
						if(isValid(board, i, j) && solve(board))
							return true;
						else
							board[i][j]='.';
					}
					return false;
				}
			}
		return true;
	}
	public boolean isValid(char[][] board, int i, int j){
		//check row
		int[] rowcheck=new int[9];
		for(int row=0;row<9;row++){
			if(board[row][j]=='.')
				continue;
			else if(rowcheck[Integer.valueOf(board[row][j])-'1']==0)
				rowcheck[Integer.valueOf(board[row][j])-'1']=board[row][j];
			else
				return false;
		}
		//check col
		int[] colcheck=new int[9];
		for(int col=0;col<9;col++){
			if(board[i][col]=='.')
				continue;
			else if(colcheck[Integer.valueOf(board[i][col])-'1']==0)
				colcheck[Integer.valueOf(board[i][col])-'1']=board[i][col];
			else
				return false;
		}
		//check sqare
		int[] sqarecheck=new int[9];
		for(int x=i/3*3;x<i/3*3+3;x++)
			for(int y=j/3*3;y<j/3*3+3;y++){
				if(board[x][y]=='.')
					continue;
				else if(sqarecheck[Integer.valueOf(board[x][y])-'1']==0)
					sqarecheck[Integer.valueOf(board[x][y])-'1']=board[x][y];
				else
					return false;
			}
		return true;
	}
	public static void main(String[] args){
		char[][] board={"..9748...".toCharArray(),"7........".toCharArray(),".2.1.9...".toCharArray(),"..7...24.".toCharArray(),".64.1.59.".toCharArray(),".98...3..".toCharArray(),"...8.3.2.".toCharArray(),"........6".toCharArray(),"...2759..".toCharArray()};
		SudokuSolver SS=new SudokuSolver();
		SS.solveSudoku(board);
		System.out.print(board[0][0]);
	}

}
