class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            dp[i][i] = nums[i];
            if(dp[i][i] > max){
                max = dp[i][i];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                dp[i][j] = dp[i][j-1] * nums[j];
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }   
        return max;
    }
}
