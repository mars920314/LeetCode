package test;

import java.util.HashSet;
import java.util.Scanner;

public class ques10 {
	String solution(int[] a, int[] b, int[] c){
		int mintime=Integer.MAX_VALUE;
		int amax=0;
		HashSet<Integer> adict=new HashSet<Integer>();
		for(int i=0;i<a.length;i++){
			adict.add(a[i]);
			amax=Math.max(a[i], amax);
		}
		int[] dp=new int[amax+1];
		dp[0]=0;
		for(int i=1;i<dp.length;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<b.length;j++){
				if(i-b[j]>-1 && dp[i-b[j]]!=Integer.MAX_VALUE)
					dp[i]=Math.min(dp[i], dp[i-b[j]]+c[j]);
			}
			if(adict.contains(i)){
				mintime=Math.min(mintime, dp[i]);
			}
		}
		if(mintime==Integer.MAX_VALUE)
			return "It is not true!";
		else
			return String.valueOf(mintime);
	}
	public static void main(String[] args){
		ques10 Q=new ques10();
		int[] a={7,11};
		int[] b={3,2};
		int[] c={1,100};
		System.out.print(Q.solution(a, b, c));
	}
	public static void main1(String args[])
    {
		Scanner cin = new Scanner(System.in);
        int n, m;
        int count=0;
        n = cin.nextInt();
        int[] a=new int[n];
        while(n>0){
              n--;
              a[n]=cin.nextInt();
        }
        m = cin.nextInt();
        int[] b=new int[m];
        int[] c=new int[m];
        while(m>0){
              m--;
              b[m]=cin.nextInt();
              c[m]=cin.nextInt();
        }
        ques10 Q=new ques10();
        System.out.println(Q.solution(a,b,c));
    }

}
