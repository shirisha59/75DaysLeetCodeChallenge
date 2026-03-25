class Solution {
    public int maxProfit(int[] prices) {
        
        int max_profit=0;
        int buy_price=prices[0];
        int n=prices.length;
        for(int i=1;i<n;i++){
            int cur_profit=prices[i]-buy_price;
            if(cur_profit>max_profit){
                max_profit=cur_profit;
            }
            if(prices[i]<buy_price){
                buy_price=prices[i];
            }
        }
        return max_profit;
        
    }
}