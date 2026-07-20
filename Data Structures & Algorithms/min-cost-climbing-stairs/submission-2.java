class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        
        for(int i = 0; i < cost.length; i++){
            if(i==0){
                dp[0] = cost[0];
            }
            else if(i==1){
                dp[1] = cost[1];
            }
            else{
                dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i]);
            }
        }
        dp[cost.length] = Math.min(dp[cost.length-1], dp[cost.length-2]);
        return dp[cost.length];
    }
}
