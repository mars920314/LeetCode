package leetcode;
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach the 
//bottom-right corner of the grid (marked 'Finish' in the diagram below).How many possible unique paths are there?
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(i==0 && j==0)
        			dp[i][j]=1;
        		else if(i==0 && j!=0)
        			dp[i][j]=dp[i][j-1];
        		else if(j==0 && i!=0)
        			dp[i][j]=dp[i-1][j];
        		else
        			dp[i][j]=dp[i-1][j]+dp[i][j-1];
        	}
        }
        return dp[m-1][n-1];
    }
    //Now consider if some obstacles are added to the grids. How many unique paths would there be?
    //An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m=obstacleGrid.length;
    	int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(obstacleGrid[i][j]==1){
        			dp[i][j]=0;
        			continue;
        		}
        		if(i==0 && j==0)
        			dp[i][j]=1;
        		else if(i==0 && j!=0)
        			dp[i][j]=dp[i][j-1];
        		else if(j==0 && i!=0)
        			dp[i][j]=dp[i-1][j];
        		else
        			dp[i][j]=dp[i-1][j]+dp[i][j-1];
        	}
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
    	UniquePaths UP=new UniquePaths();
    	int[][] obstacleGrid={{0,0},{1,0}};
    	System.out.print(UP.uniquePathsWithObstacles(obstacleGrid));
    }
}
