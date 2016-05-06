package q121;

public class BestTimetoBuyandSellStock {
	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i.

       If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	 */
	
	public static int maxProfit(int[] prices) {
		/*****************采用两个变量保存最低买入价格和最高利润*****************/
		if(null == prices || prices.length < 2){
			return 0;
		}
		int maxProfit = 0, buyPrice = Integer.MAX_VALUE;
		for(int i=0; i<prices.length; i++){
			if(buyPrice > prices[i]){
				buyPrice = prices[i];
			}else if(maxProfit < prices[i] - buyPrice){
				maxProfit = prices[i] - buyPrice;
			}
		}
        return maxProfit;
    }

	public static void main(String[] args){
		int[] prices = {1,2};
		System.out.println(maxProfit(prices));
	}
}
