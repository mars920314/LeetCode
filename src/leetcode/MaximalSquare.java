package leetcode;
//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
import java.lang.Math;
public class MaximalSquare {
	//easy to implement
	public int maximalSquare(char[][] matrix){
		int m=matrix.length;
		if(m==0)
			return 0;
    	int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(i==0 || j==0)
        			if(matrix[i][j]=='1')
        				dp[i][j]=1;
        			else
        				dp[i][j]=0;
        		else{
        			if(matrix[i][j]=='1')
        				dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
        			else
        				dp[i][j]=0;
        		}
        	}
        }
        int max=0;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		max=Math.max(max, dp[i][j]);
        	}
        }
        return max*max;
	}
	//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
	public int maximalRectangle(char[][] matrix){
		int m=matrix.length;
		if(m==0)
			return 0;
    	int n=matrix[0].length;
        int[][] horizon=new int[m][n];
        int[][] vertical=new int[m][n];
        int[][] rectangle=new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		//horizon
        		if(j==0)
        			horizon[i][j]=judge(matrix[i][j]);
        		else
        			if(matrix[i][j]=='1')
        				horizon[i][j]=horizon[i][j-1]+1;
        			else
        				horizon[i][j]=0;
        		//vertical
        		if(i==0)
        			vertical[i][j]=judge(matrix[i][j]);
        		else
        			if(matrix[i][j]=='1')
        				vertical[i][j]=vertical[i-1][j]+1;
        			else
        				vertical[i][j]=0;
        		//rectangle
        		int maxrect=0;
        		int h=i-vertical[i][j]+1;
        		for(int v=0;v<horizon[i][j];v++){
        			if(matrix[h][j-v]=='0' || i-h>=vertical[i][j-v]){
        				h++;
        				v--;
        				if(h>i)
        					break;
        				else
        					continue;
        			}
        			else{
        				maxrect=Math.max(maxrect, (v+1)*(i-h+1));
        			}
        		}
        		rectangle[i][j]=maxrect;
        		System.out.println(rectangle[i][j]);
        	}
        }
        int max=0;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		max=Math.max(max, rectangle[i][j]);
        	}
        }
        return max;
	}
	int judge(char ch){
		if(ch=='0')
			return 0;
		else if(ch=='1')
			return 1;
		else
			return -1;
	}
	public static void main(String[] args){
		char[][] matrix={{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'}};
		char[][] matrix1={{'1','1','0','1'},{'1','1','0','1'},{'1','1','1','1'}};
		char[][] matrix2={{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}};
		MaximalSquare MS=new MaximalSquare();
//		System.out.print(MS.maximalSquare(matrix));
		System.out.print(MS.maximalRectangle(matrix2));
	}

}
