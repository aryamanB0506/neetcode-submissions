class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> locations = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(locations.containsKey(target-nums[i])){
                return new int [] {locations.get(target-nums[i]), i};
            }
            locations.put(nums[i],i);
        }
        return new int [] {0,0};
    }
}
