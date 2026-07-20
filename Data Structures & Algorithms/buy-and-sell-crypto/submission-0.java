class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowest = Integer.MAX_VALUE;
        int current = 0;
        for(int i = 0; i < prices.length; i++){
            current = prices[i] - lowest;
            if(current > max){
                max = current;
            }
            if(prices[i]<lowest){
                lowest = prices[i];
            }
        }
        return max;
        
    }
}
