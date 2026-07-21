class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int center = (right-left)/2 + left;
            int current = nums[center];
            if(current==target){
                return center;
            }
            else if(current < target){
                left= center+1;
            }
            else if (current > target){
                right = center-1;
            }
            // else{
            //     return -1;
            // }
        }
        return -1;
    }
}
