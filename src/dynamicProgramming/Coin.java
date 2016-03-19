package dynamicProgramming;
//有面值1,3,5元硬币若干，如何用最少硬币数量凑够11元
public class Coin {
	public int coin(int total, int[] coins){
		int[] num=new int[total+1];
		for(int i=0;i<num.length;i++){
			if(i==0)
				num[i]=0;
			else
				num[i]=Integer.MAX_VALUE-10;
			for(int j=0;j<coins.length;j++){
				if(i>=coins[j])
					num[i]=Math.min(num[i-coins[j]]+1,num[i]);
			}
		}
		return num[total];
	}
	
	public static void main(String[] args){
		Coin coincount=new Coin();
		int[] coins={2,3,5};
		System.out.print(coincount.coin(11,coins));
	}

}
