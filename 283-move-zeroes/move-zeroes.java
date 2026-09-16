class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }
    }
}