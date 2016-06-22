/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int res = 0;
        int low = prices[0];
        int high = prices[0];
        
        int i = 1;
        while (i < prices.length) {
            while (i < prices.length && prices[i - 1] >= prices[i]) i++;
            low = prices[i - 1];
            
            while (i < prices.length && prices[i - 1] <= prices[i]) i++;
            high = prices[i - 1];
            res += high - low;
        }
        
        return res;
    }
}
