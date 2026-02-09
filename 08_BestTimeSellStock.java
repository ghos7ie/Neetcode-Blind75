class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int pt1 = 0, pt2 = 1;

        while (pt2 < prices.length) {
            if (prices[pt1] < prices[pt2]) {
                maxProfit = Math.max(maxProfit, prices[pt2] - prices[pt1]);
            } else {
                pt1 = pt2;
            }
            pt2++;
        }
        return maxProfit;
    }
}
