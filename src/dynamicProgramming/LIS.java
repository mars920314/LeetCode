package dynamicProgramming;

import java.util.Arrays;

//longest increasing subsequence. 给出n个数，求出其最长不下降子序列的长度，比如n=5，5个数是{4,6,5,7,3}；其最长不下降子序列就是{4,6,7}，长度为3。
public class LIS {
	public int lis(int[] sequence){
		//time: O(n^2)
		int[] subnum=new int[sequence.length];
		for(int i=0;i<subnum.length;i++){
			subnum[i]=1;
			for(int j=0;j<i;j++){
				if(sequence[i]>sequence[j] && subnum[i]<(subnum[j]+1))
					subnum[i]=subnum[j]+1;
			}
		}
		//System.out.print(Arrays.toString(subnum));
		int maxn=0;
		for(int i=0;i<subnum.length;i++)
			if(subnum[i]>subnum[maxn])
				maxn=i;
		return subnum[maxn];
	}
	public int lis_noDP(int[] sequence){
		//time: O(nlogn)
		int[] subnum=new int[sequence.length];
		int subnumindex=0;
		for(int i=0;i<subnum.length;i++){
			if(i==0)
				subnum[subnumindex++]=sequence[i];
			else if(sequence[i]>subnum[subnumindex-1]){
				subnum[subnumindex++]=sequence[i];
			}else{
				for(int j=subnumindex-1;j>-1;j--){
					if(sequence[i]<subnum[j])
						subnum[j]=sequence[i];
				}
			}
		}
		return subnumindex;
	}
	
	public static void main(String args[]){
		LIS lis=new LIS();
		int[] sequence={5,3,4,8,6,7};
		System.out.print(lis.lis_noDP(sequence));
	}

}
