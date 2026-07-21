class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int currentProduct = nums[0];
        for(int i = 1; i < nums.length; i++){
            int previousMax = currentMax;
            //System.out.println("Current Max is " + currentMax + " current min is " + currentMin + " nums[i] is " + nums[i]);
            currentMax = Math.max(nums[i], Math.max(previousMax * nums[i], currentMin * nums[i]));
            //System.out.println("Calc min between " + (previousMax *nums[i]) + " and " + (currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(previousMax * nums[i], currentMin * nums[i]));
            //System.out.println("Current Max is " + currentMax + " current min is " + currentMin + " current global is " + globalMax);
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
