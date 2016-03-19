package dynamicProgramming;
//Regular Expression Matching
//failed, conditions is too complicated
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p){
		int m=s.length();
		int n=p.length();
		int[][] dp=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				if(s.charAt(i)=='*'){
					if(dp[i-1][j-1]==1 || dp[i-1][j]==1 || dp[i][j-1]==1)
						dp[i][j]=1;
					else
						dp[i][j]=0;
				}
				else if(s.charAt(i)=='.'){
					if(i==0)
						dp[i][j]=1;
					else if(dp[i-1][j-1]==1)
						dp[i][j]=1;
					else
						dp[i][j]=0;
					
				}else{
					if(i==0 && s.charAt(i)==p.charAt(0))
						dp[i][j]=1;
					else if(dp[i-1][j-1]==1 && s.charAt(i)==p.charAt(j))
						dp[i][j]=1;
					else
						dp[i][j]=0;
				}
			}
		if(dp[n-1][m-1]==1 && m!=0 && n!=0)
			return true;
		else 
			return false;
	}

}
