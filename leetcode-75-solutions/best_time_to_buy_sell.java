/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Solution:

Max profit is achieved by highest price on sell day and lowest price on buy day, so take 2 variables, representing maximum profit and minimum cost,
iterate through the values. If min value is found on another day, replace it. If the current value - minvalue is greater than previous profits, replace 
maxprofit

*/
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int prof = 0;
        for(int i: prices)
        {
            min = Math.min(i, min);
            prof = Math.max(i-min, prof);
        }
        return prof;
    }
}
