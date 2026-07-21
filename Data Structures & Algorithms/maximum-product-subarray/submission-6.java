class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int currentProduct = nums[0];
        for(int i = 1; i < nums.length; i++){
            int previousMax = currentMax;
            currentMax = Math.max(nums[i], Math.max(previousMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(previousMax * nums[i], currentMin * nums[i]));
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
