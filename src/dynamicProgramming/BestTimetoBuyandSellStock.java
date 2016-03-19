package dynamicProgramming;
//Say you have an array for which the ith element is the price of a given stock on day i.
//Based on different conditons, design an algorithm to find the maximum profit.
public class BestTimetoBuyandSellStock {
	//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
    public int maxProfit(int[] prices) {
    	if(prices.length==0)
    		return 0;
    	int[] best=new int[prices.length];
    	int low=prices[0];
    	for(int i=0;i<prices.length;i++){
    		best[i]=prices[i]-low;
    		if(prices[i]<low)
    			low=prices[i];
    	}
    	int max=0;
    	for(int i=0;i<best.length;i++){
    		max=Math.max(max, best[i]);
    	}
    	return max;
    }
    //You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
    //However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    public int maxProfit2(int[] prices) {
    	int profit=0;
    	for(int i=1;i<prices.length;i++){
    		if(prices[i]-prices[i-1]>0)
    			profit=profit+(prices[i]-prices[i-1]);
    	}
    	return profit;
    }
    //You may complete at most k transactions.
    public int maxProfit4(int k, int[] prices) {
    	if (prices.length < 2 || k <= 0)
    		return 0;
    	if(k>prices.length/2){
        	int profit=0;
        	for(int i=1;i<prices.length;i++){
        		if(prices[i]-prices[i-1]>0)
        			profit=profit+(prices[i]-prices[i-1]);
        	}
        	return profit;
    	}
    	int[] local = new int[k];
    	int[] global = new int[prices.length];
    	for(int i=0;i<prices.length-1;i++){
    		int diff=prices[i+1]-prices[i];
    		for(int j=k;j>0;j--){
    			local[j]=Math.max(local[j]+diff, global[j-1]+Math.max(diff, 0));
    			global[j]=Math.max(local[j], global[j]);
    		}
    	}
    	return global[k];
    }
    public static void main(String[] args){
    	BestTimetoBuyandSellStock stock=new BestTimetoBuyandSellStock();
    	int[] prices={1,2};
    	int k=1;
    	System.out.print(stock.maxProfit4(k,prices));
    	//System.out.print(stock.maxProfit(prices));
    }
}
