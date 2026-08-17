class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int buy = -prices[0];
        int sell = 0;
        int rest = 0;

        for(int i=1; i<prices.length; i++){
            int prevBuy = buy;
            int prevSell = sell;
            int prevRest = rest;

            buy = Math.max(prevBuy, prevRest-prices[i]);
            sell = prevBuy+prices[i];
            rest = Math.max(prevRest, prevSell);
        }
        return Math.max(sell,rest);
    }
}