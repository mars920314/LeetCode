package dynamicProgramming;
//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class ClimbingStairs {
    public int climbStairs1(int n) {
        if(n==1)	
        	return 1;
        if(n==2)
        	return 2;
        return climbStairs1(n-1)+climbStairs1(n-2);
    }
    public int climbStairs2(int n) {
    	int[] num=new int[n];
    	for(int i=0;i<n;i++){
    		if(i==0)
    			num[i]=1;
    		else if(i==1)
    			num[i]=2;
    		else
    			num[i]=num[i-1]+num[i-2];
    	}
    	return num[n-1];
    }

    public static void main(String[] args){
    	ClimbingStairs CS=new ClimbingStairs();
    	System.out.print(CS.climbStairs2(44));
    }
}
