class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        for(int i = 0; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                // System.out.println("DP of " + j + " is " + dp[j]);
                if(j%coins[i] == 0){
                    dp[j] = Math.min(dp[j],j/coins[i]);
                    // System.out.println("Loop 1 : DP of " + j + " is now " + dp[j]);
                }
                if(dp[j-coins[i]]!= Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                    // System.out.println("Loop 2 : DP of " + j + " is now " + dp[j]);
                }
                // System.out.println("DP of " + j + " is now " + dp[j]);
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}
