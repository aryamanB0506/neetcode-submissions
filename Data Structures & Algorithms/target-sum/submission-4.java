class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int totalLength = sum*2+1;
        System.out.println("Total length is " + totalLength);
        int[][] dp = new int[nums.length][totalLength];
        dp[0][sum+nums[0]]+=1;
        dp[0][sum-nums[0]]+=1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < totalLength; j++){
                // if(i==0){
                //     System.out.println("DP of 0 and " + (sum+nums[i]) + " before is " + dp[0][sum+nums[i]] + " for " + j);
                //     dp[0][sum+nums[i]] += 1;
                //     System.out.println("DP of 0 and " + (sum+nums[i]) + " after is " + dp[0][sum+nums[i]] + " for " + j);
                //     System.out.println("DP of 0 and " + (sum-nums[i]) + " before is " + dp[0][sum-nums[i]] + " for " + j);
                //     dp[0][sum-nums[i]] += 1;
                //     System.out.println("DP of 0 and " + (sum-nums[i]) + " after is " + dp[0][sum-nums[i]] + " for " + j);
                // }
                // else{
                    if(dp[i-1][j] > 0){
                        if(j+nums[i] < totalLength){
                            dp[i][j+nums[i]] += dp[i-1][j];
                        }
                        if(j-nums[i] >= 0){
                            dp[i][j-nums[i]] += dp[i-1][j];
                        }
                    }
                // }
            }
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < totalLength; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        if(sum+target< totalLength){
            return dp[nums.length-1][sum+target];
        }
        return 0;
    }
}
