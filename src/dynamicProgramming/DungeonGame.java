package dynamicProgramming;

public class DungeonGame {
	//do from end to front
	public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        if(n==0)
            return 0;
        int m=dungeon[0].length;
        int[][] dp=new int[n][m];
        for(int i=n-1;i>-1;i--)
            for(int j=m-1;j>-1;j--){
                if(i==n-1 && j==m-1)
                    dp[i][j]=Math.max(1, 1-dungeon[i][j]);
                else if(i==n-1 && j!=m-1)
                    dp[i][j]=Math.max(1, dp[i][j+1]-dungeon[i][j]);
                else if(i!=n-1 && j==m-1)
                    dp[i][j]=Math.max(1, dp[i+1][j]-dungeon[i][j]);
                else{
                    dp[i][j]=Math.max(1, Math.min(dp[i+1][j]-dungeon[i][j], dp[i][j+1]-dungeon[i][j]));
                }
            }
        return dp[0][0];
	}
	//do from front to end, is wrong, not greedy
	public int calculateMinimumHP1(int[][] dungeon) {
        int n=dungeon.length;
        if(n==0)
            return 0;
        int m=dungeon[0].length;
        int[][] dpcur=new int[n][m];
        int[][] dpprev=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dpcur[i][j]=dungeon[0][0];
                    dpprev[i][j]=dungeon[0][0];
                }
                else if(i==0 && j!=0){
                    dpcur[i][j]=dpcur[i][j-1]+dungeon[i][j];
                    dpprev[i][j]=Math.min(dpprev[i][j-1],dpcur[i][j]);
                }
                else if(i!=0 && j==0){
                    dpcur[i][j]=dpcur[i-1][j]+dungeon[i][j];
                    dpprev[i][j]=Math.min(dpprev[i-1][j],dpcur[i][j]);
                }
                else{
                    int upprev=Math.min(dpprev[i-1][j],dpcur[i-1][j]+dungeon[i][j]);
                    int leftprev=Math.min(dpprev[i][j-1],dpcur[i][j-1]+dungeon[i][j]);
                    if(upprev>leftprev){
                        dpcur[i][j]=dpcur[i-1][j]+dungeon[i][j];
                        dpprev[i][j]=upprev;
                    }
                    else if(upprev<=leftprev){
                        dpcur[i][j]=dpcur[i][j-1]+dungeon[i][j];
                        dpprev[i][j]=leftprev;
                    }
                }
            }
        if(dpprev[n-1][m-1]<0)
            return -dpprev[n-1][m-1]+1;
        else
            return 1;
	}
	public static void main(String[] args){
		DungeonGame DG=new DungeonGame();
		int[][] dungeon={{0}};
		System.out.print(DG.calculateMinimumHP(dungeon));
	}
}
