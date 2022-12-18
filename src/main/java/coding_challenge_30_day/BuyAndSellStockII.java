package coding_challenge_30_day;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.<br/>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).<br/>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
 * before you buy again).<br/>
 *
 * @author sudhir on 21-Apr-2020
 */
public class BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int i = 0;
        int profit = 0;
        int buy = 0, sell = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            if (i == prices.length - 1) {
                break;
            }
            buy = i;
            i++;
            while (i < prices.length && prices[i] >= prices[i - 1]) {
                i++;
            }
            sell = i - 1;
            profit += prices[sell] - prices[buy];
        }
        return profit;
    }
}
