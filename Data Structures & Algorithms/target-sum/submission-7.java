class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int totalLength = sum*2+1;
        System.out.println("Total length is " + totalLength);
        int[] dp = new int[totalLength];
        dp[sum+nums[0]]+=1;
        dp[sum-nums[0]]+=1;
        for(int i = 1; i < nums.length; i++){
            int[] next = new int[totalLength];
            for(int j = 0; j < totalLength; j++){
                if(dp[j] > 0){
                    if(j+nums[i] < totalLength){
                        next[j+nums[i]] += dp[j];
                    }
                    if(j-nums[i] >= 0){
                        next[j-nums[i]] += dp[j];
                    }
                }
            }
            dp = next;
        }
        if(sum+target< totalLength){
            return dp[sum+target];
        }
        return 0;
    }
}
